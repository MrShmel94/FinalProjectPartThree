package dao;

import entity.User;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UserDao implements Dao <Integer, User>{

    private static final UserDao INSTANCE = new UserDao();

    private static final String SQL_SAVE = """
    INSERT INTO users(name, email, password, win_game, lose_game) VALUES (?,?,?,?,?)
    """;
    private static final String SQL_CHECK_EMAIL = """
    SELECT (id) FROM users WHERE email = ?
            """;

    private static final String SQL_GET_USER_EMAIL_AND_PASSWORD = """
    SELECT * FROM users WHERE email = ? AND password = ?
            """;

    private static final String SQL_UPDATE_COUNT_WIN_GAME = """
            UPDATE users SET win_game = ((SELECT win_game FROM users WHERE id = ?) + 1)
            WHERE id = ?
            RETURNING *
            """;

    private static final String SQL_UPDATE_COUNT_LOSE_GAME = """
            UPDATE users SET lose_game = ((SELECT lose_game FROM users WHERE id = ?) + 1)
            WHERE id = ?
            RETURNING *
            """;

    @Override
    @SneakyThrows
    public Optional<User> findByEmailAndPass(String email, String password) {
        try(var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(SQL_GET_USER_EMAIL_AND_PASSWORD)){
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()){
                user = getBuild(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    @Override
    @SneakyThrows
    public boolean checkedEmail(String email) {
        try(var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(SQL_CHECK_EMAIL)) {
            preparedStatement.setObject(1, email);

            var resultSet = preparedStatement.executeQuery();
            Integer userId = null;
            if (resultSet.next()){
                userId = resultSet.getObject("id", Integer.class);
            }
            return userId != null;
        }
    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try(var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getEmail());
            preparedStatement.setObject(3, entity.getPassword());
            preparedStatement.setObject(4, 0);
            preparedStatement.setObject(5, 0);

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));
            return entity;
        }
    }

    @Override
    @SneakyThrows
    public User updateCountWinGame(Integer userId) {
        try(var connection = ConnectionManager.get();
            var preparedStatement = connection.prepareStatement(SQL_UPDATE_COUNT_WIN_GAME)) {
            preparedStatement.setObject(1, userId);
            preparedStatement.setObject(2, userId);

            var resulSet = preparedStatement.executeQuery();
            resulSet.next();
            return getBuild(resulSet);
        }
    }

    @Override
    @SneakyThrows
    public User updateCountLoseGame(Integer userId) {
        try(var connection = ConnectionManager.get();
            var preparedStatement = connection.prepareStatement(SQL_UPDATE_COUNT_LOSE_GAME)) {
            preparedStatement.setObject(1, userId);
            preparedStatement.setObject(2, userId);

            var resulSet = preparedStatement.executeQuery();
            resulSet.next();
            return getBuild(resulSet);
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    private User getBuild(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .winGame(resultSet.getObject("win_game", Integer.class))
                .loseGame(resultSet.getObject("lose_game", Integer.class))
                .build();
    }
}

package integration;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import util.ConnectionManager;

import java.sql.SQLException;

public abstract class IntegrationTestBase {

    private static final String CLEAN_SQL = "DROP TABLE IF EXISTS users;";
    private static final String CREATE_SQL = """
            CREATE TABLE IF NOT EXISTS users
            (
                id INT AUTO_INCREMENT PRIMARY KEY ,
                name VARCHAR(128) NOT NULL,
                email VARCHAR(128) NOT NULL UNIQUE ,
                password VARCHAR(128) NOT NULL ,
                win_game INT ,
                lose_game INT
            );
            """;
    private static final String INSERT_SQL = """
            INSERT INTO users (name, email, password, win_game, lose_game)
            VALUES ('Ivan', 'ivan@gmail.com', '111345', 10 , 15),
                   ('Petia', 'Petia@gmail.com', '1123415', 20 , 12)
            """;

    @BeforeEach
    void prepareDatabase() {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()) {
            statement.execute(CLEAN_SQL);
            statement.execute(CREATE_SQL);
            statement.execute(INSERT_SQL);
        } catch (Exception eqwe) {
            System.out.println(eqwe);
            eqwe.printStackTrace();
        }
    }
}

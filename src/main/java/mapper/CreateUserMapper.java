package mapper;

import dto.CreateUserDto;
import entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder().
                name(object.getName()).
                email(object.getEmail()).
                password(object.getPassword()).
                winGame(object.getWinGame()).
                loseGame(object.getLoseGame()).
                build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}

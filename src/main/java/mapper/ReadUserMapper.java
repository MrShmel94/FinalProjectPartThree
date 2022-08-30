package mapper;

import dto.ReadUserDto;
import entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadUserMapper implements Mapper<User, ReadUserDto>{

    private static final ReadUserMapper INSTANCE = new ReadUserMapper();

    public static ReadUserMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public ReadUserDto mapFrom(User object) {
        return ReadUserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .email(object.getEmail())
                .winGame(object.getWinGame())
                .loseGame(object.getLoseGame())
                .build();
    }

}

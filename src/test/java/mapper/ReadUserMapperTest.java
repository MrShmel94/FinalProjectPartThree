package mapper;

import dto.CreateUserDto;
import dto.ReadUserDto;
import entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReadUserMapperTest {

    ReadUserMapper mapper = ReadUserMapper.getInstance();

    @Test
    void shouldMapAllFieldsCorrectly(){
        User dto = User.builder()
                .id(1)
                .email("test@gmail.com")
                .name("testName")
                .password("123")
                .winGame(1)
                .loseGame(2)
                .build();

        ReadUserDto actualUser = mapper.mapFrom(dto);

        assertEquals(dto.getId(), actualUser.getId());
        assertEquals(dto.getEmail(), actualUser.getEmail());
        assertEquals(dto.getName(), actualUser.getName());
        assertEquals(dto.getWinGame(), actualUser.getWinGame());
        assertEquals(dto.getLoseGame(), actualUser.getLoseGame());
    }
}

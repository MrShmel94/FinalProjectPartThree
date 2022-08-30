package mapper;

import dto.CreateUserDto;
import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import validator.CreateUserValidator;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserMapperTest {

    CreateUserMapper mapper = CreateUserMapper.getInstance();

    @Test
    void shouldMapAllFieldsCorrectly(){
        CreateUserDto dto = CreateUserDto.builder()
                .email("test@gmail.com")
                .password("123")
                .name("testName")
                .winGame(1)
                .loseGame(2)
                .build();

        User actualUser = mapper.mapFrom(dto);

        assertEquals(dto.getEmail(), actualUser.getEmail());
        assertEquals(dto.getPassword(), actualUser.getPassword());
        assertEquals(dto.getName(), actualUser.getName());
        assertEquals(dto.getWinGame(), actualUser.getWinGame());
        assertEquals(dto.getLoseGame(), actualUser.getLoseGame());
    }
}

package integration.util;

import entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestObjectUtils {

    public static final User IVAN = User.builder()
            .id(1)
            .name("Ivan")
            .email("ivan@gmail.com")
            .password("111345")
            .loseGame(15)
            .winGame(10)
            .build();

    public static final User PETIA = User.builder()
            .id(2)
            .name("Petia")
            .email("Petia@gmail.com")
            .password("1123415")
            .loseGame(12)
            .winGame(20)
            .build();
}

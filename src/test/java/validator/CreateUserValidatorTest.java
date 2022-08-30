package validator;

import dto.CreateUserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateUserValidatorTest {

    CreateUserValidator userValidator = CreateUserValidator.getInstance();

    @MethodSource("getValidationErrorArgument")
    @ParameterizedTest
    void checkEachValidationError(String password, String email, String expectedErrorCode){
        CreateUserDto dto = CreateUserDto.builder()
                .password(password)
                .email(email)
                .build();

        ValidationResult result = userValidator.isValid(dto);

        assertFalse(result.isValid());
        assertThat(result.getErrors()).hasSize(1);
        assertThat(result.getErrors().get(0).getCode()).isEqualTo(expectedErrorCode);
    }

    @Test
    void shouldReturnValidResultIfObjectIsValid(){
        CreateUserDto dto = CreateUserDto.builder()
                .password("123456")
                .email("test@mar.ua")
                .build();

        ValidationResult result = userValidator.isValid(dto);

        assertTrue(result.isValid());
        assertThat(result.getErrors()).isEmpty();
    }

    @Test
    void shouldCombineAllValidationErrors(){
        CreateUserDto dto = CreateUserDto.builder()
                .password("123")
                .email("qwe")
                .build();

        ValidationResult result = userValidator.isValid(dto);

        assertFalse(result.isValid());
        assertThat(result.getErrors()).hasSize(2);
        assertThat(result.getErrors().stream().map(Error::getCode))
                .contains("Incorrect email", "Incorrect password");
    }

    private static Stream<Arguments> getValidationErrorArgument(){
        return Stream.of(
          Arguments.of("123", "qwe@gmail.ru", "Incorrect password"),
          Arguments.of("123456", "qwe", "Incorrect email")
        );
    }
}

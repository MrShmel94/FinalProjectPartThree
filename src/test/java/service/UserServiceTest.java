package service;


import dao.UserDao;
import dto.CreateUserDto;
import dto.ReadUserDto;
import integration.IntegrationTestBase;
import integration.util.TestObjectUtils;
import mapper.CreateUserMapper;
import mapper.ReadUserMapper;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import validator.CreateUserValidator;
import validator.ValidationResult;

import java.util.Optional;

import static integration.util.TestObjectUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest extends IntegrationTestBase {

    @Mock
    private UserDao userDao;
    @Mock
    private CreateUserValidator createUserValidator;
    @Mock
    private CreateUserMapper createUserMapper;
    @Mock
    private ReadUserMapper readUserMapper;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldCallDaoAndConvertEntityOnLogin(){
        ReadUserDto dto = ReadUserDto.builder().build();
        doReturn(dto).when(readUserMapper).mapFrom(IVAN);
        //when(readUserMapper.mapFrom(IVAN)).thenReturn(dto);
        doReturn(Optional.of(IVAN)).when(userDao).findByEmailAndPass(IVAN.getEmail(), IVAN.getPassword());

        Optional<ReadUserDto> actualResult = userService.login(IVAN.getEmail(), IVAN.getPassword());

        assertThat(actualResult).isPresent();
        assertSame(dto, actualResult.get());
        verify(userDao).findByEmailAndPass(IVAN.getEmail(), IVAN.getPassword());
        verify(readUserMapper).mapFrom(IVAN);
    }

}

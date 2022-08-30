package service;

import dao.UserDao;
import dto.CreateUserDto;
import dto.ReadUserDto;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;
import mapper.ReadUserMapper;
import validator.CreateUserValidator;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator userValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper userMapper = CreateUserMapper.getInstance();
    private final ReadUserMapper readUserMapper = ReadUserMapper.getInstance();

    public Optional<ReadUserDto> login(String email, String password){
        return userDao.findByEmailAndPass(email, password)
                .map(readUserMapper::mapFrom);
    }

    public Integer create (CreateUserDto userDto){
        var valid = userValidator.isValid(userDto);
        if (!valid.isValid()){
            throw new ValidationException(valid.getErrors());
        }
        var userEntity = userMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public ReadUserDto updateCountWinGame(Integer userId){
        return readUserMapper.mapFrom(userDao.updateCountWinGame(userId));
    }

    public ReadUserDto updateCountLoseGame(Integer userId){
        return readUserMapper.mapFrom(userDao.updateCountLoseGame(userId));
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}

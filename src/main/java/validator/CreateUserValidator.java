package validator;

import dao.UserDao;
import dto.CreateUserDto;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();
    private static final UserDao userDao = UserDao.getInstance();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (!object.getEmail().trim().matches("\\w+@\\w+\\.\\w+")){
            validationResult.add(Error.of("Incorrect email", "Please write correct email."));
        }
        if (userDao.checkedEmail(object.getEmail().trim())){
            validationResult.add(Error.of("Incorrect email" , "This email is already registered"));
        }
        if (object.getPassword().trim().length() < 6){
            validationResult.add(Error.of("Incorrect password" , "Please write password more six symbols"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}

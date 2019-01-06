package by.epam.interpol.service.autorization;

import by.epam.interpol.coding.PasswordCode;
import by.epam.interpol.dao.user.UserDaoImpl;
import by.epam.interpol.entity.User;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class LoginService {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    public Optional<User> searchUserByLoginPassword(String login, String password){

        String utf8Login = new String(login.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String utf8Password = new String(password.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        Optional<User> result = Optional.empty();
        Optional<User> user = userDaoImpl.searchUserByLogin(utf8Login);
        
        if(user.isPresent()){
            User currentUser = user.get();

            if(PasswordCode.comparePasswords(PasswordCode.encode(utf8Password), currentUser.getPassword())){
                result = Optional.of(currentUser);
            }
        }

        return result;
    }
}

package by.epam.interpol.command.impl.guest;

import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.entity.User;
import by.epam.interpol.service.impl.LoginService;
import by.epam.interpol.validation.LoginDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static by.epam.interpol.consant.RoleType.ADMIN;
import static by.epam.interpol.consant.RoleType.USER;

public class LoginCommand implements ActionCommand {

    private static Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private static final String FALSE = "false";
    private static final String ERROR = "error";
    private static final String ERROR_AUTHORIZATION = "error_authorization";
    private static final String TRUE = "true";
    private static final String NAME_USER = "nameUser";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String SESSION_ROLE = "role";
    private static final String SESSION_IS_LOGIN = "isLogin";
    private boolean roleType;


    @Override
    public Router execute(HttpServletRequest request) {
        LoginService service = new LoginService();
        Router router = new Router();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        HttpSession session = request.getSession(true);

        Optional<User> user = service.searchUserByLoginPassword(login, password);

        if (LoginDataValidator.loginCheck(login) && LoginDataValidator.passwordCheck(password)) {

            if (user.isPresent()) {
                session.setAttribute(NAME_USER, user.get());
                session.setAttribute(SESSION_IS_LOGIN, TRUE);
                router.setRouteType(Router.RouteType.FORWARD);
                router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
                request.setAttribute(ERROR, TRUE);
                roleType = user.get().isType();
                if (roleType) {
                    session.setAttribute(SESSION_ROLE, ADMIN);
                    router.setRouteType(Router.RouteType.REDIRECT);
                } else {
                    session.setAttribute(SESSION_ROLE, USER);
                    router.setRouteType(Router.RouteType.REDIRECT);

                }
            } else {
                LOGGER.warn("Login and password not correct!");
                router.setPagePath(PagePath.LOGIN_PAGE.getJspPath());
                request.setAttribute(ERROR, FALSE);
            }
            request.setAttribute(ERROR_AUTHORIZATION, TRUE);

        } else {
            LOGGER.warn("User is not authorized");
            router.setPagePath(PagePath.LOGIN_PAGE.getJspPath());
            request.setAttribute(ERROR_AUTHORIZATION, FALSE);

        }


        return router;
    }
}

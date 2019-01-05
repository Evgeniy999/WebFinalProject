package by.epam.interpol.command.impl.user;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.autorization.LoginService;
import by.epam.interpol.service.user.UserService;
import by.epam.interpol.service.user.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangePasswordCommand implements ActionCommand {
    private static Logger LOGGER = LogManager.getLogger(ChangePasswordCommand.class);

    public static final String USER_ID = "userId";
    private static final String PASSWORD = "password";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        UserServiceImpl service = new UserServiceImpl();
        String userId = request.getParameter(USER_ID);
        String password = request.getParameter(PASSWORD);

        try {
            service.changePassword(Integer.parseInt(userId), password);
            router.setRouteType(Router.RouteType.REDIRECT);
        } catch (DaoException e) {
            LOGGER.warn("user is not registered", e);
        }
        router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
        return router;
    }
}

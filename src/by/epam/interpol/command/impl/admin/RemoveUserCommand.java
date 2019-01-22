package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Remove user command.
 */
public class RemoveUserCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        UserServiceImpl service = new UserServiceImpl();

        String id = request.getParameter(ID);
        try {
            service.remove(Integer.parseInt(id));
            ArrayList<User> userAll = service.showAll();
            request.getSession().setAttribute("users",userAll);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        router.setPagePath(PagePath.USERS_TABLE.getJspPath());
        router.setRouteType(Router.RouteType.REDIRECT);
        return router;
    }
}

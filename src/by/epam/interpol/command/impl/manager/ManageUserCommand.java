package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.User;
import by.epam.interpol.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ManageUserCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        UserServiceImpl service = new UserServiceImpl();
        Router router = new Router();
        ArrayList<User> userAll = service.showAll();
        request.getSession().setAttribute("users",userAll);
        router.setPagePath(PagePath.USERS_TABLE.getJspPath());
        //router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

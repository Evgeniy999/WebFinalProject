package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;

import javax.servlet.http.HttpServletRequest;

public class ToChangePasswordCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPagePath(PagePath.PASSWORD_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

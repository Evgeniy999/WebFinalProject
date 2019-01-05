package by.epam.interpol.command.impl.user;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;

import javax.servlet.http.HttpServletRequest;

public class ApplicationPageCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPagePath(PagePath.APPLICATION_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

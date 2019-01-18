package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Empty command.
 */
public class EmptyCommand implements ActionCommand
{
    @Override
    public Router execute(HttpServletRequest request)
    {
        Router router = new Router();
        router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }

}
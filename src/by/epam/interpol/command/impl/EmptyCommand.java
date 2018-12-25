package by.epam.interpol.command.impl;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand
{
    @Override
    public Router execute(HttpServletRequest request)
    {
        Router router = new Router();
        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
        return router;
    }

}
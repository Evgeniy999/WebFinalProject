package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.consant.RoleType;

import javax.servlet.http.HttpServletRequest;

/**
 * The type To page change prof command.
 */
public class ToPageChangeProfCommand implements ActionCommand {
    private static final String ROLE = "role";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        RoleType role = (RoleType) request.getSession().getAttribute(ROLE);
        if(role != RoleType.ADMIN){
            router.setPagePath(PagePath.CHANGE_PROF_PAGE_USER.getJspPath());
        } else {
            router.setPagePath(PagePath.CHANGE_PROF_PAGE_ADMIN.getJspPath());
        }
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

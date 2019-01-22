package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Change lang command.
 */
public class ChangeLangCommand implements ActionCommand {
    private static final String LANG = "lang";
    private static final String SESSION_LAST_PAGE = "lastPage";

    @Override
    public Router execute(HttpServletRequest request) {
        String langVal = request.getParameter(LANG);

        HttpSession session = request.getSession();
        session.setAttribute(LANG, langVal);
        String pagePath = (String) session.getAttribute(SESSION_LAST_PAGE);
        Router router = new Router();
        router.setRouteType(Router.RouteType.REDIRECT);
        router.setPagePath(pagePath);

        return router;
    }

}

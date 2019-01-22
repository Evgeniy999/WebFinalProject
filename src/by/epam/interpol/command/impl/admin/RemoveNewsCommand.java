package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.NewsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Remove news command.
 */
public class RemoveNewsCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        NewsServiceImpl service = new NewsServiceImpl();

        String id = request.getParameter(ID);
        try {
            service.remove(Integer.parseInt(id));
            ArrayList<News> newsAll = service.showAll();
            request.getSession().setAttribute("news",newsAll);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        router.setPagePath(PagePath.NEWS_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.REDIRECT);
        return router;
    }
}

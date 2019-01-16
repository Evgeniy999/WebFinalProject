package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.News;
import by.epam.interpol.service.impl.NewsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type To news page command.
 */
public class ToNewsPageCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        NewsServiceImpl docService = new NewsServiceImpl();
        Router router = new Router();
        ArrayList<News> news = docService.showAll();
        request.getSession().setAttribute("news",news);
        router.setPagePath(PagePath.NEWS_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

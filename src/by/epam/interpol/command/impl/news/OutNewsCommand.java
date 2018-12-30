package by.epam.interpol.command.impl.news;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.News;
import by.epam.interpol.service.news.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class OutNewsCommand implements ActionCommand {
    private NewsService newsService = new NewsService();
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        ArrayList<News> newsAll = newsService.showAll();
        request.getSession().setAttribute("news",newsAll);
        router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
        //router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

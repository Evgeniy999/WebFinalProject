package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.NewsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * The type News add command.
 */
public class NewsAddCommand implements ActionCommand {

    private static Logger LOGGER = LogManager.getLogger();
    private static final String NEWS_TOPIC = "topic";
    private static final String NEWS_INFORMATION = "information";
    private static final String COUNTRY = "country";
    private static final String DATA_NEWS = "dateNews";
    private static final String NEWS_PHOTO = "photo";

    @Override
    public Router execute(HttpServletRequest request) {
        NewsServiceImpl newsService = new NewsServiceImpl();
        Router router = new Router();
        Date date = null;
        String currentTopic = request.getParameter(NEWS_TOPIC);
        String currentInformation = request.getParameter(NEWS_INFORMATION);
        String currentCountry = request.getParameter(COUNTRY);
        String currentDate = request.getParameter(DATA_NEWS);

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = new Date(formatter.parse(currentDate).getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Part imagePart;
        try {
            imagePart = request.getPart(NEWS_PHOTO);
            newsService.addNews(currentTopic, currentInformation, currentCountry, date, imagePart);
            ArrayList<News> newsAll = newsService.showAll();
            request.getSession().setAttribute("news", newsAll);
            router.setPagePath(PagePath.NEWS_PAGE.getJspPath());

        } catch (Exception | ServiceException e) {
            LOGGER.warn("Document input exception", e);
            router.setPagePath(PagePath.NEWS_ADD_PAGE.getJspPath());
        }
        router.setRouteType(Router.RouteType.REDIRECT);
        return router;
    }
}

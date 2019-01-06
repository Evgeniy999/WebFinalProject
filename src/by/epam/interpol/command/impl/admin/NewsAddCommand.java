package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.news.NewsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NewsAddCommand implements ActionCommand {

    private static Logger LOGGER = LogManager.getLogger();
    public static final String NEWS_TOPIC = "topic";
    public static final String NEWS_INFORMATION = "information";
    public static final String COUNTRY = "country";
    public static final String DATA_NEWS = "dateNews";
    public static final String NEWS_PHOTO = "photo";

    @Override
    public Router execute(HttpServletRequest request) {
        NewsServiceImpl newsService = new NewsServiceImpl();
        Router router = new Router();
        Date date = null;
        String currentTopic = request.getParameter(NEWS_TOPIC);
        String currentInformation = request.getParameter(NEWS_INFORMATION);
        String currentCountry = request.getParameter(COUNTRY);
        String currentDate = request.getParameter(DATA_NEWS);


        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        try {
            date = new Date(formatter.parse(currentDate).getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Part imagePart;
        try {
            imagePart = request.getPart(NEWS_PHOTO);
            newsService.addNews(currentTopic, currentInformation, currentCountry, date, imagePart);
            router.setPagePath(PagePath.NEWS_PAGE.getJspPath());

        } catch (Exception | DaoException e) {
            LOGGER.warn("Document input exception", e);
            router.setPagePath(PagePath.NEWS_ADD_PAGE.getJspPath());
        }

        return router;
    }
}

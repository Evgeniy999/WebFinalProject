package by.epam.interpol.command.impl.user;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.DocServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The type Add application command.
 */
public class AddApplicationCommand implements ActionCommand {
    private static Logger LOGGER = LogManager.getLogger(AddApplicationCommand.class);
    private static final String NAME = "name";
    private static final String LAST_NAME = "last";
    private static final String DATE = "date";
    private static final String DATE_LEAD = "date_lead";
    private static final String REWARD = "reward";
    private static final String STATEMENT = "statement";
    private static final String INFORMATION = "information";
    private static final String PHOTO = "photo";


    @Override
    public Router execute(HttpServletRequest request) {
        DocServiceImpl docService = new DocServiceImpl();
        Router router = new Router();
        Date date = null;
        Date dateLead = null;
        String currentName = request.getParameter(NAME);
        String currentLast = request.getParameter(LAST_NAME);
        String currentDate = request.getParameter(DATE);
        String currentDateLead = request.getParameter(DATE_LEAD);
        String currentReward = request.getParameter(REWARD);
        String currentStatement = request.getParameter(STATEMENT);
        String currentInformation = request.getParameter(INFORMATION);


        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        try {
            date = new Date(formatter.parse(currentDate).getTime());
            dateLead = new Date(formatter.parse(currentDateLead).getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        double reward = Double.parseDouble(currentReward);
        Part imagePart;
        try {
            imagePart = request.getPart(PHOTO);
            docService.addDoc(currentStatement, date, reward, currentInformation, dateLead, currentName, currentLast, imagePart);
            router.setPagePath(PagePath.MAIN_PAGE.getJspPath());

        } catch (Exception | ServiceException e) {
            LOGGER.warn("Document input exception", e);
            router.setPagePath(PagePath.APPLICATION_PAGE.getJspPath());
        }
        router.setRouteType(Router.RouteType.REDIRECT);
        return router;
    }
}

package by.epam.interpol.command.impl.user;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.consant.RoleType;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.document.DocServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddApplicationCommand implements ActionCommand {
    private static Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    private static final String NAME = "name";
    private static final String LAST_NAME = "last";
    private static final String DATE = "date";
    private static final String DATE_LEAD = "date_lead";
    private static final String REWARD = "reward";
    private static final String STATEMENT = "statement";
    private static final String INFORMATION = "information";
    private DocServiceImpl docService = new DocServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        Date date = null;
        Date dateLead = null;
        String currentName = request.getParameter(NAME);
        String currentLast= request.getParameter(LAST_NAME);
        String currentDate = request.getParameter(DATE);
        String currentDateLead= request.getParameter(DATE_LEAD);
        String currentReward= request.getParameter(REWARD);
        String currentStatement= request.getParameter(STATEMENT);
        String currentInformation= request.getParameter(INFORMATION);


        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        try {
            date  = new Date( formatter.parse(currentDate).getTime());
            dateLead  = new Date( formatter.parse(currentDateLead).getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

       double reward = Double.parseDouble(currentReward);

        try {
            Document document = docService.addDoc(currentStatement, date, reward,currentInformation,
                    dateLead,  currentName, currentLast);
            router.setPagePath(PagePath.MAIN_PAGE.getJspPath());

        }
        catch (Exception | DaoException e) {
            LOGGER.warn("user is not registered", e);
            router.setPagePath(PagePath.APPLICATION_PAGE.getJspPath());
        }

        return router;
    }
}

package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class ChangeProfCommand implements ActionCommand {
    private static Logger LOGGER = LogManager.getLogger(ChangeProfCommand.class);

    private static final String USER_ID = "userId";
    private static final String TRUE = "true";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME_USER = "nameUser";
    private static final String NAME = "name";
    private static final String LAST_NAME = "last";
    private static final String BIRTHDAY = "birthday";
    private static final String TELEPHONE = "telephone";
    private static final String ADDRESS = "address";
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession(true);
        UserServiceImpl service = new UserServiceImpl();
        Date birth=null;
        String userId = request.getParameter(USER_ID);
        String name = request.getParameter(NAME);
        String lastName = request.getParameter(LAST_NAME);
        String birthday= request.getParameter(BIRTHDAY);
        String telephone= request.getParameter(TELEPHONE);
        String address = request.getParameter(ADDRESS);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        try {
            birth = new Date( formatter.parse(birthday).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long phone = Long.parseLong(telephone);

        try {
            service.changeProf(Integer.parseInt(userId), name,lastName,birth,phone,address);
            Optional<User> user = service.searchById(Integer.parseInt(userId));
            session.setAttribute(NAME_USER, user.get());
            router.setRouteType(Router.RouteType.REDIRECT);
        } catch (ServiceException e) {
            LOGGER.warn("User is not registered", e);
        }
        router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
        return router;
    }
}

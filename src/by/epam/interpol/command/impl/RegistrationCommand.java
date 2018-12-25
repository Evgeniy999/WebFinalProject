package by.epam.interpol.command.impl;

import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.consant.RoleType;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RegistrationCommand implements ActionCommand {
    private static Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    public static final String NAME_USER = "nameUser";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String LAST_NAME = "last";
    private static final String BIRTHDAY = "birthday";
    private static final String TELEPHONE = "telephone";
    private static final String ADDRESS = "address";
    private static final String SESSION_ROLE = "role";
    private static final String SESSION_IS_LOGIN = "isLogin";


    private UserService service = new UserService();
    @Override

    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        Date birthday = null;
        String currentLogin = request.getParameter(LOGIN);
        String currentPassword = request.getParameter(PASSWORD);
        String currentName = request.getParameter(NAME);
        String currentLast= request.getParameter(LAST_NAME);
        String currentBirth = request.getParameter(BIRTHDAY);
        String currentTelephone= request.getParameter(TELEPHONE);
        String currentAddress= request.getParameter(ADDRESS);
        HttpSession session = request.getSession(true);


        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        try {
            birthday  = new Date( formatter.parse(currentBirth).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long telephone = Long.parseLong(currentTelephone);

        try {
            User user = service.addUser(currentLogin, currentPassword,currentName,currentLast,
                    birthday, telephone, currentAddress);
            session.setAttribute(SESSION_ROLE, RoleType.USER);//todo
            session.setAttribute(NAME_USER, user);
            session.setAttribute(SESSION_IS_LOGIN, "true");
            router.setPagePath(PagePath.MAIN_PAGE.getJspPath());
            request.setAttribute("user", user);

        }
        catch (Exception | ApplicationException e) {
            LOGGER.warn("user is not registered", e);
            router.setPagePath(PagePath.REGISTRATION_PAGE.getJspPath());
        }

        return router;
    }
}

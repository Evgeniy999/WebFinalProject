package by.epam.interpol.command.impl.user;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.consant.RoleType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LogoutCommand implements ActionCommand {
    public static final String NAME_USER = "nameUser";
    private static final String SESSION_ROLE = "role";
    private static final String SESSION_IS_LOGIN = "isLogin";


    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPagePath(PagePath.INDEX_PAGE.getJspPath());
        HttpSession session = request.getSession();
        session.removeAttribute(NAME_USER);
        session.setAttribute(SESSION_IS_LOGIN,"false");
        session.setAttribute(SESSION_ROLE, RoleType.GUEST);
       // session.invalidate();//// TODO:
        return router;
    }
}

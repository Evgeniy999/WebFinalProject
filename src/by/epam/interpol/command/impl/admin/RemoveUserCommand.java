package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.user.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

public class RemoveUserCommand implements ActionCommand {

    private UserServiceImpl service = new UserServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();

        String id = request.getParameter("id");

        Optional<User> user = service.searchById(Integer.parseInt(id));
        try {
            service.remove(user.get());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        ArrayList<User> userAll = service.showAll();
        request.getSession().setAttribute("users",userAll);
        router.setPagePath(PagePath.USERS_TABLE.getJspPath());
        return router;
    }
}

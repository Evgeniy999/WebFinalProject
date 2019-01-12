package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class RemovePersonCommand implements ActionCommand {
    private static final String ID = "id";
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        PersonServiceImpl service = new PersonServiceImpl();
        String id = request.getParameter(ID);
        try {
            service.remove(Integer.parseInt(id));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        ArrayList<Person> people = service.showAll();
        request.getSession().setAttribute("people",people);
        router.setPagePath(PagePath.USERS_TABLE.getJspPath());
        return router;
    }
}

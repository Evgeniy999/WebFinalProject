package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.Person;
import by.epam.interpol.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class WantedPageCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        PersonServiceImpl service = new PersonServiceImpl();
        Router router = new Router();
        ArrayList<Person> people = service.showAll();
        request.getSession().setAttribute("people",people);
        router.setPagePath(PagePath.WANTED_TABLE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

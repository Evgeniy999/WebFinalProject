package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.Person;
import by.epam.interpol.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Wanted page command.
 */
public class SearchPageCommand implements ActionCommand {

    public static final String STATUS = "status";
    public static final String MISSING = "missing";

    @Override
    public Router execute(HttpServletRequest request) {
        String status = request.getParameter(STATUS);
        PersonServiceImpl service = new PersonServiceImpl();
        Router router = new Router();
        ArrayList<Person> people = service.showAll();
        request.getSession().setAttribute("people",people);
        if (status.equals(MISSING)){
            router.setPagePath(PagePath.MISSING_TABLE.getJspPath());
        }else{
            router.setPagePath(PagePath.WANTED_TABLE.getJspPath());
        }
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

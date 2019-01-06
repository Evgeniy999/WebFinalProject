package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.Document;
import by.epam.interpol.service.document.DocService;
import by.epam.interpol.service.document.DocServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ApprovePageCommand implements ActionCommand {

    public static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String id = request.getParameter(ID);
        DocServiceImpl docService = new DocServiceImpl();
        Optional<Document> document = docService.searchById(Integer.parseInt(id));
        request.setAttribute("document", document.get());
        router.setPagePath(PagePath.APPROVE_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

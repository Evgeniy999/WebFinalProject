package by.epam.interpol.command.impl.manager;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.Document;
import by.epam.interpol.service.document.DocService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ManageDoc implements ActionCommand {
    private DocService docService = new DocService();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        ArrayList<Document> documents = docService.showAll();
        request.getSession().setAttribute("docs",documents);
        router.setPagePath(PagePath.DOCS_TABLE.getJspPath());
        //router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}

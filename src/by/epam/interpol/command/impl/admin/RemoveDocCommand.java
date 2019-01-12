package by.epam.interpol.command.impl.admin;

import by.epam.interpol.command.ActionCommand;
import by.epam.interpol.command.PagePath;
import by.epam.interpol.command.Router;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.impl.DocServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class RemoveDocCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        DocServiceImpl service = new DocServiceImpl();
        String id = request.getParameter(ID);
        try {
            service.remove(Integer.parseInt(id));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        ArrayList<Document> userAll = service.showAll();
        request.getSession().setAttribute("docs",userAll);
        router.setPagePath(PagePath.DOCS_TABLE.getJspPath());
        return router;
    }
}

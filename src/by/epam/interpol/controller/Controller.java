package by.epam.interpol.controller;

import by.epam.interpol.command.*;
import by.epam.interpol.command.impl.manager.EmptyCommand;
import by.epam.interpol.pool.PoolConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


/**
 * The type Controller.
 */
@WebServlet("/interpol")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Controller extends HttpServlet {


    private static final String COMMAND = "command";

    @Override
    public void init() throws ServletException
    {
        PoolConnection.getInstance();
    }

    @Override
    public void destroy()
    {
        PoolConnection.getInstance().destroy();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<ActionCommand> commandOptional = CommandFactory.chooseCommand(req.getParameter(COMMAND));
        ActionCommand command = commandOptional.orElse(new EmptyCommand());
        Router router = command.execute(req);
        String pagePath = router.getPagePath();
        if (router.getRoute() == Router.RouteType.FORWARD) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(pagePath);
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(router.getPagePath());
        }
    }
}

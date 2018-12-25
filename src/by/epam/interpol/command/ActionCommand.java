package by.epam.interpol.command;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    Router execute(HttpServletRequest request);

}

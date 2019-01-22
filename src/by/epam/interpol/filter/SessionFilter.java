package by.epam.interpol.filter;

import by.epam.interpol.command.PagePath;
import by.epam.interpol.consant.RoleType;
import by.epam.interpol.entity.Document;
import by.epam.interpol.entity.News;
import by.epam.interpol.entity.Person;
import by.epam.interpol.entity.User;
import by.epam.interpol.service.impl.DocServiceImpl;
import by.epam.interpol.service.impl.NewsServiceImpl;
import by.epam.interpol.service.impl.PersonServiceImpl;
import by.epam.interpol.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Session filter.
 */
public class SessionFilter implements Filter {
    private static final String INDEX_JSP = "/index.jsp";
    private static final String SESSION_LANG = "lang";
    private static final String SESSION_IS_LOGIN = "isLogin";
    private static final String SESSION_ROLE = "role";
    private static final String SESSION_LAST_PAGE = "lastPage";


    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().isNew()) {
            if (request.getServletPath().equals(INDEX_JSP)) {
                NewsServiceImpl newsService = new NewsServiceImpl();
                DocServiceImpl docService = new DocServiceImpl();
                UserServiceImpl userService = new UserServiceImpl();
                PersonServiceImpl personService = new PersonServiceImpl();
                HttpSession session = request.getSession(true);
                session.setAttribute(SESSION_LANG, "en");
                session.setAttribute(SESSION_IS_LOGIN, "false");
                session.setAttribute(SESSION_ROLE, RoleType.GUEST);
                session.setAttribute(SESSION_LAST_PAGE, PagePath.MAIN_PAGE);
                ArrayList<News> newsAll = newsService.showAll();
                session.setAttribute("news", newsAll);
                ArrayList<Document> documents = docService.showAll();
                session.setAttribute("docs", documents);
                ArrayList<User> users = userService.showAll();
                session.setAttribute("users", users);
                ArrayList<Person> people = personService.showAll();
                session.setAttribute("people", people);
            }
        } else {
            HttpSession session = request.getSession(false);
            if (session == null) {
                response.sendRedirect(INDEX_JSP);
                return;
            }

        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {
    }

}

package by.epam.interpol.filter;

import by.epam.interpol.command.PagePath;
import by.epam.interpol.consant.RoleType;
import by.epam.interpol.entity.News;
import by.epam.interpol.service.news.NewsService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SessionFilter implements Filter
{
    private FilterConfig filterConfig;

    private static final String INDEX_JSP = "/index.jsp";
    private static final String SESSION_LANG = "lang";
    private static final String SESSION_IS_LOGIN = "isLogin";
    private static final String SESSION_ROLE = "role";
    private static final String SESSION_LAST_PAGE = "lastPage";
    private NewsService newsService = new NewsService();


    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getServletPath().equals(INDEX_JSP))
        {
            HttpSession session=request.getSession(true);
            session.setAttribute(SESSION_LANG, "en");
            session.setAttribute(SESSION_IS_LOGIN , "false");
            session.setAttribute(SESSION_ROLE, RoleType.GUEST);
            session.setAttribute(SESSION_LAST_PAGE, PagePath.MAIN_PAGE);
            ArrayList<News> newsAll = newsService.showAll();
            session.setAttribute("news",newsAll);
        }
        else
        {
            HttpSession session = request.getSession(false);
            if (session == null)
            {
                response.sendRedirect(INDEX_JSP);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    public void destroy()
    {}

}

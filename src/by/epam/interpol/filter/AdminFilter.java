package by.epam.interpol.filter;

import by.epam.interpol.consant.RoleType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Admin filter.
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/jsp/main/admin/*"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AdminFilter implements Filter {

    /**
     * The constant ROLE.
     */
    public static final String ROLE = "role";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        RoleType role = (RoleType) req.getSession().getAttribute(ROLE);
        if(role != RoleType.ADMIN){
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
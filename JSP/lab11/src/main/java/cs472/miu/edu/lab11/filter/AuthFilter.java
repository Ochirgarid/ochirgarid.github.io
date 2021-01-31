package cs472.miu.edu.lab11.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login.jsp";

        System.out.println("This is filter ______");
        System.out.println(req.getRequestURL());

        boolean loggedIn = session != null && session.getAttribute("user") != null;

        System.out.println(loggedIn);
        //System.out.println(session.getAttribute("user"));

        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest ) {
                chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {}
}
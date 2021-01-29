package cs472.miu.edu.lab11;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = { "/*"}
)
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;

        if(httpRequest.getSession(false) != null) {
            chain.doFilter(req, resp);
        } else {

            if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                UserDatabase db = UserDatabase.getInstance();
                if (db.isUserExists(username, password)) {
                    chain.doFilter(req, resp);
                } else {
                    PrintWriter out = resp.getWriter();
                    out.println("wrong username or password");
                    ((HttpServletResponse) resp).sendRedirect("/login");
                }
            } else {
                if (httpRequest.getRequestURI().equals("/login")) {
                    chain.doFilter(req, resp);
                } else {
                    ((HttpServletResponse) resp).sendRedirect("/login");
                }
            }
        }
    }
}

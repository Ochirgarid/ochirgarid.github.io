package cs472.miu.edu.lab11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Login</title></head><body><h1> Login (Login Servlet)</h1>");
        out.println(
            "<form submit='/' method='POST'>" +
                "<label for='username'> Username: </label> <input type='text' name='username'/></br>" +
                "<label for='password'> Password: </label> <input type='password' name='password'/></br>" +
                "<label for='rememberMe'> Remember Me: </label> <input type='checkbox' name='rememberMe'></br>" +
                "<input type='submit' value='Login'/>" +
            "</form>"
        );
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("rememberMe");
        req.getSession().setAttribute("user", new User(username, password));
        Cookie c;
        if (remember != null && !remember.trim().isEmpty()) {
            req.getSession().setMaxInactiveInterval(12 * 60 * 60); //seconds
            c = new Cookie("username", username);
            c.setMaxAge(7 * 24 * 60 * 60);
        }else{
            c = new Cookie("username", null);
            c.setMaxAge(0);
        }
        resp.addCookie(c);
        resp.sendRedirect("/logged-in");
    }

    public void destroy() {
    }
}
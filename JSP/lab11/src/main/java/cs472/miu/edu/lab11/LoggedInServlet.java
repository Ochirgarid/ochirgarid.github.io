package cs472.miu.edu.lab11;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loggedInServlet", value = "/logged-in")
public class LoggedInServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>LoggedIn</title></head><body><h1> Successfully Logged in</h1>");
        out.println("<div>"+ req.getSession().getAttribute("user").toString() + "</div>");
        out.println(
            "<form submit='/logged-in' method='POST'>" +
                "<input type='submit' value='Log out'/>" +
            "</form>"
        );
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }

    @Override
    public void destroy() {
    }
}

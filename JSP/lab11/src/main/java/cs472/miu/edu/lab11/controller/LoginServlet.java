package cs472.miu.edu.lab11.controller;

import cs472.miu.edu.lab11.db.DataSet;
import cs472.miu.edu.lab11.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null) {
            req.setAttribute("err_msg", session.getAttribute("err_msg"));
            session.invalidate();
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        PrintWriter out = resp.getWriter();
        String p_name=req.getParameter("username");
        String p_password=req.getParameter("password");
        String remember=req.getParameter("remember");

        boolean isRight= DataSet.checkUser(p_name,p_password);
        HttpSession session = req.getSession();

        if(isRight){
            session.setAttribute("user", new User(p_name, p_password));

            //Cookie session_cookie=new Cookie("SESSIONMYY", session.getId());
            //resp.addCookie(session_cookie);

            if ("yes".equals(remember)) {
                Cookie c = new Cookie("user", p_name);
                c.setMaxAge(30 * 24 * 60 * 60);
                resp.addCookie(c);
            } else {
                Cookie c = new Cookie("user", null);
                c.setMaxAge(0);
                resp.addCookie(c);

            }

            resp.sendRedirect("welcome.jsp");
        }
        else {
            session.setAttribute("err_msg", "Username and/or password invalid.");
            System.out.println("This is wrong passwordd");
            resp.sendRedirect("login");
        }
    }
}

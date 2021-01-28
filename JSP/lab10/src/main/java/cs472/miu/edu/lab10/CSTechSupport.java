package cs472.miu.edu.lab10;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "csTechSupport", value = "/support")
public class CSTechSupport extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet " + this.getServletName() + " has started.");
        ServletContext sc = this.getServletContext();
        sc.getInitParameter("support-email");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>CS TechSupport</title></head><body>");
        out.println("<form submit='/support' method='POST'>");
        // a. Name
        out.println("<label> Name: </label> <input type='text' name='username' required/>");
//        b. Email address
        out.println("<label> Email address: </label> <input type='text' name='email' required/>");
//        c. Problem
        out.println("<label> Problem: </label> <input type='text' name='problem' required/>");
//        d. Problem description (textarea)
        out.println("<label> Problem description: </label> <textarea id='problemDescription'> </textarea>");
//        e. Submit button with label ‘help’
        out.println("<input type='submit' value='help'/>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        int ticketId = (int) (Math.random() * 1000000.0);

        PrintWriter out = resp.getWriter();
        out.println("Thank you! " + req.getParameter("username") + " for contacting us. We should receive reply from us with in 24 hrs in");
        out.println("your email address " + req.getParameter("email") + ". Let us know in our support email " + getServletContext().getInitParameter("support-email") + " if");
        out.println("you don’t receive reply within 24 hrs. Please be sure to attach your reference");
        out.println(ticketId + " in your email.");

    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }
}

package cs472.miu.edu.lab11.controller;

import com.google.gson.Gson;
import cs472.miu.edu.lab11.db.DataSet;
import cs472.miu.edu.lab11.model.Card;
import cs472.miu.edu.lab11.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CardServlet extends HttpServlet {

    Gson mapper = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession(false);
        Object session_card=session.getAttribute("card");
        Card card=null;

        if(session_card!=null){
            card= mapper.fromJson(mapper.toJson(session_card) , Card.class);
        }

        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(card));
    }
}

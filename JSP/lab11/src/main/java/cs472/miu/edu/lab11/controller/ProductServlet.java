package cs472.miu.edu.lab11.controller;

import cs472.miu.edu.lab11.db.DataSet;
import cs472.miu.edu.lab11.model.Card;
import cs472.miu.edu.lab11.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.Enumeration;
import com.google.gson.Gson;

public class ProductServlet extends HttpServlet {

    Gson mapper = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        req.setAttribute("products", DataSet.getProducts());

        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product product=null;

        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(mapper.toJson(line));
                product= DataSet.getProduct(Integer.parseInt(line));
            }
        } finally {
            reader.close();
        }

        HttpSession session=request.getSession(true);
        Object session_card=session.getAttribute("card");
        Card card=null;

        if(session_card!=null){
            card= mapper.fromJson(mapper.toJson(session_card) , Card.class);
            card.addProduct(product);
            session.setAttribute("card",card);
            System.out.println(card);
        }
        else {
            card=new Card();
            card.addProduct(product);
            session.setAttribute("card",card);
        }

        PrintWriter out = response.getWriter();

        out.print(mapper.toJson(card));

        System.out.println(product.getProduct_name());

    }
}

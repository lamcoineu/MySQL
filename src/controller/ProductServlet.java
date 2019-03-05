package controller;

import database.ProductHandler;
import model.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }


    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        //System.out.println(action);
        if (action.equals("product_input")) {
        } else if (action.equals("product_save")) {
            Product product = new Product();
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Float.parseFloat(request.getParameter("price")));
            new ProductHandler().insert(product);
            request.setAttribute("product", product);
        } else {
            List<Product> products = new ProductHandler().getProducts();
            request.setAttribute("products", products);
        }

        String dispatchUrl = null;
        if (action.equals("product_input")) {
            dispatchUrl = "ProductForm.jsp";
        } else if (action.equals("product_save")) {
            dispatchUrl = "ProductDetails.jsp";
        } else {
            dispatchUrl = "ProductList.jsp";
        }

        if (dispatchUrl != null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
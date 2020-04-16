package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShoseServlet", urlPatterns = "/shoes")

public class ShoesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action){
            case "create_shoes"
            try{

            }catch (SQLException e){
                e.printStackTrace();
            }
            break;
        }



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create_shoes":
                    showNewShoes(request, response);
                    break;


            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void showNewShoes(HttpServletRequest request, HttpServletResponse response) {
    }

}

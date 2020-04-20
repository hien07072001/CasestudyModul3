package controller;
import model.LoginUser;
import service.IUser;
import service.UserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login",urlPatterns = "/login")
public class Login extends HttpServlet {
    private IUser user=new UserImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginUser loginUser=null;

        loginUser=user.findUserLogin(email,password);
        RequestDispatcher requestDispatcher=null;
        if (loginUser !=null){
            response.sendRedirect("/shoes");
        }else {
            requestDispatcher=request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request,response);


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}



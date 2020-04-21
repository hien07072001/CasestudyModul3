package controller;

import model.CategoryShoes;
import model.Shoes;
import service.CategoryImpl;
import service.ICategory;
import service.IShoesService;
import service.ShoesIpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShoesServlet", urlPatterns = "/shoes")

public class ShoesServlet extends HttpServlet {

   private IShoesService ShoesService  = new ShoesIpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action ) {
            case "create_shoes":
                try {
                    createShoes(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit_shoes":
                try {
                    editShoes(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String price = request.getParameter("price");
        if (price != null){
            try {
                findByShoesPrice(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        switch (action != null ? action : "") {
            case "create_shoes":
                showCreateShoes(request, response);
                break;
            case "edit_shoes":
                   showEditShoes(request, response);
                break;
            case "delete_shoes":
                try {
                    DeleteShoes(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "list_shoes":
                showListShoes(request, response);
                break;
            case "findByPrice":
                try {
                    findByShoesPrice(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                listShoesCategory(request, response);
                break;
        }
    }

    private void showListShoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shoes> shoesList = this.ShoesService.findAll();
        request.setAttribute("listShoes", shoesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shoes/list_shoes.jsp");
        dispatcher.forward(request, response);
    }

    private void findByShoesPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        float price = Float.parseFloat(request.getParameter("price"));
        List<Shoes> shoesList = this.ShoesService.findByPrice(price);
        RequestDispatcher requestDispatcher;
        if (shoesList == null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("listShoes", shoesList);//truyền tên biến tìm kiếm giống tên list quần áo
            requestDispatcher = request.getRequestDispatcher("shoes/list_shoes.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void editShoes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int shoes_id=Integer.parseInt(request.getParameter("id"));
        String image_link=request.getParameter("image");
        String name_shoes=request.getParameter("name");
        float price=Float.parseFloat(request.getParameter("price"));

        Shoes shoes= new Shoes(shoes_id,image_link,name_shoes,price);
        this.ShoesService.update(shoes);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("shoes/edit_shoes.jsp");
        requestDispatcher.forward(request,response);


    }
    private void DeleteShoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, SQLException {
        int shoes_id = Integer.parseInt(request.getParameter("id"));
        this.ShoesService.delete(shoes_id);

        List<Shoes> shoes  = this.ShoesService.findAll();
        request.setAttribute("listShoes",shoes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shoes/list_shoes.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditShoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int shoes_id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shoes/edit_shoes.jsp");
        requestDispatcher.forward(request,response);

    }
    private void listShoesCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shoes> shoesList = this.ShoesService.FindByCategoryShoes();
        request.setAttribute("shoes",shoesList);

//        List<String> statuses = this.ShoesService.FindByCategoryShoes();
//        request.setAttribute("statuses", statuses);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home/Category_shoes.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showCreateShoes(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shoes/create_shoes.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createShoes(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String image = request.getParameter("image");
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        Shoes shoes = new Shoes(image,name,price);
        this.ShoesService.insert(shoes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("shoes/create_shoes.jsp");
        request.setAttribute("message", "Tạo mới không thành công");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}


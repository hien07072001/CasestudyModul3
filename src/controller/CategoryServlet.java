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

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")

public class CategoryServlet extends HttpServlet {
    private ICategory categoryService = new CategoryImpl();
    private IShoesService shoesService = new ShoesIpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create_category":
                try {
                    createCategory(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "edit_category":
                try {
                    updateCategory(request, response);
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
        String status = request.getParameter("status");
        if (status != null){
            try {
                findByStatus(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create_category":
                showCreateCategory(request, response);
                break;
            case "edit_category":
                showEditCategory(request, response);
                break;
            case "delete_category":
                try {
                    showDeleteCategory(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "findByStatus":
                try {
                    findByStatus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                listCategory(request, response);
                break;
        }
    }

    private void findByStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String status =request.getParameter("status");
        List<CategoryShoes> categoryList = this.categoryService.findByStatus(status);
        RequestDispatcher requestDispatcher;
        if (categoryList == null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("listCategory", categoryList);//truyền tên biến tìm kiếm giống tên list quần áo
            requestDispatcher = request.getRequestDispatcher("category/list_category.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private List<Shoes> listShoes(){
        return this.shoesService.findAll();
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String trademark = request.getParameter("trademark");
        String status = request.getParameter("status");
        CategoryShoes categoryShoes = new CategoryShoes(trademark, status);
        this.categoryService.insert(categoryShoes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create_category.jsp");
        request.setAttribute("message", "Tạo mới không thành công");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String trademark = request.getParameter("trademark");
        String status = request.getParameter("status");

        CategoryShoes categoryShoes = new CategoryShoes(id, trademark, status);
        this.categoryService.updateCategory(categoryShoes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/edit_category.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.categoryService.deleteCategory(id);
        List<CategoryShoes> categories = this.categoryService.findAll();
        request.setAttribute("listCategory", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/list_category.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showEditCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/edit_category.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryShoes> categoryList = this.categoryService.findAll();
        request.setAttribute("listCategory", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list_category.jsp");
        dispatcher.forward(request, response);

    }

    private void showCreateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create_category.jsp");
        dispatcher.forward(request, response);
    }

}

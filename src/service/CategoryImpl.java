package service;

import model.CategoryShoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CategoryImpl implements ICategory {
    private String jdbcURL = "jdbc:mysql://localhost:3308/productManager?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL = "select *from info_Shose";
    private static final String INSERT_INFO_SHOES = "insert into info_Shose (trademark,status)values(?,?)";
    private static final String UPDATE_INFO_SHOES = "update info_Shose set info_Shose = ?";
    private static final String DELETE_INFO_SHOES = "delete from info_Shose where id = ?";



    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    


    @Override
    public List<CategoryShoes> findAll() {
        return null;
    }

    @Override
    public void insert(CategoryShoes categoryShose) throws Exception {

    }

    @Override
    public boolean update(int id, CategoryShoes categoryShose) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}

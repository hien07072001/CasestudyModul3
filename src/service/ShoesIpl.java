package service;

import model.Shoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ShoesIpl implements IShoesService {

    private String jdbcURL = "jdbc:mysql://localhost:3308/productManager?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_SHOES_SQL = "insert into shoes" + "  (image_link,name_shoes,price) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_SHOES = "select * from productManager.Shoes";
    private static final String DELETE_SHOES_SQL = "delete from shoes where id = ?;";
    private static final String UPDATE_SHOES_SQL = "update shoes set image_link = ?,name_shoes= ?,price =? where id = ?;";

    public ShoesIpl(){

    }
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
    public List<Shoes> findAll() {
        return null;
    }

    @Override
    public void insert(Shoes shose) throws SQLException {

    }

    @Override
    public List<Shoes> FindByCategoryID(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Shoes shose) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}

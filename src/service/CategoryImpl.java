package service;

import model.CategoryShoes;
import model.Shoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements ICategory {
    private String jdbcURL = "jdbc:mysql://localhost:3308/productManager?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL = "select *from CategoryShoes";
    private static final String INSERT_CategoryShoes = "insert into CategoryShoes (trademark,status)values(?,?)";
    private static final String UPDATE_CategoryShoes = "update CategoryShoes set CategoryShoes = ?";
    private static final String DELETE_CategoryShoes = "delete from CategoryShoes where id = ?";


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

        List<CategoryShoes> categories = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String trademark = resultSet.getString("trademark");
                String status = resultSet.getString("status");

                categories.add(new CategoryShoes(trademark, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void insert(CategoryShoes categoryShoes) throws Exception {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CategoryShoes)) {
            statement.setString(1, categoryShoes.getTrademark());
            statement.setString(2, categoryShoes.getStatus());
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean updateCategory(CategoryShoes categoryShoes) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CategoryShoes);) {
            statement.setString(1, categoryShoes.getTrademark());
            statement.setString(2, categoryShoes.getStatus());
            statement.setInt(3, categoryShoes.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CategoryShoes);) {
             statement.setInt(1, id);

             rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}

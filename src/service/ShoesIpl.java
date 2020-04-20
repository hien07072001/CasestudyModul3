package service;

import model.Shoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoesIpl implements IShoesService {

    private String jdbcURL = "jdbc:mysql://localhost:3308/productManager?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_SHOES_SQL = "insert into shoes" + "  (image_link,name_shoes,price) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_SHOES = "select * from shoes";
    private static final String DELETE_SHOES_SQL = "delete from shoes where shoes_id = ?;";
    private static final String UPDATE_SHOES_SQL = "update shoes set image_link = ?,name_shoes= ?,price =? where shoes_id = ?;";

    public ShoesIpl(){

    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Shoes> findAll() {
        List<Shoes> shoes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int shoes_id = rs.getInt("shoes_id");
                String image_link = rs.getString("image_link");
                String name_shoes = rs.getString("name_shoes");
                float price = rs.getFloat("price");
                shoes.add(new Shoes(shoes_id,image_link,name_shoes,price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return shoes;
    }



    @Override
    public void insert(Shoes shoes) throws SQLException {
        System.out.println(INSERT_SHOES_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement
                = connection.prepareStatement(INSERT_SHOES_SQL)) {
            preparedStatement.setString(1, shoes.getImage_link());
            preparedStatement.setString(2, shoes.getName_shoes());
            preparedStatement.setFloat(3, shoes.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public List<Shoes> FindByCategoryShoes() {
        List<Shoes> shoesCategory = new ArrayList<>();
        String selectAll = ";";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int shoes_id = resultSet.getInt("shoes_id");
                String image_link = resultSet.getString("image_link");
                String name_shoes = resultSet.getString("name_shoes");
                float price = resultSet.getFloat("price");
                String trademark = resultSet.getString("trademark");
                String status = resultSet.getString("status");

                shoesCategory.add(new Shoes(image_link, name_shoes, price, trademark, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesCategory;
    }

//    @Override
////    public List<Shoes> FindByCategoryShoes() {
////        List<Shoes> CategoryShoes = new ArrayList<>();
////        String selectAll = "SELECT cl.id, ca.category_name, ca.status, cl.name, cl.description, cl.picture, cl.price, cl.origin\n" +
////                "FROM category as ca INNER JOIN clothing cl on cl.category_id = ca.category_id;";
////
////        try (Connection connection = getConnection();
////             PreparedStatement statement = connection.prepareStatement(selectAll)) {
////            ResultSet resultSet = statement.executeQuery();
////            while (resultSet.next()) {
////                String image_link = resultSet.getString("image_link");
////                String name_shoes = resultSet.getString("shoes");
////                float price = Float.parseFloat(resultSet.getString("price"));
////                String trademark = resultSet.getString("trademark");
////                String status = resultSet.getString("status");
////
////                CategoryShoes.add(new Shoes(image_link,name_shoes,price,trademark,status));
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return CategoryShoes;
////    }

    @Override
    public boolean update( Shoes shoes) throws SQLException {
        boolean rowUpdated;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_SHOES_SQL)
        ) {
            statement.setString(1, shoes.getImage_link());
            statement.setString(2,shoes.getName_shoes());
            statement.setFloat(3,shoes.getPrice());
            statement.setInt(4,shoes.getShoes_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int shoes_id) throws SQLException {
        boolean rowDeleted;
        try (
                Connection connection = getConnection(); PreparedStatement statement
                = connection.prepareStatement(DELETE_SHOES_SQL);) {
            statement.setInt(1, shoes_id);

            rowDeleted = statement.executeUpdate() > 0;
        }
        return  rowDeleted;
    }

    @Override
    public List<Shoes> findByPrice(int price) throws SQLException {
        List<Shoes> shoesList = new ArrayList<>();
        String findPriceStatement = "select * from productManager.shoes sh where sh.price = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(findPriceStatement);
        ) {
            statement.setInt(1, price);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int shoes_id = resultSet.getInt(1);
                String image_link = resultSet.getString(2);
                String name_shoes = resultSet.getString(3);

                Shoes shoes = new Shoes(shoes_id,image_link,name_shoes,price);
                shoesList.add(shoes);
            }
        }
        return shoesList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

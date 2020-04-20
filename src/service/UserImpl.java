package service;

import model.LoginUser;

import java.sql.*;

public class UserImpl implements IUser {
    private String jdbcURL = "jdbc:mysql://localhost:3308/productManager?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_USER_LOGIN = "select name from productManager.user where email = ? and password = ?;";


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
    public LoginUser findUserLogin(String email, String pass) {
        LoginUser loginUser = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_USER_LOGIN)
        ) {
            statement.setString(1, email);
            statement.setString(2, pass);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                loginUser = new LoginUser(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginUser;
    }
}

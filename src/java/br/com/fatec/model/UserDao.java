package br.com.fatec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.bean.User;
import br.com.fatec.util.ConnectionDatabase;

public class UserDao {
    private final Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    public UserDao() throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionDatabase().getConnection();
    }
    
    public User search(User user) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        
        try {
            prepareStatement(sql);
            statement.setInt(1, user.getId());
            executeQuery();
            
            while (resultSet.next()) {
                user = getPoputateUser();
            }
            return user;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        } finally {
            try {
                dispose();
            } catch (SQLException error) {
                throw new RuntimeException(error);
            }
        }
    }
    
    public List<User> list(User user) throws SQLException {
        
        List<User> usersList = new ArrayList<>();
        String SQL = "SELECT * FROM user WHERE name like ?";
        
        prepareStatement(SQL);
        
        statement.setString(1, "%" + user.getName() + "%");
        
        executeQuery();
        
        while (resultSet.next()) {
            usersList.add(getPoputateUser());
        }
        try {
            dispose();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
        return usersList;
    }
    
    public User insert(User user) throws SQLException {
        String SQL = "INSERT INTO user" + 
            "(login, password, status, tipo) values (?, ?, ?, ?, ?)";
        
        prepareStatement(SQL);
        
        statement.setString(1, user.getName());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getStatus());
        statement.setString(5, user.getType());
        
        try {
            dispose();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
        return user;
    }
    
    public User exclude(User user) throws SQLException {
        String SQL = "DELETE FROM user WHERE id = ?";
        prepareStatement(SQL);
        
        statement.setInt(1, user.getId());
        
        try {
            dispose();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
        return user;
    }
    
    public User alter(User user) throws SQLException {
        String SQL = "UPDATE user SET " + 
            "name=?, login=?, password=?, status=?, type=? WHERE id=?";
        prepareStatement(SQL);
        
        statement.setString(1, user.getName());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getStatus());
        statement.setString(5, user.getType());
        statement.setInt(6, user.getId());
        
        try {
            dispose();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
        
        return user;
    }
    
    public User validateLogin(User user) throws SQLException {
        String SQL = "SELECT * FROM user WHERE login=? AND password=?";
        prepareStatement(SQL);
        
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getPassword());
        
        executeQuery();
        
        while (resultSet.next()) {
            user = getPoputateUser();
        }
        try {
            dispose();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
        return user;
    }
    
    private User getPoputateUser() throws SQLException {
        User user = new User();
            
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setLogin(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        user.setStatus(resultSet.getString(5));
        user.setType(resultSet.getString(6));
        
        return user;
    }
            
    
    private void prepareStatement(String sql) throws SQLException {
        statement = connection.prepareStatement(sql);
    }
    
    private void executeQuery() throws SQLException {
        resultSet = statement.executeQuery();
    }
    
    private void dispose() throws SQLException {
        if (resultSet != null)
            resultSet.close();
        
        if (statement != null)
            statement.close();
        
        if (connection != null)
            connection.close();
    }
}

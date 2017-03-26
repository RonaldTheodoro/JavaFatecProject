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
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setStatus(resultSet.getString(5));
                user.setType(resultSet.getString(6));
            }
            return user;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    public List<User> list(User user) throws SQLException {
        
        List<User> usersList = new ArrayList<>();
        String SQL = "SELECT * FROM user WHERE name like ?";
        
        prepareStatement(SQL);
        
        statement.setString(1, "%" + user.getName() + "%");
        
        resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            User userData = new User();
            
            userData.setId(resultSet.getInt(1));
            userData.setLogin(resultSet.getString(2));
            userData.setPassword(resultSet.getString(3));
            userData.setStatus(resultSet.getString(4));
            userData.setType(resultSet.getString(5));
            
            usersList.add(userData);
        }
        resultSet.close();
        statement.close();
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
        
        statement.execute();
        statement.close();
        return user;
    }
    
    public User exclude(User user) throws SQLException {
        String SQL = "DELETE FROM user WHERE id = ?";
        prepareStatement(SQL);
        
        statement.setInt(1, user.getId());
        
        statement.execute();
        statement.close();
        connection.close();
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
        
        statement.execute();
        statement.close();
        
        return user;
    }
    
    public User validateLogin(User user) throws SQLException {
        String SQL = "SELECT * FROM user WHERE login=? AND password=?";
        prepareStatement(SQL);
        
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getPassword());
        
        resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setLogin(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));
            user.setStatus(resultSet.getString(5));
            user.setType(resultSet.getString(6));
        }
        statement.close();
        return user;
    }
    
    private void prepareStatement(String sql) throws SQLException {
        statement = connection.prepareStatement(sql);
    }
}

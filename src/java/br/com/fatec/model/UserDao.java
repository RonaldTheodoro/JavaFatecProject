package br.com.fatec.model;

import br.com.fatec.bean.User;
import br.com.fatec.util.ConnectionDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final Connection connection;
    
    public UserDao() throws SQLException, ClassNotFoundException {
        this.connection = new ConnectionDatabase().getConnection();
    }
    
    public User search(User user) throws SQLException {
        String SQL = "SELECT * FROM user WHERE id ?";
        
        try (
            PreparedStatement preparedStatement = 
                this.connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setStatus(resultSet.getString(5));
                user.setType(resultSet.getString(6));
                
            }
        }
        return user;
    }
    
    public List<User> list(User user) throws SQLException {
        
        List<User> usersList = new ArrayList<>();
        String SQL = "SELECT * FROM user WHERE login like ?";
        
        PreparedStatement preparedStatement =
            this.connection.prepareStatement(SQL);
        
        preparedStatement.setString(1, "%" + user.getLogin() + "%");
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            User userData = new User();
            
            userData.setId(resultSet.getInt(1));
            userData.setLogin(resultSet.getString(2));
            userData.setPassword(resultSet.getString(3));
            userData.setStatus(resultSet.getString(4));
            userData.setType(resultSet.getString(5));
            
            usersList.add(userData);
        }
        
        return usersList;
    }
    
    public void insert(User user) throws SQLException {
        String SQL = "INSER INTO user (login, password, status, tipo) values (?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getStatus());
        preparedStatement.setString(4, user.getType());
        
        preparedStatement.execute();
        preparedStatement.close();
    }
    
    public void exclude(User user) throws SQLException {
        String SQL = "DELETE FROM user WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        
        preparedStatement.setInt(1, user.getId());
        
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
    
    public User alter(User user) throws SQLException {
        String SQL = "UPDATE user SET login = ?, password = ?, status = ?, type = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getStatus());
        preparedStatement.setString(4, user.getType());
        preparedStatement.setInt(5, user.getId());
        
        preparedStatement.execute();
        preparedStatement.close();
        
        return user;
    }
    
    public User validateLogin(User user) throws SQLException {
        String SQL = "SELECT * FROM user WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setLogin(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));
            user.setStatus(resultSet.getString(5));
            user.setType(resultSet.getString(6));
        }
        preparedStatement.close();
        return user;
    }
}

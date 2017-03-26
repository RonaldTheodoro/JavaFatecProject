package br.com.fatec.controller;

import java.sql.SQLException;
import java.util.List;
import br.com.fatec.bean.User;
import br.com.fatec.model.UserDao;



public class UserController {
    private final UserDao userDao;

    public UserController() throws SQLException, ClassNotFoundException {
        this.userDao = new UserDao();
    }
    
    public User insertUser(User user) throws SQLException {
        return userDao.insert(user);
    }
    
    public User alterUser(User user) throws SQLException {
        return userDao.alter(user);
    }
    
    public User removeUser(User user) throws SQLException {
        return userDao.exclude(user);
    }
    
    public List<User> listUser(User user) throws SQLException {
        List<User> userArray = userDao.list(user);
        return userArray;
    }
    
    public User searchUser(User user) throws SQLException {
        return userDao.search(user);
    }
    
    public User validateLogin(User user) throws SQLException {
        return userDao.validateLogin(user);
    }
}

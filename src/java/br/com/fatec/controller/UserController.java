package br.com.fatec.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fatec.bean.User;
import br.com.fatec.model.UserDao;



public class UserController {
    
    public User insertUser(User user) {
        user.setType("Test Type");
        return user;
    }
    
    public User alterUser(User user) {
        return user;
    }
    
    public User removeUser(User user) {
        return user;
    }
    
    public List<User> listUser(User user) {
        List<User> userArray = new ArrayList();
        return userArray;
    }
    
    public User searchUser(User user) 
        throws SQLException, ClassNotFoundException {
        
        UserDao userDao = new UserDao();
        user = userDao.search(user);
        return user;
    }
    
    public User validateLogin(User user)
        throws SQLException, ClassNotFoundException {
        
        UserDao userDao = new UserDao();
        user = userDao.validateLogin(user);
        return user;
    }
}

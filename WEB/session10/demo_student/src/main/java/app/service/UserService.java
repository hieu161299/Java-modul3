package app.service;

import app.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(1,"hieuvp","1","user"));
        userList.add(new User(2,"quang","1","user"));
    }
    public void add(User user){
        this.userList.add(user);
    }
    public boolean checkUser(String username, String password) {
        for (User user: userList) {
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public int getIdUser(String username, String password) {
        for (User user: userList) {
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user.getId();
            }
        }
        return -1;
    }

    public User getUser (int id){
        for (User user: userList) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

}

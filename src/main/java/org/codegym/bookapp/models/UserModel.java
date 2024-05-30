package org.codegym.bookapp.models;

import org.codegym.bookapp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users = new ArrayList<User>();

    public UserModel() {
        User u1 = new User(1, "Nam", "nam123", "1234");
        User u2 = new User(2, "Quan", "quan34", "1234");
        User u3 = new User(3, "Tien", "tiendepzai", "1234");
        User u4 = new User(4, "Duy", "duy2000", "1234");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
    }

    public User findUserByAccount(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}

package com.rest.service;

import com.rest.model.User;

import java.util.List;

public interface UserService {

    public User getUser(int id);
    public List<User> getUsers();
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(int userId);
    public List<User> findBySurname(String surname);
}

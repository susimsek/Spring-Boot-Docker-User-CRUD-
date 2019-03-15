package com.rest.service;

import com.rest.dao.UserRepository;
import com.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS )
    @Override
    public User getUser(int id) {
        User user=userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(int userId) {
        User user=userRepository.getOne(userId);
        if(user!=null){
            userRepository.delete(user);
        }

    }

    @Override
    public List<User> findBySurname(String surname) {
        return userRepository.findBySurname(surname);
    }
}

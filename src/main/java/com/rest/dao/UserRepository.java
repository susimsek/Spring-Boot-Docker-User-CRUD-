package com.rest.dao;

import com.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(name = "select u from User where u.surname=?1")
    public List<User> findBySurname(String surname);
}

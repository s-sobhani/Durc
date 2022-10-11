package com.example.durc.Durc.service;

import com.example.durc.Durc.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    User update(User user);

    void deleteById(String id);

    Optional<User> findById(String id);

    List<User> findAllUser();


}

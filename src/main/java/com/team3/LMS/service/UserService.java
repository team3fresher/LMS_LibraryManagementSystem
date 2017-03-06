package com.team3.LMS.service;

import org.springframework.data.repository.CrudRepository;

import com.team3.LMS.dto.User;

public interface UserService extends CrudRepository<User, Integer> {

}

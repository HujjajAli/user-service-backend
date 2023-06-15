package com.product.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.product.user.orm.User;



public interface UserRepository extends RevisionRepository<User, Long, Long>,JpaRepository<User, Long> {

}

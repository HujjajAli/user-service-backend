package com.product.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.product.user.orm.UserEntity;



public interface UserRepository extends RevisionRepository<UserEntity, Long, Long>,JpaRepository<UserEntity, Long> {

}

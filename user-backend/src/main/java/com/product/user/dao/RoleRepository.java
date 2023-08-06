package com.product.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.user.orm.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	RoleEntity findByRoleCode(String roleCode);
}

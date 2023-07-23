package com.product.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.user.service.impl.config.PasswordServiceConfig;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class PasswordService {
	
	@Autowired
	private PasswordServiceConfig passwordConfig;

	public String securePassword(String password) {
		String securePassword = "";
		
		Argon2 argon2 = getArgon2Instance();
		securePassword = argon2.hash(passwordConfig.getIterations(), passwordConfig.getMemory(), 
				passwordConfig.getParralellism(), password.toCharArray());
		
		return securePassword;
	}

	public Argon2 getArgon2Instance() {
		Argon2Factory.Argon2Types type = Argon2Factory.Argon2Types.ARGON2d;
		
		if(passwordConfig.getType() == 1) {
			type = Argon2Factory.Argon2Types.ARGON2i;
		}
		
		return Argon2Factory.create(type,passwordConfig.getSaltLength(),passwordConfig.getHashLength());
	}
}

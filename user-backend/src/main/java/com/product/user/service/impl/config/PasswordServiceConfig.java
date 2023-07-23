package com.product.user.service.impl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "password.hashing.algo.argon2")
public class PasswordServiceConfig {
	
    private int type;
    private int saltLength;
    private int hashLength;
    private int iterations;
    private int memory;
    private int parralellism;

}

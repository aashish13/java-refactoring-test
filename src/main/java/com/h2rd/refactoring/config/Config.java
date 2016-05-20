/**
 * 
 */
package com.h2rd.refactoring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.h2rd.refactoring.data.dao.UserDao;

/**
 * @author Aashish
 *
 */
@Configuration
@ComponentScan("com.h2rd.refactoring")
public class Config {
	public Config() {
	}
	
	@Bean(name="userDao")
	public UserDao getUserDao(){
		return new UserDao();
	}
}

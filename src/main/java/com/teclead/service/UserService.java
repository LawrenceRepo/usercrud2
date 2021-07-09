/**
 * 
 */
package com.teclead.service;

import java.util.List;

import com.teclead.model.User;

/**
 * @author anumudu
 *
 */
public interface UserService
	{
		
		String createUser(User userDetails);
		
		List <User> getUserDetails();
		
		String updateUserDetail(User user);
		
		String deleteUserById(Integer id);
		
		List <User> getUserByFirstName(String firstName);
		
		List <User> getUserByLastName(String lastName);
		
		String deleteAllUser();
		
	}

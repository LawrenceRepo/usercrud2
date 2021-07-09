/**
 * 
 */
package com.teclead.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teclead.model.User;
import com.teclead.service.UserService;

/**
 * @author anumudu
 *
 */
@RestController
@RequestMapping(path = "/user")
public class UserController
	{
		// https://logback.qos.ch/manual/configuration.html
		private static final Logger	logger	= LoggerFactory.getLogger(UserController.class);
		
		@Autowired
		private UserService					userService;
		
		// http://localhost:8000/user/createuser
		@RequestMapping(method = RequestMethod.POST, value = "/createuser")
		public String createAccount(@RequestBody User userDetails)
			{
				logger.info("Going to create User by user details : {}", userDetails);
				return userService.createUser(userDetails);
			}
			
		// http://localhost:8000/user/getuserdetails
		@RequestMapping(method = RequestMethod.GET, value = "/getuserdetails")
		public List <User> getUserDetails()
			{
				logger.info("Going to get user details");
				return userService.getUserDetails();
			}
			
		// http://localhost:8000/user/update
		@RequestMapping(method = RequestMethod.POST, value = "/update")
		public String updateUserDetail(@RequestBody User user)
			{
				logger.info("Going to updateUserDetail");
				return userService.updateUserDetail(user);
			}
			
		// http://localhost:8000/user/getuserbyfirstname
		@RequestMapping(method = RequestMethod.GET, value = "/getuserbyfirstname/{firstName}")
		public List <User> getUserByFirstName(@PathVariable(name = "firstName") String firstName)
			{
				logger.info("Going to getUserByFirstName : {}", firstName);
				return userService.getUserByFirstName(firstName);
			}
			
		// http://localhost:8000/user/getuserbylastname
		@RequestMapping(method = RequestMethod.GET, value = "/getuserbylastname/{lastName}")
		public List <User> getUserByLastName(@PathVariable(name = "lastName") String lastName)
			{
				logger.info("Going to getUserByLastName : {}", lastName);
				return userService.getUserByLastName(lastName);
			}
			
		// http://localhost:8000/user
		@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
		public String deleteUserById(@PathVariable(name = "id") int id)
			{
				logger.info("Going to delete User By Id : {}", id);
				return userService.deleteUserById(id);
			}
			
		// http://localhost:8000/deletealluser
		@RequestMapping(method = RequestMethod.GET, value = "/deletealluser")
		public String deleteAllUser()
			{
				logger.info("Going to delete All User");
				return userService.deleteAllUser();
			}
			
	}

package com.teclead.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teclead.model.User;
import com.teclead.repository.UserRepository;
import com.teclead.service.UserService;

/**
 * @author anumudu
 *
 */
@Service
public class UserServiceImpl implements UserService
	{
		// https://logback.qos.ch/manual/configuration.html
		private static final Logger	logger	= LoggerFactory.getLogger(UserServiceImpl.class);
		
		@Autowired
		private UserRepository			userRepository;
		
		@Override
		public String createUser(User userDetails)
			{
				logger.info("Going to create User with UserDetails : {}", userDetails);
				
				String msg = "User is Sucessfully Created";
				
				try
					{
						userRepository.save(userDetails);
					}
				catch (Exception e)
					{
						logger.error("Error while creating User, err msg : {}", e.getMessage());
						
						msg = "Something went wrong while creating User";
					}
				return msg;
			}
			
		@Override
		public String deleteUserById(Integer id)
			{
				logger.info("Going to delete user by Id : {}", id);
				
				String msg = "Something going wrong while deleting User by Id.";
				
				try
					{
						Optional <User> existingUser = userRepository.findById(id);
						
						if (existingUser.isPresent())
							{
								userRepository.deleteById(id);
								
								msg = "User wassuccessfully deleted.";
							}
						else
							{
								msg = "User is not available for the given id : " + id;
							}
					}
				catch (Exception e)
					{
						logger.error("Error while deleting user, err msg : {}", e.getMessage());
					}
					
				return msg;
			}
			
		@Override
		public List <User> getUserDetails()
			{
				logger.info("Going to get User Details");
				
				List <User> users = new ArrayList <>();
				
				try
					{
						users = (List <User>) userRepository.findAll();
					}
				catch (Exception e)
					{
						logger.error("Error while getting user details, err msg : {}", e.getMessage());
					}
					
				return users;
			}
			
		@Override
		public String updateUserDetail(User user)
			{
				String msg = "Error while updating user details";
				try
					{
						Optional <User> userData = userRepository.findById(user.getId());
						
						if (userData.isPresent())
							{
								User userDetail = userData.get();
								
								userDetail.setFirstName(user.getFirstName());
								userDetail.setEmail(user.getEmail());
								userDetail.setLastName(user.getLastName());
								
								userRepository.save(userDetail);
								
								msg = "User details was successfully updated.";
							}
						else
							{
								msg = "Given user detail is not available in database";
							}
					}
				catch (Exception e)
					{
						logger.error("Error while updating user details");
					}
				return msg;
			}
			
		@Override
		public List <User> getUserByFirstName(String firstName)
			{
				logger.info("Going to getUserByFirstName : {}", firstName);
				
				List <User> users = new ArrayList <>();
				
				try
					{
						users = userRepository.findByFirstName(firstName);
					}
				catch (Exception e)
					{
						logger.error("Error while get user by Firstnames, err msg : {}", e.getMessage());
					}
				return users;
			}
			
		@Override
		public List <User> getUserByLastName(String lastName)
			{
				logger.info("Going to getUserByLastName : {}", lastName);
				
				List <User> users = new ArrayList <>();
				
				try
					{
						users = userRepository.findByLastName(lastName);
					}
				catch (Exception e)
					{
						logger.error("Error while get user by lastNames, err msg : {}", e.getMessage());
					}
				return users;
			}
			
		@Override
		public String deleteAllUser()
			{
				logger.info("Going to deleteAllUser");
				
				String msg = "Sucessfully deleted All User";
				
				try
					{
						userRepository.deleteAll();
					}
				catch (Exception e)
					{
						logger.error("Error while deleting All User, err msg : {}", e.getMessage());
					}
					
				return msg;
			}
			
	}

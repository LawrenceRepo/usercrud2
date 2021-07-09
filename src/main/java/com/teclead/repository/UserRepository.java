/**
 * 
 */
package com.teclead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.teclead.model.User;

/**
 * @author anumudu
 *
 */
public interface UserRepository extends CrudRepository <User, Integer>
	{
		
		List <User> findByFirstName(String firstname);
		
		List <User> findByLastName(String lastname);
		
	}

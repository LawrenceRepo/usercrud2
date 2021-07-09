/**
 * 
 */
package com.teclead.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author anumudu
 *
 */

@Entity
@Table(name = "User")
public class User
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@SequenceGenerator(name = "User_seq", sequenceName = "User_seq", allocationSize = 1)
		private Integer	id;
		
		private String	firstName;
		
		private String	lastName;
		
		private String	email;
		
	
		public User()
			{
	       super();
			}
		
			
		public User(String firstName, String lastName, String email)
			{
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
			}

		public Integer getId()
			{
				return id;
			}
			
		public void setId(Integer id)
			{
				this.id = id;
			}
			
		public String getFirstName()
			{
				return firstName;
			}
			
		public void setFirstName(String firstName)
			{
				this.firstName = firstName;
			}
			
		public String getLastName()
			{
				return lastName;
			}
			
		public void setLastName(String lastName)
			{
				this.lastName = lastName;
			}
			
		public String getEmail()
			{
				return email;
			}
			
		public void setEmail(String email)
			{
				this.email = email;
			}
			
		@Override
		public String toString()
			{
				StringBuilder builder = new StringBuilder();
				builder.append("User [id=");
				builder.append(id);
				builder.append(", firstName=");
				builder.append(firstName);
				builder.append(", lastName=");
				builder.append(lastName);
				builder.append(", email=");
				builder.append(email);
				builder.append("]");
				return builder.toString();
			}
			
	}

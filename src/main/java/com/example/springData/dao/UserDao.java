package com.example.springData.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springData.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	public List<User> findByUserNameIn(Collection<String> usernames);
	
	public List<User> findByUserName(String Name);
	
	public List<User> findByUserNameStartingWith(String Name);

	 public List<User> findByUserNameOrPhoneNo(String userName, long contactNumber);

	 public List<User> findByUserNameAndPhoneNo(String userName, long contactNumber);

	 
	 public List<User> findByUserNameOrderByPhoneNoDesc(String Name);
	 
	 @Query("SELECT u.gender ,count(*) FROM User u "
		 		+ "GROUP BY u.gender") 
		 public Object[] getAverageAge();
	 
	 public  List<User> searchByCity(@Param("city") String city);
	
/*
	
	
	
	
	
	
	
	
	
	
	
	
		
			
		
		 
		 //named query
		
*/
}

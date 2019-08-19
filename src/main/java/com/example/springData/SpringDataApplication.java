package com.example.springData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.springData.dao.UserDao;
import com.example.springData.entity.Address;
import com.example.springData.entity.User;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataApplication.class, args);
		UserDao userDao=(UserDao)context.getBean("userDao");
		System.out.println(userDao.count());

		// crud operation
		// insert
		User user=new User();
		user.setUserName("rohit");
		user.setDescription("hello23");
		//user.setGender(Gender.female);
		user.setDob(new Date());
		
		Address address=new Address();
		address.setCity("coimbatore");
		address.setPinCode(641012);
		address.setState("Tamil Nadu");
		address.setStreet("kalluri");
		user.setAddress(address);
		//user.setUserId(3);
		
		userDao.saveAndFlush(user);
		
		//List<User> users=userDao.findAll();
		
		List<String> usernames=new ArrayList<String>();
		usernames.add("ganesh");
		usernames.add("rohit");
		
		// select where username
		List<User> users=userDao.findByUserNameIn(usernames);
		
		users.stream().forEach(user3->
				System.out.println(user3.getUserName()+" "+user3.getUserId()));
		//userDao.findById(1001);
		//userDao.save(user);
		//userDao.delete(user);
	}
	
	
		//userDao.saveAndFlush(user);
		
		/*		// read
		User u=userDao.getOne(1);
		
		Optional o=userDao.findById(1);
		if(o.isPresent())
			System.out.println(o.get());
		
		
		// update
		u.setUserName("rajesh");
		userDao.save(u);
		
		// delete
		userDao.delete(u);
		
		
		//search
		List <User>users=userDao.findAll();
		System.out.println(users);

		
		// search by one or more condition
		
		//username
		//List<User> users=userDao.findByUserName("kishore");
		//List<User> users=userDao.findByUserNameEndingWith("esh");
		//List<User> users=userDao.findByUserNameOrderByPhoneNoDesc("suresh");
		//Object[] obj =userDao.getAverageAge();
		//System.out.println(obj);
		
		
		List<User> users=userDao.searchByCity("coimbatore");
		
		
		
		
		
		// order by
		
		
		
		// group by
		
		
		
		// somqequery
	
		
		//named query
	
	}
		*/	
	    @Bean
		public CommandLineRunner commandLineRunner(ApplicationContext ctx){
			return (args) -> {
				System.out.println("ctx.getBeanDefinitionCount()"+ctx.getBeanDefinitionCount());	
						Arrays.stream(ctx.getBeanDefinitionNames())
						.sorted()
						.forEach(name->System.out.println(name));
			
			};
	}
}

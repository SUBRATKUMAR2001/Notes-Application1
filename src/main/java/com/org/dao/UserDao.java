package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
	
	public void saveAndUpdateUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	
	    et.begin();
	    em.merge(user);
	    et.commit();
	}
	
	public User fetchUserById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
	    EntityManager em = emf.createEntityManager();
	    User user = em.find(User.class, id);
	    
	    user.getId();
	    user.getName();
	    user.getAge();
	    user.getMobile();
	    user.getEmail();
	    user.getPassword();
	    
	    return user;
	}
	
	public List<User>fetchAllUsers(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
	    EntityManager em = emf.createEntityManager();
	    Query query = em.createQuery("select s from User s");
	    List<User> list = query.getResultList();
	    return list;
	    
	}
	

}

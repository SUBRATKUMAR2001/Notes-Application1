package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
	public void saveAndUpdateUser(User user) {
	
		et.begin();
	    em.merge(user);
	    et.commit();
	}
	
	public User fetchUserById(int id) {
		    return em.find(User.class, id);
	    
	  }
	public User fetchUserByEmailAndPassword(String email,String password) {
		String query = "select s from User s where email=?1 and password=?2";
		Query query1 = em.createQuery(query);
		
		query1.setParameter(1, email);
		query1.setParameter(2, password);
		 List<User> list = query1.getResultList();
		 if(list.isEmpty()) {
			 return null;
		 }
		return list.get(0); 
		
	}
	
	public List<User>fetchAllUsers(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
	    EntityManager em = emf.createEntityManager();
	    Query query = em.createQuery("select s from User s");
	    List<User> list = query.getResultList();
	    return list;
	}
	

}

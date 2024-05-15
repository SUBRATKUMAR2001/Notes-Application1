package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Note;

public class NoteDao {
	public Note fetchNoteById(int id) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
    EntityManager em = emf.createEntityManager();
    Note note = em.find(Note.class,id);
    return note;
	}  
  public List<Note> fetchAllNotes(){
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("subrat");
	    EntityManager em = emf.createEntityManager();
	 Query query = em.createQuery("select n from Note n");   
     List <Note> list = query.getResultList(); 
     return list;
  }




}

package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Note;
import com.org.dto.User;
@WebServlet("/update")
public class UpdateNotes extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int id = Integer.parseInt(req.getParameter("id"));
		
		Note notes = new Note();
		notes.setTitle(title);
		notes.setDescription(description);
		notes.setId(id);
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userobj");
		
		List<Note> list = new ArrayList();
		list.add(notes);
		System.out.println(notes.getDescription());
		
		user.setNotesList(list);
		notes.setUser(user);
		
		UserDao dao=new UserDao();
		dao.saveAndUpdateUser(user);
		
		
		session.setAttribute("success", "Update successfully");
		resp.sendRedirect("Home.jsp");
	}

}

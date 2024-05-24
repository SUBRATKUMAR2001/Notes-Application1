<%@page import="com.org.dto.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="component/BootStrapCss.jsp"%>
</head>
<body>

<% User user=(User)session.getAttribute("userobj"); 
   if(user==null){
	   response.sendRedirect("Login.jsp");
   }else{
%>



	<%@ include file="component/HomeNavbar.jsp"%>
	
	<h1 class="text-center"> WELCOME TO HOME PAGE</h1>
	
	<% String msg = (String) session.getAttribute("success"); 
						if(msg != null){
						%>
						<p class = "text-center text-success fs-4"> <%= msg %></p>
						
						<%
						session.removeAttribute("success");
						}%>
	<%
	int id = user.getId();
	UserDao dao = new UserDao();
	User u = dao.fetchUserById(id);
	List<Note> list = u.getNotesList();%>
	<div class="container border">
	   <div>
<a href="Addnotes.jsp" class ="btn btn-success text-decoration-none">ADD NOTES</a>
	
	   </div>
	   <div class="row">
	   <%
	   for(Note n : list){
		 %>  
	   <div class="col-md-4 card border border-primary m-4" style="width:15cem">
	     <div class="card-body">
	       <div class="d-flex-wrap justify-content-evenly">
	       
	       <div>
	       <h2 class="text-success card-title"><%= n.getTitle()%></h2>
	       <a href="ViewNote.jsp?id=<%=n.getId()%>" class ="btn btn-sm btn-info text-decoration-none">VIEW</a>
	       <a href="ViewNote.jsp?id=<%=n.getId()%>" class ="btn btn-sm btn-info text-decoration-none">UPDATE</a>
	       <a href="#" class ="btn btn-sm btn-danger text-decoration-none">DELETE</a>
	    </div>
	       
	       
	       
	       </div>
	     </div>
	    </div>
	    <%} %>
	  

	  
	   </div>
	</div>
	<%} %>
</body>
</html>
<%@page import="com.org.dto.Note"%>
<%@page import="com.org.dao.NoteDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW PAGE</title>
<%@ include file="component/BootStrapCss.jsp"%>
</head>
<body>
	<%
	User user = (User) session.getAttribute("userobj");
	if (user == null) {
		response.sendRedirect("Login.jsp");
	} else {
	%>
	<%@ include file="component/HomeNavbar.jsp"%>

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	NoteDao dao = new NoteDao();
	Note n = dao.fetchNoteById(id);
	
	%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center"><%=user.getName()%>Notes
						</p>


						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">TITLE</label> <input name="title"
									type="text" class="form-control" value="<%=n.getTitle()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label" >DESCRIPTION</label>
								<%-- <p><%=n.getDescription() %></p> --%>
								<textarea rows="10" cols="46" name ="description"><%=n.getDescription()%></textarea>
							</div>
							<input type="hidden" name="id" value="<%=n.getId()%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%
	}
	%>
</body>
</html>
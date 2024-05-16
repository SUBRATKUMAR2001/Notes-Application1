<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="component/BootStrapCss.jsp" %>
</head>
<body>
<%@ include file="component/HomeNavbar.jsp"%>
<%User user = (User) session.getAttribute("userobj"); %>
<h1 style="text-allign:center;color:blue">
User name:<%=user.getName() %><br>
User age:<%=user.getAge() %><br>
User mobile:<%=user.getMobile() %><br>
User email:<%=user.getEmail() %><br>

</body>
</html>
<%@page import="vo.UserVO"%>
<%@page import="dao.UserDAO"%>
<%@page import="service.UsersServiceImpl"%>
<%@page import="service.UsersService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<h3>login 처리</h3>

<!-- java code 영역 -->
<%
	String id = request.getParameter("id"); // html의 name값
	String pw = request.getParameter("pw"); 
	
	UserDAO dao = new UserDAO();
	UsersService service = new UsersServiceImpl(dao);
	
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(pw);
	
	UserVO data = service.usersLogin(vo);
	
%>
<!-- 출력 의미 -->
입 력 정 보 : <%= id %> / <%= pw %> <br>
로그인 정보 : <%= data %>

<p>
<a href="index.html"></a>
</p>

<a href="index.html">Home으로</a>
</body>
</html>
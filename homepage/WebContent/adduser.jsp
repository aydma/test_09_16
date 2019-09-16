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
<title>adduser.jsp</title>
</head>
<body>
<h3>회 원 가 입 처 리</h3>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String role = request.getParameter("role");
	
	
	UserDAO dao = new UserDAO();
	UsersService service = new UsersServiceImpl(dao); // 인플객체에 dao객체 정보를 인젝션한다.
	
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(pw);
	vo.setName(name);
	vo.setRole(role);
	
	int c = service.addUsers(vo);
	
%>
입력정보: <%=id %> /<%=pw %> /<%=name %>/<%=role %>

<%
	if(c==0){
%>
		<h4>회원가입실패</h4>

<%
	} else {

%>
	<h4>회원가입성공</h4>
<%
	}

%>	
	
	
<a href="index.html">home으로</a>

</body>
</html>
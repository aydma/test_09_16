<%@page import="vo.UserVO"%>
<%@page import="service.UsersServiceImpl"%>
<%@page import="service.UsersService"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");

UserDAO dao = new UserDAO();
UsersService service = new UsersServiceImpl(dao);

UserVO vo = new UserVO();
vo.setId(id);

int data = service.checkUsers(vo);

%>

{
"id":<%=data %>
}

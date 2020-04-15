<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
  	String url = null;
  	if(request.getSession().getAttribute("admin")!=null)
	  	url="admin.jsp";
  	else if(request.getSession().getAttribute("student")!=null)
	 	url="student.jsp";
  	else if(request.getSession().getAttribute("teacher")!=null)
 		url="teacher.jsp";
  	else
  		url="login.jsp";
  	request.getRequestDispatcher(url).forward(request,response);
 %>
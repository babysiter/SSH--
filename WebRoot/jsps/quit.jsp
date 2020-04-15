<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  	if(request.getSession().getAttribute("admin")!=null)
  		request.getSession().removeAttribute("admin");
	else if(request.getSession().getAttribute("student")!=null)
  		request.getSession().removeAttribute("student");
  	else if(request.getSession().getAttribute("teacher")!=null)
  		request.getSession().removeAttribute("teacher");
  	request.getRequestDispatcher("login.jsp").forward(request,response);
 %>
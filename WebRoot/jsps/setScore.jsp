<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%	int studentID , teacher_courseID;
	if(request.getParameter("studentID")!=null){
		studentID=Integer.parseInt(request.getParameter("studentID"));
		request.setAttribute("studentID", studentID);
	}
	if(request.getParameter("teacher_courseID")!=null){
		teacher_courseID=Integer.parseInt(request.getParameter("teacher_courseID"));
		request.setAttribute("teacher_courseID", teacher_courseID);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'setScore.jsp' starting page</title>
    
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/head.css">
  </head>
  
  <body>
  <!--head开始-->
	<div class="head">
	    <div class="container">
	        <div class="c">
	            <div class="left">
	                <image id="logo" src="${pageContext.request.contextPath }/images/logo_2.png"></image>
	                <span>教学综合信息服务平台</span></div>
	        </div>
	        <div class="right">
	            <a href="/javaeeFianl/jsps/aboutMe.jsp"><img id="userlogo" src="${pageContext.request.contextPath }/images/user_logo.jpg" ></a>
	        </div>
	    </div>
	</div>
<!--head结束-->
    <form id="form" action="setScoreteacherAction" method="get">
    	<s:hidden name="student_course.cc.student.studentID" value="%{#request.studentID }"/>
    	<s:hidden name="student_course.cc.teacher_course.teacher_courseID" value="%{#request.teacher_courseID }"/>
		成绩：<input type="text" name="student_course.grade"/>
		<input type="submit" value="添加"/>
  </form>
  <a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

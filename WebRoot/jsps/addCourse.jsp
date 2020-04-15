<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'addCourse.jsp' starting page</title>
    
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
	<h2>添加课程</h2>
    <form id="form" action="javaeeFinal/addCourseadminAction" method="post"> 
		<span>课程名称：<input type="text" name="course.courseName" /> </span>
		<span>学	      分：<input type="text" name="course.credit" /></span> 
		<span>学	      时:<input type="password" name="course.period" /></span>
		<input type="submit" value="添加"/>
		</form>
		<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

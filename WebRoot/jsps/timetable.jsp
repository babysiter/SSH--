<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'timetable.jsp' starting page</title>
    
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
	    </div>q
	</div>
	<!--head结束-->
	<h2>课程表</h2>
    <table>
  		<tr>
  			<th>课程名称</th>
  			<th>任课老师</th>
  			<th>上课地点</th>
  			<th>学期</th>
  			<th>上课时间</th>
  		</tr>
  		<c:forEach items="${sessionScope.allStudent_courses}" var="t">
  		<tr>
  			<td>${t.teacher_course.course.courseName}</td>
  			<td>${t.teacher_course.teacher.teacher_name}</td>
  			<td>${t.teacher_course.classroom.place}</td>
  			<td>${t.teacher_course.semester}</td>
  			<td>${t.teacher_course.classroom.time}</td>
		</tr>
  		</c:forEach>
  	</table>
  	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

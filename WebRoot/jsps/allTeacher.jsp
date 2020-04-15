<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allTeacher.jsp' starting page</title>
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
	            <a href="/javaeeFinal/jsps/aboutMe.jsp"><img id="userlogo" src="${pageContext.request.contextPath }/images/user_logo.jpg" ></a>
	        </div>
	    </div>
	</div>
<!--head结束-->
<h2>所有老师</h2>
  	<table>
  		<tr>
  			<th>教师工号</th>
  			<th>教师性别</th>
  			<th>教师姓名</th>
  			<th>家庭住址</th>
  			<th>身份证号</th>
  			<th>电话号码</th>
  			<th>办公室地址</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allTeachers}" var="t">
  		<tr>
  			<td>${t.teacherID}</td>
  			<td>${t.sex}</td>
  			<td>${t.teacher_name}</td>
  			<td>${t.address}</td>
  			<td>${t.IDNumber}</td>
  			<td>${t.phone}</td>
  			<td>${t.office}</td>
  			<td>
  				<a href="${pageContext.request.contextPath}/jsps/changeTeacher.jsp?teacherID=${t.teacherID}">修改老师信息</a>
  				<a href="${pageContext.request.contextPath}/deleteTeacheradminAction?teacher.teacherID=${t.teacherID}">删除老师信息</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	 	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

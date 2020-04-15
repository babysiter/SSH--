<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'aboutMe.jsp' starting page</title>
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
	            <a href="#"><img id="userlogo" src="${pageContext.request.contextPath }/images/user_logo.jpg" ></a>
	        </div>
	    </div>
	</div>
<!--head结束-->
  	<h2>个人信息</h2>
   <ul>
   	<li><span>账号：</span>
   	<span>${session.admin.account}${session.student.account}${session.teacher.account}</span>
   	</li>
   	<li><span>密码：</span>
   	<span>${session.admin.password }${session.student.password }${session.teacher.password }</span>
   	</li>
   	<c:if test="${empty session.admin}"> 
	   	<li><span>姓名：</span>
	   	<span>${session.student.student_name }${session.teacher.teacher_name }</span>
	   	</li>
   	</c:if>
   	<c:if test="${empty session.admin}"> 
	   	<li><span>性别：</span>
	   	<span>${session.student.sex }${session.teacher.sex }</span>
	   	</li>
   	</c:if>
   	<c:if test="${not empty session.admin}"> 
	   	<li><span>权限：</span>
	   	<span>${session.admin.power }</span>
	   	</li>
   	</c:if>
   	<c:if test="${empty session.admin}"> 
	   	<li><span>电话：</span>
	   	<span>${session.student.phone }	${session.teacher.phone }</span>
	   	</li>
   	</c:if>
   	<c:if test="${not empty session.teacher}"> 
	   	<li><span>办公室：</span>
	   	<span>${session.student.phone }${session.teacher.phone }</span>
	   	</li>
   	</c:if>
   		<c:if test="${not empty session.student}"> 
	   	<li><span>专业：</span>
	   	<span>${session.student.JClass.major.majorName }</span>
	   	</li>
	   		<li><span>已修学分：</span>
	   	<span>${session.student.student_credit }</span>
	   	</li>
   	</c:if>
   </ul>
  	<a id="index" href="/javaeeFinal">首页</a>
  	
  </body>
</html>

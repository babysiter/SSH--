<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
	int teacherID;
	if(request.getParameter("teacherID")!=null){
		teacherID=Integer.parseInt(request.getParameter("teacherID"));
		request.setAttribute("teacherID", teacherID);
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'changeTeacher.jsp' starting page</title>
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
	<h2>修改老师</h2>
   <h1>${msg }</h1>
    <form id="form" action="/javaeeFinal/changeTeacheradminAction" method="post"> 
		<s:hidden name="teacher.teacherID" value="%{#request.teacherID }"></s:hidden>
		<span>老师姓名：<input type="text" name="teacher.teacher_name" /> </span>
		<span>账	      号：<input type="text" name="teacher.account" /> </span>
		<span>密	      码:<input type="password" name="teacher.password" /></span>
		<span>教师性别：
			<input type="radio" name="teacher.sex"  value=0 />男
			<input type="radio" name="teacher.sex"  value=1 />女
		</span>
		<span>家庭住址：<input type="text" name="teacher.address" /></span>
		<span>身份证号：<input type="text" name="teacher.IDNumber" /></span>
		<span>手机号码:<input type="text" name="teacher.phone" /> </span>
		<span>办公室地址:<input type="text" name="teacher.office" /> </span>	
		<input type="submit" value="添加"/>
		</form>
		<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

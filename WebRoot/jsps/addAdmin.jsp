<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/head.css">
    <title>Title</title>
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
	<h2>添加管理员</h2>
	 <form id="form" action="javaeeFinal/addAdminadminAction" method="post"> 
		<span>管理员账号：<input type="text" name="admin.account" /></span> 
		<span>管理员密码：<input type="text" name="admin.password" /> </span>
		<span>管理员权限:<input type="password" name="admin.power" /></span>
		<input type="submit" value="添加"/>
	</form>
	<a id="index" href="/javaeeFinal">首页</a>
</body>
</html>
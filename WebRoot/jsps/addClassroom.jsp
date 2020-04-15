<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'addClassroom.jsp' starting page</title>
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
	<h2>添加教室</h2>
   <form id="form" action="javaeeFinal/addClassroomadminAction" method="post"> 
		<span>教室地址：<input type="text" name="classroom.place" /> </span>
		<span>上课时间：
			<select name="classroom.time" >
				 <option  value="周一">周一</option>
				 <option  value="周二">周二</option>
				 <option  value="周三">周三</option>
				 <option  value="周四">周四</option>
				 <option  value="周五">周五</option>
			</select>
		 </span>
		<span>最大容量: <input type="text" name="classroom.maxPeople" /></span>
		<input type="submit" value="添加"/>
	</form>
	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

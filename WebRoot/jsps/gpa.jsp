<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'gpa.jsp' starting page</title>
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
     <form id="form" action="getGpa" method="get">
     <input type="hidden" name="student.studentID" value="${student.studentID }">
  	请选择你要查询的学期：<select name="semester" >
				<option	 value="2017(1)">2017(1)</option>
				<option	 value="2017(2)">2017(2)</option>
				<option	 value="2018(1)">2018(1)</option>
				<option	 value="2018(2)">2018(2)</option>
				<option	 value="2019(1)">2019(1)</option>
				<option	 value="2019(2)">2019(2)</option>
				<option	 value="2020(1)">2020(1)</option>
				<option	 value="2020(2)">2020(2)</option>
			</select>	
			<input type="submit" value="提交">
  </form>
  <c:if test="${not empty sessionScope.gpa}">  
   <table>
  		<tr>
  			<th>学期</th>
  			<th>绩点</th>
		</tr>
  		<tr>
  			<td>${sessionScope.gpa.ss.semester}</td>
  			<td>${sessionScope.gpa.gpa}</td>
  		</tr>
  		</table>
	</c:if>
  	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

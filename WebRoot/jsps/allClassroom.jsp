<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allClassroom.jsp' starting page</title>
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
<h2>所有教室</h2>
     <table>
  		<tr>
  			<th>上课地点</th>
  			<th>上课时间</th>
  			<th>最大容量</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allClassrooms}" var="t">
  		<tr>
  			<td>${t.classroomID}</td>
  			<td>${t.place}</td>
  			<td>${t.maxPeople}</td>
  			<td>
  				<a href="${pageContext.request.contextPath}/jsps/changeClassroom.jsp?classroomID=${t.classroomID}">修改教室</a>
  				<a href="${pageContext.request.contextPath}/deleteClassroomadminAction?classroom.classroomID=${t.classroomID}">删除教室</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
   	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

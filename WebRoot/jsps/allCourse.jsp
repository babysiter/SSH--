<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allCourse.jsp' starting page</title>
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
<h2>所有课程</h2>
   <table>
  		<tr>
  			<th>课程名称</th>
  			<th>课程学分</th>
  			<th>课程学时</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allCourses}" var="t">
  		<tr>
  			<td>${t.courseName}</td>
  			<td>${t.credit}</td>
  			<td>${t.period}</td>
  			<td>
  				<a href="${pageContext.request.contextPath}/jsps/changeCourse.jsp?courseID=${t.courseID}">修改课程</a>
  				<a href="${pageContext.request.contextPath}/deleteCourseadminAction?course.courseID=${t.courseID}">删除教室</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	<a id="index" href="/javaeeFinal">首页</a>
  	</body>
</html>

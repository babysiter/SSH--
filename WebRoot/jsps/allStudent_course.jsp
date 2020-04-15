<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allStudent_course.jsp' starting page</title>
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
<h2>成绩表</h2>
<c:if test="${not empty sessionScope.allStudent_courses}"> 
   <table>
  		<tr>
  			<th>学生姓名</th>
  			<th>课程安排学期</th>
  			<th>课程名称</th>
  			<th>上课地点</th>
  			<th>上课时间</th>
  			<th>课程成绩</th>
  		</tr>
  		<c:forEach items="${sessionScope.allStudent_courses}" var="t">
  		<tr>
  			<td>${t.student.student_name}</td>
  			<td>${t.teacher_course.semester}</td>
  			<td>${t.teacher_course.course.courseName}</td>
  			<td>${t.teacher_course.classroom.place}</td>
  			<td>${t.teacher_course.classroom.time}</td>
  			<td>${t.grade}</td>
  		</tr>
  		</c:forEach>
  		<tr><td>平均成绩：</td><td>${sessionScope.asScore.studentAVG }</td></tr>
  		<tr><td>总成绩：</td><td>${sessionScope.asScore.studentSUM }</td></tr>
  	</table>
  	</c:if>
  	<c:if test="${empty sessionScope.allStudent_courses}"> 
  				<p style="text-align:center;color:red;font-size:18px">无</p>
  			</c:if>
   	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allTeacher_courses.jsp' starting page</title>
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
<h2>可选课程</h2>
      <table>
  		<tr>
  			<th>学期</th>
  			<th>教师姓名</th>
  			<th>课程名称</th>
  			<th>上课地点</th>
  			<th>上课时间</th>
  			<th>课内学生人数</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allTeacher_courses}" var="t">
  		<tr>
  			<td>${t.semester}</td>
  			<td>${t.teacher.teacher_name}</td>
  			<td>${t.course.courseName}</td>
  			<td>${t.classroom.place}</td>
  			<td>${t.classroom.time}</td>
  			<td>${t.alPeople}</td>
  			<td>
  			<c:if test="${not empty sessionScope.admin}">  
  				<a href="${pageContext.request.contextPath}/jsps/changeTeacher_course.jsp?teacher_courseID=${t.teacher_courseID}">修改课程</a>
  				<a href="${pageContext.request.contextPath}/deleteTeacher_courseadminAction?teacher_course.teacher_courseID=${t.teacher_courseID}">删除课程安排</a>
  			</c:if>
  			<c:if test="${empty sessionScope.admin}"> 
  				<p style="text-align:center;color:red;font-size:18px">无</p>
  			</c:if>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	 	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

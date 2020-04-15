<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allStudent.jsp' starting page</title>
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
<h2>所有学生</h2>
    <table>
  		<tr>
  			<th>学生工号</th>
  			<th>学生性别</th>
  			<th>学生姓名</th>
  			<th>学生班级</th>
  			<th>家庭住址</th>
  			<th>身份证号</th>
  			<th>电话号码</th>
  			<th>已修学分</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allStudents}" var="t">
  		<tr>
  			<td>${t.studentID}</td>
  			<td>${t.sex}</td>
  			<td>${t.student_name}</td>
  			<c:if test="${not empty t.JClass}">  
  				<td>${t.JClass.major.majorName}${t.JClass.grade}级${t.JClass.classNumber}班</td>
  			</c:if>
  			<c:if test="${empty t.JClass}">  
  				<td>无</td>
  			</c:if>
  			<td>${t.address}</td>
  			<td>${t.IDNumber}</td>
  			<td>${t.phone}</td>
  			<td>${t.student_credit}</td>
  			<td>
  				<a href="${pageContext.request.contextPath}/jsps/changeStudent.jsp?studentID=${t.studentID}">修改学生信息</a>
  				<a href="${pageContext.request.contextPath}/deleteStudentadminAction?student.studentID=${t.studentID}">删除学生</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	 	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

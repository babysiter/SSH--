<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'courseStudent.jsp' starting page</title>
    
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
	<h2>选择查询课程</h2>
  <form id="form" action="getAllStudentsteacherAction" method="post">
  	请选择你要查询的课程：<select name="teacher_course.teacher_courseID" >
			<s:iterator value="%{#session.allTeacher_courses}" > 
				<option	 value="<s:property value="%{teacher_courseID}"/>"><s:property value="%{course.courseName}"/>--<s:property value="%{semester}"/></option>
			</s:iterator>
			</select>	
			<input type="submit" value="提交">
  </form>
  <c:if test="${not empty sessionScope.allStudents}">
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
  			<th>成绩</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allStudents}" var="t">
  		<tr>
  			<td>${t.student.studentID}</td>
  			<td>${t.student.sex}</td>
  			<td>${t.student.student_name}</td>
  			<c:if test="${not empty t.student.JClass}">  
  				<td>${t.student.JClass.major.majorName}${t.student.JClass.grade}级${t.student.JClass.classNumber}班</td>
  			</c:if>
  			<c:if test="${empty t.student.JClass}">  
  				<td>无</td>
  			</c:if>
  			<td>${t.student.address}</td>
  			<td>${t.student.IDNumber}</td>
  			<td>${t.student.phone}</td>
  			<td>${t.student.student_credit}</td>
  			<td>${t.grade}</td>
  			<td><a href="setScore.jsp?studentID=${t.student.studentID }&teacher_courseID=${t.teacher_course.teacher_courseID}">修改成绩</a></td>
  		</tr>
  		</c:forEach>
  		<tr><td>平均成绩：</td><td>${sessionScope.class_avgScore }</td></tr>
  	</table>
  	</c:if>
  	<c:if test="${ empty sessionScope.allStudents}">
  		<p style="text-align:center;color:red;font-size:18px">无学生</p>
  	</c:if>
  	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

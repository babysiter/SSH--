<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%	
	if(request.getSession().getAttribute("admin")==null){
		request.setAttribute("msg","非管理员无法修改课程安排");
		request.getRequestDispatcher("msg.jsp").forward(request,response);
	}
	int teacher_courseID;
	if(request.getParameter("teacher_courseID")!=null){
		teacher_courseID=Integer.parseInt(request.getParameter("teacher_courseID"));
		request.setAttribute("teacher_courseID", teacher_courseID);
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'changeTeacher_course.jsp' starting page</title>
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
	<h2>修改可选课程</h2>
   <form id="form" action="javaeeFinal/changeTeacher_courseadminAction" method="post">
  	<s:hidden name="teacher_course.teacher_courseID" value="%{#request.teacher_courseID }"></s:hidden>
  	<span>教	    师：</span>
			<select name="teacher.teacherID" >
			<s:iterator value="%{#session.allTeachers}" > 
				<option	 value="<s:property value="%{teacherID}"/>"><s:property value="%{teacher_name}"/></option>
			</s:iterator>
			</select>
	<span>课	    程：</span>
			<select name="course.courseID" >
			<s:iterator value="%{#session.allCourses}" > 
				<option	 value="<s:property value="%{courseID}"/>"><s:property value="%{courseName}"/></option>
			</s:iterator>
			</select>
	<span>教室：</span>
			<select name="classroom.classroomID" >
			<s:iterator value="%{#session.allClassrooms}" > 
				<option	 value="<s:property value="%{classroomID}"/>">上课地点：<s:property value="%{place}"/> 上课时间：<s:property value="%{time}"/></option>
			</s:iterator>
			</select>
	<span>学期：</span>
			<select name="semester" >
				<option	 value="2017(1)">2017(1)</option>
				<option	 value="2017(2)">2017(2)</option>
				<option	 value="2018(1)">2018(1)</option>
				<option	 value="2018(2)">2018(2)</option>
				<option	 value="2019(1)">2019(1)</option>
				<option	 value="2019(2)">2019(2)</option>
			</select>
	<input type="submit" value="提交"> 
	</form>
	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

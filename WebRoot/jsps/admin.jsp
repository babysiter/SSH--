<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>admin</title>
  <head>
    <title>Title</title>
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/student.css">
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
<div class="banner">
        <h1>欢迎来到教学综合信息服务平台</h1>
</div>
<!--topbanner开始-->
<div class="topBanner">
    <div class="container">
        <div >
            <ul style="width:800px;">
                <li><a href="${pageContext.request.contextPath }/jsps/arrangeCourse.jsp">添加行程</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllTeacher_courses">查看所有老师行程</a></li>
                <li><a href="${pageContext.request.contextPath }/jsps/addCourse.jsp">添加课程</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllCourses">查看所有课程</a></li>
                <li><a href="${pageContext.request.contextPath }/jsps/addStudent.jsp">添加学生</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllStudents">查看所有学生</a></li>
                <li><a href="${pageContext.request.contextPath }/jsps/addTeacher.jsp">添加老师</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllTeachers">查看所有老师</a></li>
                 <li><a href="${pageContext.request.contextPath }/jsps/addAdmin.jsp">添加管理员</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllAdmins">查看所有管理员</a></li>
                <li><a href="${pageContext.request.contextPath }/jsps/addClassroom.jsp">添加教室</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllClassrooms">查看所有可用教室</a></li>
           		<li><a href="${pageContext.request.contextPath }/jsps/quit.jsp">退出</a></li> 
            </ul>
        </div>
    </div>
</div>
<!--topbanner结束-->
</body>
</html>

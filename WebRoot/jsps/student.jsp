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
            <ul style="width:1000px;">
                <li><a href="${pageContext.request.contextPath }/jsps/chooseCourse.jsp">选课/退课</a></li>
       		    <li><a href="${pageContext.request.contextPath }/getStudent_score?student.studentID=${sessionScope.student.studentID}">成绩单</a></li>
                <li><a href="${pageContext.request.contextPath }/getAllStudent_coursesstudentAction">查看课程表</a></li>
                <li><a href="${pageContext.request.contextPath }/jsps/gpa.jsp">查看绩点</a></li>
           		<li><a href="${pageContext.request.contextPath }/jsps/quit.jsp">退出</a></li> 
            </ul>
        </div>
    </div>
</div>
<!--topbanner结束-->
</body>
</html>

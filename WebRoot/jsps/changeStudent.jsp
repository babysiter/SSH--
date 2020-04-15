<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%	int studentID ;
	if(request.getParameter("studentID")!=null){
		studentID=Integer.parseInt(request.getParameter("studentID"));
		request.setAttribute("studentID", studentID);
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'changeStudent.jsp' starting page</title>
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
	<h2>修改学生</h2>
   <h1>${msg }</h1>
    <form id="form" action="javaeeFinal/changeStudentadminAction" method="post"> 
		<s:hidden name="student.studentID" value="%{#request.studentID }"></s:hidden>
		<span>学生姓名：<input type="text" name="student.student_name" /> </span>
		<span>账	      号：<input type="text" name="student.account" /> </span>
		<span>密	      码:<input type="password" name="student.password" /></span>
		<span>学生性别：
			<input type="radio" name="student.sex"  value=0 />男
			<input type="radio" name="student.sex"  value=1 />女
		</span>
		<span>家庭住址：<input type="text" name="student.address" /></span>
		<span>身份证号：<input type="text" name="student.IDNumber" /></span>
		<span>手机号码:<input type="text" name="student.phone" /> </span>
		<span>联系邮箱:<input type="text" name="student.email" /> </span>	
		<span>专	      业：</span>
			<select name="jclass.major.majorName" >
			<s:iterator value="%{#session.allMajors}" > 
				<option	 value="<s:property value="%{majorName}"/>"><s:property value="%{majorName}"/></option>
			</s:iterator>
			</select>
		<span>年	     级：</span>	
			<select name="jclass.grade" >
				 <option  value="01">01</option>
				 <option  value="02">02</option>
				 <option  value="03">03</option>
				 <option  value="04">04</option>
			</select>
		<span>班	     级：</span>	
			<select name="jclass.ClassNumber" >
				<option  value="01">01</option>
				<option  value="02">02</option>
				<option  value="03">03</option>
				<option  value="04">04</option>
			</select>
			<input type="submit" value="修改"/>
			</form>
		<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

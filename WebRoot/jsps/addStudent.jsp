<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/head.css">
    <title>Title</title>
</head>
<body>
<!--head部分开始-->
<div class="head">
    <div class="container">
        <div class="left">
            <image id="logo" src="${pageContext.request.contextPath }/images/logo.png"></image>
            <span>教学综合信息服务平台</span></div>
    </div>
</div>
<!--head部分结束-->
<h2>添加学生</h2>
      <form id="form" action="javaeeFinal/addStudentadminAction" method="post"> 
		<label>学生姓名：<input type="text"  name="student.student_name" /> </label>
		<label>账	 号：<input type="text"  name="student.account" /> </label>
		<label>密	      码:<input type="text"  name="student.password" /></label>
		<label>学生性别：
			<input type="radio"  name="student.sex"  value=0 />男
			<input type="radio"  name="student.sex"  value=1 />女
		</label>
		<label>家庭住址：<input type="text"  name="student.address" /></label>
		<label>身份证号：<input type="text"  name="student.IDNumber" /></label>
		<label>手机号码:<input type="number"  name="student.phone" /> </label>
		<label>联系邮箱:<input type="email"  name="student.email" /> </label>	
		
			<label>专	      业 
				<select name="jclass.major.majorName" >
				<s:iterator value="%{#session.allMajors}" > 
					<option	 value="<s:property value="%{majorName}"/>"><s:property value="%{majorName}"/></option>
				</s:iterator>
				</select>
			：</label>
		<label>年	     级：
			<select name="jclass.grade" >
				 <option  value="01">01</option>
				 <option  value="02">02</option>
				 <option  value="03">03</option>
				 <option  value="04">04</option>
			</select>
		</label>	
		<label>班	     级：
			<select name="jclass.ClassNumber" >
				<option  value="01">01</option>
				<option  value="02">02</option>
				<option  value="03">03</option>
				<option  value="04">04</option>
			</select>
		</label>	
		<input type="submit" value="添加"/>
	</form>
	<a id="index" href="/javaeeFinal">首页</a>
</body>
</html>
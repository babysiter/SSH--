<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'allAdmin.jsp' starting page</title>
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
<h2>所有管理员</h2>
    <table>
  		<tr>
  			<th>管理员工号</th>
  			<th>账号</th>
  			<th>密码</th>
  			<th>权限</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${sessionScope.allAdmins}" var="t">
  		<tr>
  			<td>${t.adminID}</td>
  			<td>${t.account}</td>
  			<td>${t.password}</td>
  			<td>${t.power}</td>
  			<td>
  				<a href="${pageContext.request.contextPath}/jsps/changeAdmin.jsp?adminID=${t.adminID}">修改管理员</a>
  				<a href="${pageContext.request.contextPath}/deleteAdminadminAction?admin.adminID=${t.adminID}">删除管理员</a>
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	<a id="index" href="/javaeeFinal">首页</a>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored = "false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>loginSuccess</title>
    <meta http-equiv="Refresh" content="1;url=${pageContext.request.contextPath }/jsps/change.jsp">
	<script>
	 window.onload=function(){
		 var otime=document.getElementById('time');
		 var a=1;
		 setInterval(function(){
			 a--;
			 otime.innerHTML=a;
		 },1000)
	 }
	</script>
  </head>
  <body>
    <h1>${msg }</h1>
    <h3><span id="time">1</span>秒后自动进入首页</h3>
  </body>
</html>

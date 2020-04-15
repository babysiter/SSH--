<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
 <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
    <title>Title</title>
    <script type="text/javascript">
	    window.onload=function(){
	    	var oSe = document.getElementById('userType');
	    	var oForm = document.getElementById('loginForm');
	    	var oAccount = document.getElementById('userAccount');
	    	var oPassword = document.getElementById('userPassword');
	    	oSe.onchange=function(){
	    		var userType;
	    		var index = oSe.selectedIndex;
	    		userType = oSe.options[index].value;
				oForm.action="javaeeFinal/login"+userType+"Action";	   
				oAccount.name=userType+".account";	
				oPassword.name=userType+".password";
	    	}
	    }
		</script>
 </head>
<body>
<!--head部分开始-->
<div class="head">
    <div class="container">
        <div class="left">
            <image id="logo" src="${pageContext.request.contextPath }/images/logo.png"></image>
            <span>教学综合信息服务平台</span></div>
        <div class="right">
            <button class="right">English</button>
            <button class="left">中文</button>
        </div>
    </div>
</div>
<!--head部分结束-->
<div class="main">
    <div class="container">
        <div class="left_main">
            <image src="${pageContext.request.contextPath }/images/login.jpg" ></image>
        </div>
        <div class="right_main">
            <form id="loginForm" action="${pageContext.request.contextPath}/loginadminAction" method="get">
                <h4>用户登录</h4>
                <div class="user">
                    <span>用户名</span><input type="text" id="userAccount" name="admin.account"/><br>
                </div>
               <div class="password">
                   <span>密码</span><input type="password"  id="userPassword" name="admin.password"/><br>
               </div>
              <!--  <input type="radio" id="userType"> -->
                 <div>
               		用户类型：
               		<select id="userType">
               			<option value="admin">admin</option>
               			<option value="student">student</option>
						<option value="teacher">teacher</option>
               		</select>
             	  </div>
				<input type="submit" value="登录"><br>
          	</form>
            <p>登录密码忘记可到学院办公室进行初始化,访客查询账户Zjuter,密码Zjuter</p>
        </div>
    </div>
</div>
<!--bottom开始-->
<div class="bottom">
    <div class="container">
        <a href="www.baidu.com">版权所有© Copyright 1999-2019 正方软件股份有限公司　　中国·杭州西湖区紫霞街176号 互联网创新创业园2号301</a>
    </div>
</div>
</body>
</html>
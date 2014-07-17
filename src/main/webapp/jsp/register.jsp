<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>register</title>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=path%>/js/login.js" type="text/javascript" language="javascript"></script>
    <script src="<%=path%>/lib/jquery-1.10.2.js" type="text/javascript"></script>
    <link href="<%=path%>/css/login.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
          function tijiao(){
              if($("#username").val()==""){
                  $("#errorMessage").text("");
                  $("#errorMessage").text("用户名不能为空");
//                  alert("用户名不能为空");
                  return false;
              }else if($("#passwd").val()==""){
                  $("#errorMessage").text("");
                  $("#errorMessage").text("密码不能为空");
//                  alert("密码不能为空");
                  return false;
              }
              return true;
          }
      </script>
  </head>

	<body background="<%=path%>/pictures/background.jpg" style="background-repeat:no-repeat">
		<div id="title" >
				<p><a style="font-size:36px; color:#eee;text-decoration: none">个人财务管理系统-用户注册</a></p>
				<p><a style="font-size:20px; color:#eee;text-decoration: none">Personal Financial Management System-Register</a></p>

        </div>
	    <div id="input" style="position: relative;">

	        <form class="form-inline" role="form"  method="post" action="<c:url value="/user/userAdd.action"/>" >
	          <div class="form-group">
	            <label class="sr-only" for="username">User Name</label>
	            <input type="text" class="form-control" id="username" name="user.userName" placeholder="User Name" value="${username}">
	          </div>
	          &nbsp;
	          <div class="form-group">
	            <label class="sr-only" for="passwd">Password</label>
	            <input type="password" class="form-control" id="passwd" name="user.userPasswd" placeholder="Password">
	          </div>
	          &nbsp;&nbsp;&nbsp;
	          <button type="submit" onclick="return tijiao()" class="btn btn-primary">提交</button>
	        </form>
            <span id="errorMessage" style="color:orangered;font-size:15px;position:absolute;bottom:-30px">${errorMessage}</span>
	    </div>
	    <div id="fenge">
		    <p><a style="color:#eee;text-decoration: none">————————————————————————————————————</a></p>
		</div>
		<div id="register">
		    <p><a style="text-decoration: none" href="<%=path%>/jsp/login.jsp">已经有账号？点击这里登陆。</a></p>
		</div>
	    <div id="copyright">
		<a style="color:black;text-decoration: none">Copyright ©2013, All Rights Reserved</a>
		</div>
	</body>
</html>

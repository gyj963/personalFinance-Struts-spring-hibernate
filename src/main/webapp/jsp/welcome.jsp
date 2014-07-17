<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=path%>/pictures/background.jpg">
	<%--<script src="<%=path%>/js/mainView.js" type="text/javascript" language="javascript"></script>--%>
	<%--<script src="<%=path%>/js/bootstrap.min.js"></script>--%>
	<link href="<%=path%>/css/welcome.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <title>welcome</title>
  </head>
  <body>

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
              <ul class="nav navbar-nav">
                <li class="active"><a>Personal Financial Management System</a></li>
              </ul>
        </div>

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
          <img alt="First slide" src="<%=path%>/pictures/top.jpg">
            <div id="carousel-caption" class="carousel-caption">
              <h1>欢迎使用个人财务管理系统</h1>
              <p>welcome to use Personal Financial Management System</p>
              <p><a class="btn btn-lg btn-primary" href="<%=path%>/jsp/login.jsp" role="button">Logout</a></p>
            </div>
    </div>

    <div id="marketing" class="container marketing">
      <div class="row">
          <div class="col-lg-1">
        </div><!-- 布局  -->
        
        <div class="col-lg-4">
          <img src="<%=path%>/pictures/chakan.jpg">
          <h2>View List</h2>
          <p>查看或管理我的账单</p>
          <p>To view my bill list or delete my bill.</p>
          <p><a class="btn btn-primary" href="<c:url value="/bill/billList.action"/>" role="button">GO ></a></p>
        </div><!-- 1  -->
   
        <div class="col-lg-4">
          <img src="<%=path%>/pictures/tianjia.jpg">
          <h2>New Bill</h2>
          <p>新建账单，记录我的资金动向。</p>
          <p>Add a bill, record my Capital movements.</p>
          <p><a class="btn btn-primary" href="<%=path%>/jsp/add.jsp" role="button">GO ></a></p>
		</div>
		
        <div class="col-lg-3">
          <img src="<%=path%>/pictures/tongji.jpg">
          <h2>Statistics </h2>
          <p>历史数据统计，我的钱去哪儿了？</p>
          <p>Check the history. where is my money?</p>
          <p><a class="btn btn-primary" href="<%=path%>/jsp/statistic.jsp" role="button">GO ></a></p>
        </div><!-- 3 -->
      </div>

 <%--     <footer>
        <p class="pull-right"><a style="color: #000000">Copyright &copy; 2013</a></p>
      </footer>--%>
      
    </div>
    
  </body>
</html>


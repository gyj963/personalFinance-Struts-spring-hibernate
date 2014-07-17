<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>statistic</title>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="<%=path%>/lib/jquery-1.10.2.js" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value="/lib/jquery.jqplot.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/lib/jqplot.pieRenderer.min.js"/>"></script>
    <script type="text/javascript" src="<%=path%>/js/billstatis.js"></script>
    <script type="text/javascript" src="<c:url value="/lib/jqplot.canvasAxisLabelRenderer.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/lib/jqplot.canvasTextRenderer.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/lib/jqplot.dateAxisRenderer.js"/>"></script>
    <link href="<%=path%>/css/statistic.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/css/jquery.jqplot.css"/>"/>

  </head>
  
  <body background="<%=path%>/pictures/background.jpg">
  	<form role="form" method="post" action="<%=path%>/jsp/welcome.jsp">
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
              <ul class="nav navbar-nav">
                <li><input type="image" src="<%=path%>/pictures/main.jpg" onClick="document.formName.submit()"></li>
                <li class="active"><a>Personal Financial Management System</a></li>
              </ul>
        </div>
    </form>
    <div style="position: absolute;top:120px;">
        <div id="data" class="col-lg-10" style="position: relative">
            <ul class="nav nav-tabs nav-justified" id="statisNav">
                <li class="active" way="statisDetailStyle"><a style="color:black" href="#">按收支</a></li>
                <li way="statisDetailCreateTime"><a style="color:black" href="#">按时间</a></li>
                <li way="statisDetailMemo"><a style="color:black" href="#">按用途</a></li>
            </ul>
            <div name="statisDetailStyle" id="statisDetailStyle" way="statisDetailStyle" class="panel" style="position:absolute;/*height: 65%;*/padding: 70px 20px 20px 20px;z-index: 2;width: 97.3%">
                <table>
                    </tr>
                    <tr>
                        <td style="width: 65%;">
                            <table class="table table-condensed table table-striped statisDetailStyle">
                                <tr>
                                    <th>序号</th>
                                    <th><span class="statisType">收支类型</span></th>
                                    <th>所占数量</th>
                                </tr>
                            </table>
                        </td>
                        <td style="width: 35%">
                            <div id="chart1" style="width: 600px;height: 360px;">
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <div name="statisDetailCreateTime" id="statisDetailCreateTime" way="statisDetailCreateTime" class="panel" style="position:absolute;/*height: 300%;*/padding: 70px 20px 20px 20px;z-index: 1;width: 97.3%">
                <table>
                    <tr>
                        <td style="width: 65%;height: 120%;padding: 0px 15%;">
                            <div id="chart2" style="width: 700px;height: 360px;" class="jqplot-target">
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <div name="statisDetailMemo" id="statisDetailMemo" way="statisDetailMemo" class="panel" style="position:absolute;/*height: 65%;*/padding: 70px 20px 20px 20px;z-index: 1;width: 97.3%">
                <table>
                    <tr>
                        <td style="width: 35%;padding: 0px 15%;">
                            <div id="chart3" style="width: 700px;height: 360px;">
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="copyright">
        <a style="color:black;text-decoration: none">Copyright ©2013, All Rights Reserved</a>
    </div>
  </body>
</html>

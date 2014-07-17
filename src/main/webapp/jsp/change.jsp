<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>change</title>
    
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 	<script src="<%=path%>/js/login.js" type="text/javascript" language="javascript"></script> -->
    <script src="<%=path%>/lib/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="<%=path%>/lib/jquery-ui-1.10.3.Datepicker.js" type="text/javascript"></script>
	<link href="<%=path%>/css/add.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/jquery-ui-1.10.3.Datepicker.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
          $(function(){
              $( "#DT_DATE" ).datepicker({ dateFormat: "yy-mm-dd" });
          });
      </script>
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
   
   	<div id="newbill" class="col-lg-8">
		 <form role="form" method="post" action="<c:url value="/bill/billUpdate.action"/>">
             <input type="hidden" value="${bill.billId}" name="billId"/>
		    <table width="100%" cellspacing="15" cellpadding="0" class="table">
		      <tr>
		        <th scope="row" width="20%">账务类型</th>
		        <td width="*">
                        <div class="select">
                            <select class="form-control" id="kind" name="billStyle">
                                <option value="收入" <c:if test="${bill.billStyle=='收入'}">selected="selected"</c:if> >收入</option>
                                <option value="支出" <c:if test="${bill.billStyle=='支出'}">selected="selected"</c:if>>支出</option>
                            </select>
                        </div>
		        </td>
		      </tr>
		      <tr>
		        <th scope="row">账务金额</th>
		        <td>
			        <div class="input-group">
					  <span class="input-group-addon">￥</span>
                        <input name="billMoney" value="${bill.billMoney}" type="text" class="form-control" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" placeholder="100.00">
					</div>
		        </td>
		      </tr>
		      <tr>
		        <th scope="row">收支日期</th>
				<td align="left">
				        <div>
                            <input name="billCraetedTime" value="${bill.billCraetedTime}" type="text" class="form-control form_field required" id="DT_DATE" placeholder="yyyy-mm-dd">
		                </div>
				</td>
		      </tr>
		      <tr>
		        <th scope="row">资金动向</th>
		        <td>
		        <div>
                    <input type="text" name="billMemo" value="${bill.billMemo}" class="form-control" placeholder="交电费">
				</div>
		        </td>
		      </tr>
		      <tr>
		       <td colspan="2" align="center" scope="row">
		       <br>
		       		<div class=" form-inline">
                         <button type="submit" class="btn btn-primary " style="width: 30% ;margin-right: 10%">&nbsp;&nbsp;&nbsp;确认修改&nbsp;&nbsp;&nbsp;</button>
                         <button type="button" onclick="history.go(-1)" class="btn btn-primary" style="width: 30%">返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回</button>
                    </div>
		       </td>
		      </tr>
		    </table>	   
		</form>
	 </div>
  </body>
</html>
	


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>list</title>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
      <!--
      <link rel="stylesheet" type="text/css" href="styles.css">
      -->
      <link href="<%=path%>/css/list.css" rel="stylesheet" type="text/css" />
      <link href="<%=path%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
      <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
      <link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
      <link href="<%=path%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
      <link href="<%=path%>/css/jquery-ui-1.10.3.Datepicker.css" rel="stylesheet" type="text/css" />
      <link href="<%=path%>/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
      <script src="<%=path%>/lib/jquery-1.10.2.js" type="text/javascript"></script>
      <script src="<%=path%>/lib/jquery.dataTables.js" type="text/javascript"></script>
      <script src="<%=path%>/lib/bootstrap.min.js" type="text/javascript"></script>
      <script src="<%=path%>/lib/plugins.js" type="text/javascript"></script>
      <script src="<%=path%>/lib/dataTable.bootstrap.js" type="text/javascript"></script>
      <script src="<%=path%>/lib/jquery-ui-1.10.3.Datepicker.js" type="text/javascript"></script>
      <script type="text/javascript">
      $(function(){
              $( "#minDate" ).datepicker({ dateFormat: "yy-mm-dd" });
              $( "#maxDate" ).datepicker({ dateFormat: "yy-mm-dd" });
              $(".dataTable").dataTable();
          });
          function delBill(){
              if(confirm("确认删除吗？")){
                  return true;
              }else{
                  return false;
              }
          }
      </script>
  </head>
  
  <body background="<%=path%>/pictures/background.jpg">
 	 	<form role="form" method="post" action="<%=path%>/jsp/welcome.jsp">
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
              <ul class="nav navbar-nav">
                <li><input type="image" src="<%=path%>/pictures/main.jpg" onClick="document.formName.submit()"></li>
                <li class="active"><a style="text-decoration: none">Personal Financial Management System</a></li>
              </ul>
        </div>
        </form>
    <form class="form-inline" role="form" method="post" action="<c:url value="/bill/billFilter.action"/>">
    <div id="buttons">
		  <div class="form-group">
			    <label class="sr-only" for="minDate">起始日期</label>
			    <input type="text" class="form-control input-sm" id="minDate" name="minDate" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" placeholder="起始日期">
		  </div>
		  <div class="form-group">
			    <label class="sr-only" for="maxDate">最终日期</label>
			    <input type="text" class="form-control input-sm" id="maxDate" name="maxDate" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" placeholder="最终日期">
		  </div>
		  <button type="submit" class="btn btn-default btn-sm">筛选</button>
	</div>
	</form>
    <div  id="tableDiv" class="panel" style="height:500px">
	  <div class="panel-heading"><strong>我的账单列表</strong><c:if test="${minDate!=null&&maxDate!=null}"><span>&nbsp;&nbsp;(${minDate}至${maxDate})</span></c:if></div>
	  <div class="panel-body" >
       <form  name="frm" method="post">
           <c:if test="${billList!=null&&billList.size()>0}">
		<table width="100%" class="table table-condensed table-striped dataTable table-bordered  table-hover">
                <thead>
                <tr style="background: #d7e6ea">
                    <th scope="col" width="10%" >序号</th>
                    <th scope="col" width="15%">账务类型</th>
                    <th scope="col" width="15%">资金数额</th>
                    <th scope="col" width="15%">日期</th>
                    <th scope="col" width="20%">备注</th>
                    <th scope="col" width="10%">删除</th>
                    <th scope="col" width="10%">修改</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${billList}" var="li" varStatus="status">
                    <tr>
                        <td>${status.index+1}</td>
                        <td>${li.billStyle}</td>
                        <td>${li.billMoney}</td>
                        <td>${li.billCraetedTime}</td>
                        <td>${li.billMemo}</td>
                        <td><a id="del"  class="btn btn-default btn-xs " role="button" href="<c:url value="/bill/billDel.action?billId=${li.billId}"/>" onclick="return delBill()">删&nbsp;&nbsp;除</a></td>
                        <td><a class="btn btn-default btn-xs " role="button" href="<c:url value="/bill/billUpdateShow.action?billId=${li.billId}"/>">修&nbsp;&nbsp;改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
		</table>
           </c:if>
           <c:if test="${billList==null||billList.size()==0}">
               <div style="position: relative;top:100px;text-align: center">
                    <p><a style="font-size:50px;text-decoration: none;text-shadow: 0 3px 3px #FFF;color: #707781; font-size: 32pt; font-weight: bold; line-height: 25px; margin-bottom: 0;">你目前还没有账单信息哦&nbsp;&nbsp;&nbsp;O__O"…</a></p>
                    <p><a style="font-size:25px;text-shadow: 0 3px 3px #FFF;color: #64818E; font-size: 15pt; font-weight: normal;" href="<%=path%>/jsp/add.jsp">现在去添加</a></p>
               </div>
           </c:if>
      </form>
	</div>
	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>new</title>
    
    
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
    <script src="<%=path%>/lib/jquery.validate.min.js" type="text/javascript"></script>
	<link href="<%=path%>/css/add.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/jquery-ui-1.10.3.Datepicker.css" rel="stylesheet" type="text/css" />

      <script type="text/javascript">
          $(function(){
              $( "#DT_DATE" ).datepicker({ dateFormat: "yy-mm-dd" });
              $('.validate').validate({

                  rules: {
                      billMoney: {
                          required: true
                      },
                      billCraetedTime:{
                          required: true
                      },
                      billMemo:{
                          required: true
                      }
                  }, //end rules
                  messages: {
                      billMoney: {
                          required: "我收入/支出了多少钱？"
                      },
                      billCraetedTime:{
                          required: "我收入/支出的日期？"
                      },
                      billMemo:{
                          required: "我收入/支出的资金动向？"
                      }
                  },
                  errorPlacement: function(error, element) {
                      if ( element.is(":radio") || element.is(":checkbox")) {
                          error.appendTo( element.parent());
                      } else {
                          error.appendTo( element.parent().parent());
//				                      error.insertAfter(element);
                      }
                  }

              }); // end validate
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
		 <form role="form" class="validate" method="post" action="<c:url value="/bill/billAdd.action"/>">
		
		    <table width="100%" cellspacing="15" cellpadding="0" class="table">
		      <tr>
		        <th scope="row" width="20%">账务类型</th>
		        <td width="*">
                        <div class="select">
                            <select class="form-control" id="kind" name="billStyle">
                                <option value="收入">收入</option>
                                <option value="支出">支出</option>
                            </select>
                        </div>
		        </td>
		      </tr>
		      <tr>
		        <th scope="row">账务金额</th>
		        <td>
			        <div class="input-group">
					  <span class="input-group-addon">￥</span>
					  <input name="billMoney" type="text" class="form-control" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" placeholder="100.00">
					</div>
		        </td>
		      </tr>
		      <tr>
		        <th scope="row">收支日期</th>
				<td align="left">
				        <div>
		                    <input name="billCraetedTime" type="text" class="form-control form_field required" id="DT_DATE" placeholder="yyyy-mm-dd">
		                </div>
				</td>
		      </tr>
		      <tr>
		        <th scope="row">资金动向</th>
		        <td>
		        <div>
				  <input type="text" name="billMemo" class="form-control" placeholder="交电费">
				</div>
		        </td>
		      </tr>
		      <tr><td colspan="2"><a style="color:#fff;font-size:12px;text-decoration: none"><br>提交前请仔细核查信息。<br>Check up your information carefully before you commit.</a><p></p></td></tr>
		      <tr>
		       <td colspan="2" align="center" scope="row">
		       <br>
		       		<div class=" form-inline">
                         <button type="submit" class="btn btn-primary " style="width: 30% ;margin-right: 10%">提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                         <button type="reset" class="btn btn-primary" style="width: 30%">重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置</button>
                    </div>
		       </td>
		      </tr>
		    </table>	   
		</form>
	 </div>
  </body>
</html>
	


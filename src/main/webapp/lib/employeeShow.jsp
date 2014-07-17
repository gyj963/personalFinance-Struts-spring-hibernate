<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>员工信息管理</title>
    <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/page.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/chosen.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/empQueryAndStatis/css/jquery.dataTables.css"/>"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!--<script type="text/javascript" src="../js/jquery.min.js"></script>-->

    <script type="text/javascript" src="<c:url value="/js/jquery-1.10.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/empQueryAndStatis/js/jquery.dataTables.js"/>"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/chosen.proto.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/chosen.jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/additional-methods.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/empQueryAndStatis/js/plugins.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/empQueryAndStatis/js/dataTable.bootstrap.js"/>"></script>
    <script type="text/javascript">
        $(function(){
            $(".dataTable").dataTable({    "sDom": "<'row-fluid'<'span6'l><'span6'r>t<'row-fluid'<'span6'i><'span6'p>>"
             });
        });
//        查看详细信息
          function empDetail(){
              var count=0;
              $(".select").each(function(){
                  if($(this).get(0).checked==true){
                      count+=1;
                  }
              });
              if(count>0){
                  if(count!=1){
                      alert("一次只能查看一个员工的详细信息");
                      return;
                  }else{
                      frm.action = "<c:url value="/employee/showDetail"/>";
                      frm.submit();
                      return;
                  }
              }else{
                  alert("请选择要查看的员工的记录！");
                  return;
              }
          }
//        删除员工信息
          function delEmp(){
              var count=0;
              $(".select").each(function(){
                 if($(this).get(0).checked==true){
                     count+=1;
                 }
              });
              if(count>0){
                  if(confirm("将删除"+count+"条记录。确认删除吗？")){
                      frm.action = "<c:url value="/employee/delete"/>";
                      frm.submit();
                      return;
                  }else{
                     return;
                  }
              }else{
                  alert("请选择删除的记录！");
                  return;
              }
          }
    </script>
</head>

<body>
<form name="frm" method="post" >
<div class="cusContent">
    <div class="panel panel-default">
        <div class="panel-heading">员工信息列表</div>

        <table class="table table-bordered  table-striped table-hover dataTable">
            <thead>
            <tr>
                <th style="width: 3%"><span class="glyphicon glyphicon-search"></span></th>
                <th style="width: 8%">序号</th>
                <th style="width: 12%">姓名</th>
                <th style="width: 13%">编号</th>
                <th style="width: 8%">性别</th>
                <th style="width: 15%">所在部门</th>
                <th style="width: 15%">员工职称</th>
                <th style="width: 15%">任职岗位</th>
                <th style="width: 15%">工作状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeeList}" var="li" varStatus="status" >
                <tr>
                    <td><input type="checkbox" name="select"  value="${li.NEmpId}" id="select" class="select"/></td>
                    <%--<td><input type="checkbox" name="select"  value="${li.NEmpId}" id="select"/></td>--%>
                    <td>${status.index+1}</td>
                    <td>${li.vcEmpName}</td>
                    <td>${li.vcEmpCode}</td>
                    <td><c:if test="${li.NGender==0}">男</c:if>
                        <c:if test="${li.NGender==1}">女</c:if>
                    </td>
                    <td>${li.TDept.vcDeptName}</td>
                    <td>${li.TTitle.vcTitleName}</td>
                    <td>${li.TPost.vcPostName}</td>
                    <td>
                        <c:forEach items="${NStatusSet}" var="item">
                            <c:if test="${li.NStatus==item.key}">${item.value}</c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div style="position: relative;bottom:-20px;left: 0px" >
        <%--<ul class="pagination" style="margin-left: 30%;margin-bottom: 0%">--%>
        <%--&lt;%&ndash;<li><a href="#">&laquo;</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">1</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">2</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">3</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">4</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">5</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li><a href="#">&raquo;</a></li>&ndash;%&gt;--%>
        <a class="btn btn-default"  role="button" onclick='empDetail()'>查看详细信息</a>
        <a class="btn btn-default"  role="button" onclick='delEmp()'>删除员工信息</a>
        <%--</ul>--%>
    </div>
</div>

</form>
</body>
</html>
<%@ page language="java" pageEncoding="utf-8"%>
<!-- 在使用struts2提供的标签库之前，需要在JSP中引入这个标签库，前缀定义为“s”  -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>问候程序</title>
	</head>
	<body>
	<!-- property标签来显示message这个属性值 -->
		<%--<s:property value="message" />--%>
		<%--<s:form action="hello">--%>
			<%--<s:textfield name="message" label="问候语" value="" />--%>
			<%--<br>--%>
			<%--<s:submit value="提交" />--%>
		<%--</s:form>--%>
    <form method="post" action="<c:url value="/hello.action"/>">
        <input name="message" value="${message}" type=""/>
        <button type="submit">提交</button>
    </form>
	</body>
</html>

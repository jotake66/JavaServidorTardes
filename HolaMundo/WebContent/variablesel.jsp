<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/variablesel.jsp">Con pageContext</a>
${pageContext.request.contextPath} <br/>
${pageContext.request.requestURI}

<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/" var="raiz" />

<a href="${raiz}variablesel.jsp">URL</a>

<c:url value="/variablesel.jsp" var="variablesel" />
<a href="${variablesel}">Con c:url</a>
--%>


</body>
</html>
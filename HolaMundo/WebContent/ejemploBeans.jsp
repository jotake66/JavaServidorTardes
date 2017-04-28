<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo JavaBeans</title>
</head>
<body>

<jsp:useBean id="usuario" scope="page" class="com.ipartek.ejemplos.javierlete.tipos.Usuario"></jsp:useBean>

<h1>El usuario es ${usuario.nombre} y la password es ${usuario.pass}</h1>

<h3>El usuario es <jsp:getProperty property="nombre" name="usuario"/> y la password es
<jsp:getProperty property="pass" name="usuario"/></h3>

<h6>El usuario es <%= usuario.getNombre() %> y la password es <%= usuario.getPass() %></h6>

</body>
</html>
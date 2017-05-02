<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Principal</title>
</head>
<body>
	<h1>Principal</h1>
	<jsp:useBean id="usuario" scope="session" 
		class="com.ipartek.ejemplos.javierlete.tipos.Usuario" />
	<h2>Bienvenido ${usuario.nombre}</h2>
</body>
</html>
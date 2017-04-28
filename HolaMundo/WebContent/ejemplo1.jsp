<%@ page import="java.util.Date" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo1</title>
<style>
h1, h2, h3, h4, h5, h6 {
	font-family: sans-serif;
	background-color: lightgray;
}
</style>

<script>
/*
function refresco() {
	location.reload();
}
setTimeout(refresco, 5000);
*/
alert('<%= new Date() %>');
</script>
</head>
<body>
	<form action="#">
		<input type="text" name="texto" />
	</form>
	
	<h1><%= new Date() %></h1>
	
	<% for(int i = 1; i <= 6; i++) { %>
		<h<%=i %>>Prueba <%=i %></h<%=i %>>
	<% } %>
</body>
</html>
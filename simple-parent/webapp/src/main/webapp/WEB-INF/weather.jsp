<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="weather" scope="request"
		class="org.sonatype.mavenbook.weather.Weather"></jsp:useBean>

	<hr />

	<table>
		<tbody>
			<tr>
				<th>Lugar</th>
				<td><jsp:getProperty name="weather" property="city" />, <jsp:getProperty
						name="weather" property="region" />, <jsp:getProperty name="weather"
						property="country" /></td>
			</tr>
			<tr>
				<th>Temperatura</th>
				<td><jsp:getProperty name="weather" property="tempFormateado" /></td>
			</tr>
			<tr>
				<th>"Condición"</th>
				<td><jsp:getProperty name="weather" property="condition" /></td>
			</tr>
			<tr>
				<th>Humedad</th>
				<td><jsp:getProperty name="weather" property="humidity" /></td>
			</tr>
			<tr>
				<th>Viento</th>
				<td><jsp:getProperty name="weather" property="chill" /></td>
			</tr>
		</tbody>
	</table>
	<hr />

</body>
</html>
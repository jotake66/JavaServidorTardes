<%@ include file="includes/cabecera.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<h2>Formulario de usuarios</h2>
	
	<jsp:useBean id="usuario" scope="request"
		class="com.ipartek.ejemplos.javierlete.tipos.Usuario" />

	<form action="usuarioform" method="post">
		<fieldset>
			<label for="nombre">Nombre</label> 
			
			<input id="nombre" name="nombre"
			  required="required" minlength="4" value="${usuario.nombre}" 
			  
			  <c:if test="${param.op == 'modificar'}">
			  	disabled="disabled"
			  </c:if>   
		  	/>
		</fieldset>
		<fieldset>
			<label for="pass">Contraseña</label> <input type="password" id="pass"
				name="pass" />
		</fieldset>
		<fieldset>
			<label for="pass2">Contraseña otra vez</label> <input type="password" id="pass2"
				name="pass2" />
		</fieldset>
		<fieldset>
			<input type="submit" value="${fn:toUpperCase(param.op)}" />
			<p class="errores">${usuario.errores}</p>
			
			<input type="hidden" name="op" value="${param.op}" />
		</fieldset>
	</form>
	
<%@ include file="includes/pie.jsp" %>
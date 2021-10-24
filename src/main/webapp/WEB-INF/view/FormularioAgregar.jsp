<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleados</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

<div class="container">
<br>
<h1 class="display-4 text-center">Información Empleado</h1>
<br>
<form:form action="insertarEmpleado" modelAttribute="empleado" method="POST" class="row g-3">

	<form:hidden path="id"/>
		
		<div class="col-md-6">
			<label class="form-label">Nombre: </label>
			<form:input class="form-control" path="nombre"/>
		</div>
		
		<div class="col-md-6">
			<label class="form-label">Apellido: </label>
			<form:input class="form-control" path="apellido"/>
		</div>
		<div class="col-md-8">
			<label class="form-label">Email: </label>
			<form:input class="form-control" path="email"/>
		</div>
		<div class="col-md-4">
			<label class="form-label">Telefono: </label>
			<form:input class="form-control" path="telefono"/>
		</div>
		<div class="col-md-9">
			<label class="form-label">Direccion: </label>
			<form:input class="form-control" path="direccion"/>
		</div>
		<div class="col-md-3">
			<label class="form-label">Genero: </label>
			<form:input class="form-control" path="genero"/>
		</div>
		
		<div class="col-auto">
		<input class="btn btn-primary" type="submit" value="Insertar">
		</div>
</form:form>
</div>

</body>
</html>
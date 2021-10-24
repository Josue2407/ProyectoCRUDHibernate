<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
<h1 class="display-4 text-center">Gestión de Empleados</h1>
<br>
<br>
<input class="btn btn-success" type="button" value="Agregar Cliente" onClick="window.location.href='Agregar'; return false;">
<br>
<table class="table table-hover">
<thead>
<tr>
	<th scope="col">Nombre</th>
	<th scope="col">Apellido</th>
	<th scope="col">Email</th>
	<th scope="col">Telefono</th>
	<th scope="col">Direccion</th>
	<th scope="col">Genero</th>
	<th colspan="2" scope="col">Acciones</th>
</tr>
</thead>
<tbody>
<c:forEach var = "empleado" items = "${empleados }">

<c:url var = "linkActualizar" value="/empleado/Actualizar">

	<c:param name="empleadoId" value="${empleado.id}"/>

</c:url>

<c:url var = "linkEliminar" value="/empleado/Eliminar">

	<c:param name="empleadoId" value="${empleado.id}"/>

</c:url>

<tr>
	<td>${empleado.nombre}</td>
	<td>${empleado.apellido}</td>
	<td>${empleado.email}</td>
	<td>${empleado.telefono}</td>
	<td>${empleado.direccion}</td>
	<td>${empleado.genero}</td>
	<td><a href="${linkActualizar}"><input class="btn btn-warning" type="button" value="Modificar"/></a></td>
	<td><a href="${linkEliminar}"><input class="btn btn-danger" type="button" value="Eliminar" 
	onclick="if(!(confirm('Seguro que desea eliminar el registro?'))) return false"/></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>
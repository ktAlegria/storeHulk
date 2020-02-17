<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>
<link rel="stylesheet" href="./style.css" media="all" />
</head>
<body>
	<h1>Lista de Productos</h1>

	<table id="customers">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Precio Venta</th>
			<th>Stock</th>
		</tr>
		<c:forEach var="producto" items="${listProductos}">
		<tr>
			<td><c:out value="${producto.id}"></c:out></td>
			<td><c:out value="${producto.nombre}"/></td>
			<td><c:out value="${producto.descripcion}"/></td>
			<td><c:out value="${producto.precioVenta}"/></td>
			<td><c:out value="${producto.stock}"/></td>
			<td><a href="Producto?opcion=vender&id=${producto.id}&nom=${producto.nombre}&precio=${producto.precioVenta}&stock=${producto.stock}">Vender</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
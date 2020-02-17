<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vender Productos</title>
<link rel="stylesheet" href="./style.css" media="all" />
</head>
<body>
	<h1>Lista de productos en tienda</h1>

	<script>
		function validar(vende, stock) {
			if (stock<vende) { //si el dato supera el stock
				alert('El valor excede el stock existente');
		}
	</script>
	<form action="Stock" method="post">
		<c:set var="producto" value="${productoV}"></c:set>
		<input type="hidden" name="proceso" value="venta"/> 
		<input type="hidden" name="id" value="${producto.id}"/>
		<table>
			<tr>
				<td>Nombre del Producto:</td>
				<td><input type="text" name="nomProd" size="60"
					value="${producto.nombre}"></td>
			</tr>
			<tr>
				<td>Valor del Producto:</td>
				<td><input type="number"  size="60"
					value="${producto.precioVenta}"></td>
			</tr>
			<tr>
				<td>Stock:</td>
				<td><input type="number"  name="stock" size="60"
					value="${producto.stock}"></td>
			</tr>
			<tr>
				<td>venta:</td>
				<td><input type="number"  name="vende" size="60"
					${producto.vende} onchange="validar(vende,stock)"></td>
			</tr>
		</table>
		<input type="submit" value="Venta">
	</form>
</body>
</html>
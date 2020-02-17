<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Productos</title>
</head>
<body>
	<h1>Ingresar nuevo Productos</h1>
	<form action="Producto" method="post">
	<input type="hidden" name="proceso" value="insertar">
		<table>
			<tr>
				<td>Nombre del Producto:</td>
				<td><input type="text" name="nomProd" size="60"></td>
			</tr>
			<tr>
				<td>Descripcion del Producto:</td>
				<td><input type="text" name="desProd" size="60"></td>
			</tr>
			<tr>
				<td>Valor del Producto:</td>
				<td><input type="number" pattern= "[0-9]" name="valProd" size="60"></td>
			</tr>
			<tr>
				<td>Stock:</td>
				<td><input type="number" pattern= "[0-9]" name="Stock" size="60"></td>
			</tr>
		</table>
		<input type="submit" value="Insertar"> 
	</form>
</body>
</html>
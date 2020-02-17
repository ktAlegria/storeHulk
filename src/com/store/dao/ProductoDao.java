package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.conexion.Conexion;
import com.store.model.Producto;

public class ProductoDao {

	private Connection connection;
	private PreparedStatement statement; // para parametrizar la sentencia

	public int crear(Producto p) throws SQLException {
		int retorno = 0;
	ResultSet result = null;
		connection = getConexion();
		try {
			connection.setAutoCommit(false);
			String sql = "INSERT INTO productos (nombre, descripcion, precio_venta) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, p.getNombre());
			statement.setString(2, p.getDescripcion());
			statement.setDouble(3, p.getPrecioVenta());
			int state = statement.executeUpdate();
			connection.commit();
			if (state > 0) {
				String sqlS = "SELECT MAX(id) FROM productos";
				statement = connection.prepareStatement(sqlS);
				result = statement.executeQuery(sqlS);
				while (result.next()) {
					retorno= result.getInt(1);
				}
			}			
			connection.close();
			statement.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean editar(Producto p) {
		return true;
	}

	public boolean borrar(Producto p) {
		return true;
	}
	
	
			
	// listamos los productos en la tabla
	public List<Producto> listar() {
		ResultSet result = null;
		List<Producto> lP = new ArrayList<Producto>();
		try {
			connection = getConexion();
			String sql = "SELECT p.id,p.nombre, p.descripcion, p.precio_venta,s.stock FROM productos p LEFT JOIN stocks s ON(s.id_producto = p.id)";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery(sql);
			while (result.next()) {
				Producto p = new Producto();
				p.setId(result.getInt(1));
				p.setNombre(result.getString(2));
				p.setDescripcion(result.getString(3));
				p.setPrecioVenta(result.getDouble(4));
				p.setStock(result.getDouble(5));
				lP.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lP;
	}

	// se busca un producto en particular
	public Producto buscar(Producto p) {
		return null;
	}

	// obtenemos el pool de conexion
	private Connection getConexion() throws SQLException {
		return Conexion.getConnection();
	}
}

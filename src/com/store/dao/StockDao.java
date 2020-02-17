  package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.store.conexion.Conexion;
import com.store.model.Stock;

public class StockDao {

	private Connection connection;
	private PreparedStatement statement; // para parametrizar la sentencia

	public boolean crear(Stock s) throws SQLException {
		boolean retorno = false;
		try {
			connection = this.getConexion();
			connection.setAutoCommit(false);
			String sql = "INSERT INTO stocks (id_producto, stock) VALUES (?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, s.getIdProducto());
			statement.setDouble(2, s.getStock());

			int state = statement.executeUpdate();
			if (state > 0)
				retorno = true;
			connection.commit();
			connection.close();
			statement.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean editar(Stock s) throws SQLException {
		boolean retorno = false;
		try {
			connection = this.getConexion();
			connection.setAutoCommit(false);
			String sql = "UPDATE stocks SET stock=? WHERE id_producto =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(2, s.getIdProducto());
			statement.setDouble(1, s.getStock());

			int state = statement.executeUpdate();
			if (state > 0)
				retorno = true;
			connection.commit();
			connection.close();
			statement.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean borrar(Stock s) {
		return true;
	}

	// listamos los Stock en la tabla
	public List<Stock> listar() {
		return null;
	}

	// se busca un Stock en particular
	public Stock buscar(Stock s) {
		return null;
	}

	// obtenemos el pool de conexion
	private Connection getConexion() throws SQLException {
		return Conexion.getConnection();
	}

}

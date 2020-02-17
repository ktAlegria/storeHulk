package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.store.conexion.Conexion;
import com.store.model.Usuario;

public class UsuarioDao {
	private Connection connection;
	private PreparedStatement statement; // para parametrizar la sentencia

	public boolean crear(Usuario u) throws SQLException {
		boolean retorno = false;
		try {
			connection = this.getConexion();
			connection.setAutoCommit(false);
			String sql = "INSERT INTO usuarios (nombre, perfil) VALUES (?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, u.getNombre());
			statement.setString(2, u.getPerfil());
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

	public boolean editar(Usuario u) {
		return true;
	}

	public boolean borrar(Usuario u) {
		return true;
	}

	// listamos los usuarios en la tabla
	public List<Usuario> listar() {
		return null;
	}

	// se busca un usuario en particular
	public Usuario buscar(Usuario u) {
		return null;
	}

	// obtenemos el pool de conexion
	private Connection getConexion() throws SQLException {
		return Conexion.getConnection();
	}
}

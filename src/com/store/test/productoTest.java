package com.store.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.store.dao.ProductoDao;
import com.store.model.Producto;

public class productoTest {
	
	private Producto p1;

	@Before
	public void iniciar() {
		p1 = new Producto("ProductoP", "Producto de prueba TEst", 20);
	}

	@Test
	public void testCrear() throws SQLException {
		ProductoDao pDao = new ProductoDao();
		int rta = pDao.crear(p1);
		assert (rta > 0);
	}

	@Test
	public void testListar() {
		ProductoDao pDao = new ProductoDao();
		List<Producto> rta = pDao.listar();
		assert (rta.size() > 0);
	}

}

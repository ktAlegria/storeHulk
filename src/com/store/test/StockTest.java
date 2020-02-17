package com.store.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.store.dao.StockDao;
import com.store.model.Stock;

class StockTest {
	private Stock s;
	private Stock s1;

	
	@Test
	void testCrear() throws SQLException {
		StockDao sDao = new StockDao();
		s = new Stock(2, 20);
		Boolean rta = sDao.crear(s);
		assert (rta);
	}

	@Test
	void testEditar() throws SQLException {
		StockDao sDao = new StockDao();
		s1 = new Stock(12, 20);
		Boolean rta = sDao.editar(s1);
		assert (rta);
	}

}

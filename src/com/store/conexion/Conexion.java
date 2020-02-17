package com.store.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	private static BasicDataSource dataSource = null;

	private static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/store_hulk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			dataSource.setInitialSize(10);
			dataSource.setMaxIdle(8);
			dataSource.setMaxTotal(10);
			dataSource.setMaxWaitMillis(60000);
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
		
	}
}
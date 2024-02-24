package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connection.DbParameters;

public class ConnectionSingleton {

	private static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		if (connection == null) {

			Class.forName(DbParameters.dbDriver);

			connection = DriverManager.getConnection(DbParameters.dbUrl, DbParameters.dbUser, DbParameters.dbPass);

		}

		return connection;
	}

}

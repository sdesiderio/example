package connection;

import java.sql.*;

public class ConnectionManager {



    public static PreparedStatement getPreparedStatement(Connection connection,String sql) throws SQLException, ClassNotFoundException {


        return connection.prepareStatement(sql);

    }

    public static ResultSet getResultSet(Connection connection, String sql) throws SQLException, ClassNotFoundException {


        return connection.createStatement().executeQuery(sql);

    }
    
    public static ResultSet getResultSetById(Connection connection, String sql,int id) throws SQLException, ClassNotFoundException {


    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setInt(1, id);
    
    	return ps.executeQuery();
    	

    }

    public static void closeConnection(Connection connection) throws SQLException, ClassNotFoundException {


        connection.close();

    }
}

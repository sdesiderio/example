package ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

@Local
public interface RemoveStudentEJBLocal {
	
	public String removeStudent(Connection connection, String sql, int id, HttpSession session) throws ClassNotFoundException, SQLException;

}

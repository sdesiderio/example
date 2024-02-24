package ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

@Local
public interface StudentsListEJBLocal {
	
	public String findAllStudents(Connection connection,String sql, HttpSession session) throws ClassNotFoundException, SQLException;

}

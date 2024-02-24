package ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

import dto.StudentDTO;

@Local
public interface StudentRegistrationEJBLocal {
	
	public String addStudent(Connection connection,String sql, StudentDTO studentDTO, HttpSession session) throws ClassNotFoundException, SQLException;

}

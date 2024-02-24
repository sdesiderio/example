package ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import dto.StudentDTO;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import page.Page;


@Stateless
public class StudentRegistrationEJB implements StudentRegistrationEJBLocal {

	@Override
	public String addStudent(Connection connection, String sql, StudentDTO studentDTO, HttpSession session) throws ClassNotFoundException, SQLException {
		
		String page = Page.error;
		
		int nRowsInserted = 0;
		
		StudentDAO studentDAO = new StudentDAOImpl();
		
		nRowsInserted = studentDAO.addStudent(connection, sql, studentDTO);
		
		if (nRowsInserted>0) {
			
			session.setAttribute("studentDTO", studentDTO);
			page = Page.okRegistration;
		}
		
		return page;
		
	}

   

}

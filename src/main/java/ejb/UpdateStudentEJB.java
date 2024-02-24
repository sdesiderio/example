package ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import dto.StudentDTO;
import page.Page;
import sql.SqlScript;
import vo.StudentVO;
import dao.StudentDAOImpl;
import dao.StudentDAO;

@Stateless
public class UpdateStudentEJB implements UpdateStudentEJBLocal {

	@Override
	public String updateStudent(Connection connection, String sql, StudentDTO studentDTO, int id, HttpSession session)
			throws ClassNotFoundException, SQLException {

		String page = null;

		int nRowsUpdated = 0;
		
		ArrayList<StudentVO> students = new ArrayList<>();

		StudentDAO studentDAO = new StudentDAOImpl();

		nRowsUpdated = studentDAO.updateStudent(connection, sql, studentDTO, id);

		if (nRowsUpdated > 0) {

			students = studentDAO.findAllStudents(connection, SqlScript.sqlRead);
			session.setAttribute("students", students);
			page = Page.studentsList;

		}

		return page;

	}

}

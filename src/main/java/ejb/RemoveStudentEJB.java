package ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import page.Page;
import sql.SqlScript;
import vo.StudentVO;
import dao.StudentDAOImpl;
import dao.StudentDAO;

@Stateless
public class RemoveStudentEJB implements RemoveStudentEJBLocal {

	@Override
	public String removeStudent(Connection connection, String sql, int id, HttpSession session)
			throws ClassNotFoundException, SQLException {

		String page = Page.error;

		int nRowsDeleted = 0;

		ArrayList<StudentVO> students = new ArrayList<>();

		StudentDAO studentDAO = new StudentDAOImpl();

		nRowsDeleted = studentDAO.removeStudent(connection, sql, id);

		if (nRowsDeleted > 0) {

			students = studentDAO.findAllStudents(connection, SqlScript.sqlRead);

			if (!students.isEmpty()) {

				session.setAttribute("students", students);
				page = Page.studentsList;

			}

		}

		return page;

	}

}

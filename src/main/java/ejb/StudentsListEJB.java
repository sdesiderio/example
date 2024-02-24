package ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import page.Page;
import vo.StudentVO;
import dao.StudentDAOImpl;
import dao.StudentDAO;

@Stateless
public class StudentsListEJB implements StudentsListEJBLocal {

	@Override
	public String findAllStudents(Connection connection, String sql, HttpSession session)
			throws ClassNotFoundException, SQLException {

		String page = Page.error;

		ArrayList<StudentVO> students = new ArrayList<>();

		StudentDAO studentDAO = new StudentDAOImpl();

		students = studentDAO.findAllStudents(connection, sql);

		if (!students.isEmpty()) {

			session.setAttribute("students", students);
			page = Page.studentsList;

		}

		return page;
	}

}

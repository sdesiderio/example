package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConnectionSingleton;
import ejb.StudentsListEJBLocal;
import sql.SqlScript;

@WebServlet("/students")
public class StudentsListServlet extends HttpServlet {

	@EJB
	private StudentsListEJBLocal studentsList;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = null;

		String page = null;

		HttpSession session = request.getSession();

		try {
			connection = ConnectionSingleton.getConnection();
			page = studentsList.findAllStudents(connection, SqlScript.sqlRead, session);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		response.sendRedirect(page);

	}

}

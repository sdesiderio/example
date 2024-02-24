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

import ejb.StudentRegistrationEJBLocal;
import sql.SqlScript;
import connection.ConnectionSingleton;
import dto.StudentDTO;

@WebServlet("/registration")
public class StudentRegistrationServlet extends HttpServlet {

	@EJB
	private StudentRegistrationEJBLocal registration;

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String a = request.getParameter("firstname");
		

		String page = null;

		Connection connection = null;

		HttpSession session = request.getSession();

		StudentDTO studentDTO = new StudentDTO(request.getParameter("firstname"), request.getParameter("lastname"),
				Integer.parseInt(request.getParameter("age")));

		try {
			connection = ConnectionSingleton.getConnection();
			page = registration.addStudent(connection, SqlScript.sqlInsert, studentDTO, session);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(page);

	}

}

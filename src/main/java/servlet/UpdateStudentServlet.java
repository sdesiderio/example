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

import dto.StudentDTO;
import ejb.UpdateStudentEJBLocal;
import singleton.ConnectionSingleton;
import sql.SqlScript;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {

	@EJB
	private UpdateStudentEJBLocal update;

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = null;

		Connection connection = null;

		HttpSession session = request.getSession();

		String id = request.getParameter("id");

		StudentDTO studentDTO = new StudentDTO(request.getParameter("firstname"), request.getParameter("lastname"),
				Integer.parseInt(request.getParameter("age")));

		try {
			connection = ConnectionSingleton.getConnection();
			page = update.updateStudent(connection, SqlScript.sqlUpdate, studentDTO, Integer.parseInt(id), session);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(page);

	}

}

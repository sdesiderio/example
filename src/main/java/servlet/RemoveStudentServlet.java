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

import ejb.RemoveStudentEJBLocal;
import singleton.ConnectionSingleton;
import sql.SqlScript;

@WebServlet("/delete")
public class RemoveStudentServlet extends HttpServlet {

	@EJB
	private RemoveStudentEJBLocal remove;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;

		String page = null;

		HttpSession session = request.getSession();

		String id = request.getParameter("id");

		try {
			con = ConnectionSingleton.getConnection();
			page = remove.removeStudent(con, SqlScript.sqlDelete, Integer.parseInt(id), session);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(page);

	}

}

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

import ejb.StudentToUpdateEJBLocal;
import singleton.ConnectionSingleton;
import sql.SqlScript;

@WebServlet("/toUpdate")
public class StudentToUpdateServlet extends HttpServlet {
	
	@EJB
	private StudentToUpdateEJBLocal toUpdate;
	
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		
		String page = null;
		
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		try {
			 connection = ConnectionSingleton.getConnection();
			 page = toUpdate.studentToUpdate(connection, SqlScript.sqlReadById, Integer.parseInt(id), session);
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(page);
		
	}

}

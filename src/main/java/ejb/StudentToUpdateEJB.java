package ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import page.Page;
import vo.StudentVO;
import dao.StudentDAOImpl;
import dao.StudentDAO;


@Stateless
public class StudentToUpdateEJB implements StudentToUpdateEJBLocal {

	@Override
	public String studentToUpdate(Connection con, String sql, int id, HttpSession session) throws ClassNotFoundException, SQLException {
		
		String page = Page.error;
		
		StudentDAO studentDAO = new StudentDAOImpl();
		
		StudentVO studentVO=null;
		
		studentVO = studentDAO.findStudentById(con, sql, id);
		
		
		if(studentVO!=null && studentVO.getId()>0) {
			
			session.setAttribute("studentVO", studentVO);
			page = Page.studentToUpdate;
			
			
		}
		
		return page;
		
		
	}

    

}

package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import dao.StudentDAOImpl;
import dto.StudentDTO;
import dao.StudentDAO;

import singleton.ConnectionSingleton;
import sql.SqlScript;
import vo.StudentVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test {

	@org.junit.Test
	public void test1() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionSingleton.getConnection();

		StudentDTO studentDTO = new StudentDTO("Maria", "Resti", 24);

		StudentDAO studentDAO = new StudentDAOImpl();

		int nRowsInserted = studentDAO.addStudent(connection, SqlScript.sqlInsert, studentDTO);

		assertEquals(nRowsInserted, 1);

	}

	@org.junit.Test
	public void test2() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionSingleton.getConnection();

		StudentDAO studentDAO = new StudentDAOImpl();

		int nRowsDeleted = studentDAO.removeStudent(connection, SqlScript.sqlDelete, 18);

		assertEquals(nRowsDeleted, 1);

	}

	@org.junit.Test
	public void test3() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionSingleton.getConnection();

		StudentDTO studentDTO = new StudentDTO("Geco", "Lilli", 25);

		StudentDAO studentDAO = new StudentDAOImpl();

		int nRowsUpdated = studentDAO.updateStudent(connection, SqlScript.sqlUpdate, studentDTO, 7);

		assertEquals(nRowsUpdated, 1);

	}

	@org.junit.Test
	public void test4() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionSingleton.getConnection();

		StudentDAO studentDAO = new StudentDAOImpl();

		ArrayList<StudentVO> students = studentDAO.findAllStudents(connection, SqlScript.sqlRead);

		assertEquals(students.size(), 11);

	}

}

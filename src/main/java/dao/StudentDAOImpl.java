package dao;

import connection.ConnectionManager;
import dto.StudentDTO;
import vo.StudentVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

	public int addStudent(Connection con, String sql, StudentDTO studentDTO)
			throws SQLException, ClassNotFoundException {

		PreparedStatement ps = ConnectionManager.getPreparedStatement(con, sql);
		ps.setString(1, studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());

		return ps.executeUpdate();

	}

	public int updateStudent(Connection con, String sql, StudentDTO studentDTO, int id)
			throws SQLException, ClassNotFoundException {

		PreparedStatement ps = ConnectionManager.getPreparedStatement(con, sql);
		ps.setString(1, studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		ps.setInt(4, id);

		return ps.executeUpdate();

	}

	public int removeStudent(Connection con, String sql, int id) throws SQLException, ClassNotFoundException {

		PreparedStatement ps = ConnectionManager.getPreparedStatement(con, sql);
		ps.setInt(1, id);

		return ps.executeUpdate();

	}

	public ArrayList<StudentVO> findAllStudents(Connection connection, String sql)
			throws SQLException, ClassNotFoundException {

		StudentVO studentVO = null;

		ArrayList<StudentVO> students = new ArrayList<>();

		ResultSet rs = ConnectionManager.getResultSet(connection, sql);

		while (rs.next()) {

			studentVO = new StudentVO(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getInt("age"));

			students.add(studentVO);

		}

		return students;

	}

	@Override
	public StudentVO findStudentById(Connection connection, String sql, int id)
			throws SQLException, ClassNotFoundException {

		StudentVO studentVO = null;

		ResultSet rs = ConnectionManager.getResultSetById(connection, sql, id);

		if (rs.next()) {

			
			studentVO = new StudentVO(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("age"));
			System.out.println(studentVO.getId());

		}

		return studentVO;

	}
}

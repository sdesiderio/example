package dao;

import dto.StudentDTO;
import vo.StudentVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {

    public int addStudent(Connection con, String sql, StudentDTO studentDTO) throws SQLException, ClassNotFoundException;

    public int updateStudent(Connection con, String sql, StudentDTO studentDTO, int id) throws SQLException, ClassNotFoundException;

    public int removeStudent(Connection con, String sql,int id) throws SQLException, ClassNotFoundException;

    public ArrayList<StudentVO> findAllStudents(Connection connection, String sql) throws SQLException, ClassNotFoundException;
    
    public StudentVO findStudentById(Connection connection, String sql, int id) throws SQLException, ClassNotFoundException;
}

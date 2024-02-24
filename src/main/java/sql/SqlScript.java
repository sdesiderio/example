package sql;

public interface SqlScript {

    String sqlInsert = "insert into student(first_name,last_name,age) values (?,?,?)";

    String sqlUpdate = "update student set first_name=?,last_name=?,age=? where id=?";

    String sqlDelete = "delete from student where id=?";

    String sqlRead = "select * from student";
    
    String sqlReadById = "select * from student where id=?";

}


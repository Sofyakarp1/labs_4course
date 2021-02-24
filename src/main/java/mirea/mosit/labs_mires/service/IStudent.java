package mirea.mosit.labs_mires.service;

import mirea.mosit.labs_mires.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IStudent {

    private final JdbcTemplate jdbcTemplate;

    public IStudent(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public Student getStudent(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", this::mapStudent, id);
    }

    private Student mapStudent(ResultSet rs, int i) throws SQLException {
        Student student = new Student(
                rs.getInt("id"),
                rs.getString("surname"),
                rs.getString("name"),
                rs.getString("second_name"),
                rs.getInt("study_group_id")
        );
        return student;
    }

    //Search student by name
    public List<Student> showStudentByName(String student_name) {
        return jdbcTemplate.query("SELECT * FROM student WHERE name = ?", this::mapStudent, student_name);
    }

    //Show all students
    public List<Student> showAllStudents() {
        return jdbcTemplate.query("SELECT * FROM student", this::mapStudent);
    }

    //Show student by group
    public List<Student> showStudentByGroup(int group_id) {
        return jdbcTemplate.query("SELECT * FROM student WHERE study_group_id = ?", this::mapStudent, group_id);
    }

    //Add student
    public Student addStudent(Student student) {
        assert jdbcTemplate.update("INSERT INTO student VALUES (?, ?, ?, ?, ?)", student.getId(), student.getSurname(), student.getName(), student.getSecondName(), student.getStudyGroupId()) > 0;
        return getStudent(student.getId());
    }

    //Edit student
    public Student editStudent(Student student) {
        assert jdbcTemplate.update("UPDATE student SET surname = ?2, name = ?3, second_name = ?4, study_group_id = ?5 where id = ?1", student.getId(), student.getSurname(), student.getName(), student.getSecondName(), student.getStudyGroupId()) > 0;
        return getStudent(student.getId());
    }

    //Delete student
    public int deleteStudent(int id) {
        return jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }
}

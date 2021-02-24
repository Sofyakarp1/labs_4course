package mirea.mosit.labs_mires.service;

import mirea.mosit.labs_mires.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Student> findAll() {

        String sql = "SELECT * FROM CITIES";

        List<Student> cities = jtm.query(sql, new BeanPropertyRowMapper(Student.class));

        return cities;
    }

    @Override
    public Student findById(Long id) {

        String sql = "SELECT * FROM CITIES WHERE ID=?";

        Student student = (Student) jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper(Student.class));

        return student;
    }
}

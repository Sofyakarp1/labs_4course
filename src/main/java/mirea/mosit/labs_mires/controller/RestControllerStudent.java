package mirea.mosit.labs_mires.controller;

import mirea.mosit.labs_mires.bean.Student;
import mirea.mosit.labs_mires.service.IStudent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerStudent {

    private final IStudent studentJdbc;

    public RestControllerStudent(IStudent iStudent) {
        this.studentJdbc = iStudent;
    }

    @GetMapping("/student/{id}") // показать студента по id
    public Student getStudent(@PathVariable int id) {
        Student student = studentJdbc.getStudent(id);
        return student;
    }

    @GetMapping("/student/showAllStudent") // показать всех студентов
    public List<Student> showAll() {
        return studentJdbc.showAllStudents();
    }

    @GetMapping("/student/groupId/{group_id}") // показать по группе
    public List<Student> showByGroup(@PathVariable int group_id) {
        return studentJdbc.showStudentByGroup(group_id);
    }

    @GetMapping("/student/name/{student_name}") // показать студента по имени
    public List<Student> showByName(@PathVariable String student_name) {
        return studentJdbc.showStudentByName(student_name);
    }
}

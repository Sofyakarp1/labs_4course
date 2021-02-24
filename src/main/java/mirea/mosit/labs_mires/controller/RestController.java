package mirea.mosit.labs_mires.controller;


import mirea.mosit.labs_mires.bean.Student;
import mirea.mosit.labs_mires.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/students")
    public List<Student> findCities() {

        return studentService.findAll();
    }

    @RequestMapping("/students/{userId}")
    public Student findCity(@PathVariable Long userId) {

        return studentService.findById(userId);
    }
}

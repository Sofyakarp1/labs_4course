package mirea.mosit.labs_mires.service;

import mirea.mosit.labs_mires.bean.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();
    public Student findById(Long id);
}

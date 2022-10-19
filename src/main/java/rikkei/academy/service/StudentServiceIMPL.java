package rikkei.academy.service;

import rikkei.academy.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    public static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1L, "Chinh ND", "chinhnd2@rikkeisoft.com", "Hai Duong"));
        studentList.add(new Student(2L, "DungLV", "dunglv@rikkeisoft.com", "Phu Tho"));
        studentList.add(new Student(3L, "Toan TV", "toan@rikkeisoft.com", "Quang Ninh"));

    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(Long id) {
        return studentList.get(Math.toIntExact(id));
    }
}

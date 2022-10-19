package rikkei.academy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Student;
import rikkei.academy.service.StudentServiceIMPL;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    private final StudentServiceIMPL studentServiceIMPL;


    public StudentController(StudentServiceIMPL studentServiceIMPL) {
        this.studentServiceIMPL = studentServiceIMPL;
    }

    @GetMapping({"/", "/students"})
    public ModelAndView showList() {
        ModelAndView model = new ModelAndView("student/list");
        List<Student> studentList = studentServiceIMPL.findAll();
        model.addObject("students", studentList);
        return model;
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable Long id,
            HttpServletRequest request
    ) {
        Long _id = id - 1;
        Student student = studentServiceIMPL.findById(_id);
        request.setAttribute("student", student);
        return "student/info";
    }

}

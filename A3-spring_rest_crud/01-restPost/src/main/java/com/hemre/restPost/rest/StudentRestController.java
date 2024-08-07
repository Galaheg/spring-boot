package com.hemre.restPost.rest;

import com.hemre.restPost.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/members")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Emre", "Inan"));
        theStudents.add(new Student("Berfin", "Inan"));
        theStudents.add(new Student("Adem", "Inan"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudentByName(@PathVariable int id){

        // Check for overflow

        if((id >= theStudents.size() || (id<0))){
            throw new StudentNotFoundException("Student id not found - " + id);
        }

        return theStudents.get(id);
//        for (Student s : theStudents) {
//            if (s.getFirstName().equals(studentName)){
//               return s;
//            }
//        }

    }

}

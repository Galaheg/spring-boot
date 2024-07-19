package com.hemre.cruddemo.dao;

import com.hemre.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();
}

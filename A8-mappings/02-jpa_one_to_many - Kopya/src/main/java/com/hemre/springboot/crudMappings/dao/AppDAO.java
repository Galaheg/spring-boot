package com.hemre.springboot.crudMappings.dao;

import com.hemre.springboot.crudMappings.entity.Instructor;
import com.hemre.springboot.crudMappings.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteByDetailsCascadeById(int id);
}

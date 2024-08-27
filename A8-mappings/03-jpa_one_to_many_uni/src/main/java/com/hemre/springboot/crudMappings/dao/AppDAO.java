package com.hemre.springboot.crudMappings.dao;

import com.hemre.springboot.crudMappings.entity.Course;
import com.hemre.springboot.crudMappings.entity.Instructor;
import com.hemre.springboot.crudMappings.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteByDetailsCascadeById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor finInstructorByJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourse(int id);

    void save(Course course);

    public Course findCourseAndReviewsByCourseId(int id);
}

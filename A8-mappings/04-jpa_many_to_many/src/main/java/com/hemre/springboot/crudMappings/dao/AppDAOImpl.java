package com.hemre.springboot.crudMappings.dao;

import com.hemre.springboot.crudMappings.entity.Course;
import com.hemre.springboot.crudMappings.entity.Instructor;
import com.hemre.springboot.crudMappings.entity.InstructorDetail;
import com.hemre.springboot.crudMappings.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AppDAOImpl implements AppDAO{

    //define field for entity manager
    private EntityManager entityManager;
    // inject entity manager by constructor injection

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor tempInstructor =
                entityManager.find(Instructor.class, id);
        return tempInstructor;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor tempInstructor = entityManager.find(Instructor.class, id);

        List<Course> courses =  tempInstructor.getCourses();

        for (Course course : courses){
            course.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
        return tempInstructorDetail;
    }

    @Override
    @Transactional
    public void deleteByDetailsCascadeById(int id) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        //break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );

        query.setParameter("data", id);

        List<Course> getResultList = query.getResultList();

        return getResultList;
    }

    // this is for lazy init
    @Override
    public Instructor finInstructorByJoinFetch(int id) {

        TypedQuery<Instructor> theQuery = entityManager.createQuery(
                "select i from Instructor i " + "JOIN FETCH i.courses "+
                        "where i.id=:data",Instructor.class
        );

        theQuery.setParameter("data", id);

        Instructor tempInstructor = theQuery.getSingleResult();

        return tempInstructor;

    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        Course tempCourse = entityManager.find(Course.class, id);
        return tempCourse;
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {

        Course tempCourse = entityManager.find(Course.class, id);

        entityManager.remove(tempCourse);

    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        // Lazy Init
        TypedQuery<Course> theQuery = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id =:data", Course.class
        );

        theQuery.setParameter("data", id);

        Course course = theQuery.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> theQuery = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id =:data", Course.class
        );

        theQuery.setParameter("data", id);
        Course course = theQuery.getSingleResult();

        return course;
    }
    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id =:data", Student.class
        );

        theQuery.setParameter("data", id);
        Student student = theQuery.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student tempStudent = entityManager.find(Student.class, id);
        entityManager.remove(tempStudent);
    }


}

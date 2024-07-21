package com.hemre.cruddemo.dao;

import com.hemre.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Temporal;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager using constructor injection and autowired

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional//Create, delete or update
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //find all students
    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        return  theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    //Update student
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        System.out.println("Deleting student named "+student.getFirstName()+" .....");
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}

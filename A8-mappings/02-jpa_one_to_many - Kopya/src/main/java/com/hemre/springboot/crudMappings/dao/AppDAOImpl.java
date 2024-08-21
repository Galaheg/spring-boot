package com.hemre.springboot.crudMappings.dao;

import com.hemre.springboot.crudMappings.entity.Instructor;
import com.hemre.springboot.crudMappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
}

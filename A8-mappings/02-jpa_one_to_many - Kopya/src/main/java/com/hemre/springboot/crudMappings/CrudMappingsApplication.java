package com.hemre.springboot.crudMappings;

import com.hemre.springboot.crudMappings.dao.AppDAO;
import com.hemre.springboot.crudMappings.entity.Course;
import com.hemre.springboot.crudMappings.entity.Instructor;
import com.hemre.springboot.crudMappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudMappingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudMappingsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {//run when code starts we use commandlinerunner to
        return runner -> {

            createInstructorWithCourse(appDAO);
            //deleteByDetailId(appDAO);
            //findInstrcutorDetail(appDAO);
            //deleteInstructor(appDAO);
            //createInstructor(appDAO);
        };
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				createInstructor(appDAO);
//			}
//		};

    }

    private void createInstructorWithCourse(AppDAO appDAO) {

        Instructor tempInstructor = new Instructor("Emre", "INAN", "hemreinan@gmail.com");

        InstructorDetail tempInsDetail = new InstructorDetail("youtube.com", "Spring Boot");

        tempInstructor.setInstructorDetail(tempInsDetail);

		// create courses
        Course tempCourse1 = new Course("ss");
        Course tempCourse2 = new Course("Datas");

		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);

		appDAO.save(tempInstructor);
    }

    private void deleteByDetailId(AppDAO appDAO) {
        System.out.println("deleting by detail cascade");
        appDAO.deleteByDetailsCascadeById(3);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        System.out.println(appDAO.findInstructorDetailById(2).getInstructor().getFirstName());
    }

    private void deleteInstructor(AppDAO appDAO) {
        System.out.println("Deleting Instructor...");
        appDAO.deleteById(1);
        System.out.println("DONE deleting");
    }

    private void findInstructor(AppDAO appDAO) {

        System.out.println("Finding Instructor....");
        Instructor instructor = appDAO.findById(1);
        System.out.println("FOUND: " + instructor.getFirstName());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Emre", "INAN", "hemreinan@gmail.com");

        InstructorDetail tempInsDetail = new InstructorDetail("hemrererer", "Spring Boot");

        tempInsDetail.setInstructor(tempInstructor);
        tempInstructor.setInstructorDetail(tempInsDetail);

        System.out.println("Saving instructor" + tempInstructor);

        appDAO.save(tempInstructor);

        tempInstructor = new Instructor("Berfin", "Acikgoz", "brfn@gmail.com");

        tempInsDetail = new InstructorDetail("brfn", "Spring Boot");

        tempInstructor.setInstructorDetail(tempInsDetail);

        System.out.println("Saving instructor" + tempInstructor);

        appDAO.save(tempInstructor);
        System.out.println("DONE");

    }
}

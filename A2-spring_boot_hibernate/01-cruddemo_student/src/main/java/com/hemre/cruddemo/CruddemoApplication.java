package com.hemre.cruddemo;

import com.hemre.cruddemo.dao.StudentDao;
import com.hemre.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			createStudent(studentDao);
			//findStudent(studentDao);
			//listAllQuery(studentDao);
			//listByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAll(studentDao);
		};
	}

	private void deleteAll(StudentDao studentDao) {
		int numberOfDeleted = studentDao.deleteAllStudents();
		System.out.println(numberOfDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {

		int deletedId = 4;

		studentDao.deleteStudent(deletedId);

	}

	private void updateStudent(StudentDao studentDao) {

		int studentId = 1;
		System.out.println("Getting student id=1");

		Student studentFound = studentDao.findById(studentId);
		studentFound.setFirstName("Hüseyin Emre");

		studentDao.update(studentFound);
	}

	private void listByLastName(StudentDao studentDao) {
		List<Student> studentsByLastName = studentDao.findByLastName("Inan");

		for (Student s : studentsByLastName){
			System.out.println(s);
		}

	}

	private void listAllQuery(StudentDao studentDao) {

		List<Student> students = studentDao.findAll();
		int i=1;
		for (Student s : students){
			System.out.println("Student " + s.getId()+": " +s.getFirstName());
			i++;
		}

	}

	private void findStudent(StudentDao studentDao){
		// create a student object

		//save the student

		//display id of the saved student

		//retrieve student based on the id
		Student studentx = studentDao.findById(1);
		//display student
		System.out.println(studentx.getFirstName());
	}
	private void createStudent(StudentDao studentDao){

		// create the student OBject
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Emre", "Inan", "hemreinan@hotmail.com");
		Student tempStudent2 = new Student("Berfin", "Inan", "berfinan@hotmail.com");
		Student tempStudent3 = new Student("Paul", "Walker", "pwalker@hotmail.com");

		// save the student object
		System.out.println("Save the student");
		studentDao.save(tempStudent);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

		//display id of the saved student
		System.out.println("Saved student. ID is: "+tempStudent.getId());
	}
}

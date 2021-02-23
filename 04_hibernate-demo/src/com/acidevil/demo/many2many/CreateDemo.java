package com.acidevil.demo.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.acidevil.demo.entity.many2many.Course;
import com.acidevil.demo.entity.many2many.Instructor;
import com.acidevil.demo.entity.many2many.InstructorDetail;
import com.acidevil.demo.entity.many2many.Review;
import com.acidevil.demo.entity.many2many.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.many2many.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("beginning trnasaction");
			session.beginTransaction();
			
			Course course1 = new Course("Air guitar");
			
			session.save(course1);
			
			System.out.println("course saved");
			
			Student student1 = new Student("John", "Doe", "john@luv2code.com");			
			Student student2 = new Student("Andrea", "Coluzzi", "andrea@luv2code.com");
			
			
			course1.addStudent(student1);
			course1.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			System.out.println("saved students");
			
//			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//			InstructorDetail detail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!");
//
//			
//			
//			instructor.setInstructorDetail(detail);
//			instructor.add(course1);
//
//			
//
//			session.save(instructor);
			

			System.out.println("committing");
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception exc) {
			exc.printStackTrace();
			session.close();
			factory.close();
		}
	}

}

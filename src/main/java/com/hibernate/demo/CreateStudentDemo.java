package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating a new student object ...");
            Student tempStudent = new Student(123L,"Paul","Wall","paul.wall@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student ...");

            session.save(tempStudent);
//          session.persist(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done!");


        }finally{
            session.close();
            factory.close();
        }
    }



}

package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            System.out.println("Deleting a student object ...");
            Student tempStudent = new Student();

            session.beginTransaction();

            System.out.println("Loading the student ...");
            tempStudent = session.get(Student.class,1);
            System.out.println(tempStudent);
            session.delete(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done!");


        }finally{
            session.close();
            factory.close();
        }
    }



}

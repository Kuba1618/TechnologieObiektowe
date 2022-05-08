package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Retrieve {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            System.out.println("Retrieving a student object ...");
            Student tempStudent = new Student();

            session.beginTransaction();

            System.out.println("Loading/Retrieving the student ...");
            tempStudent = session.get(Student.class,2);
            System.out.println(tempStudent);
            session.getTransaction().commit();

            System.out.println("Done!");


        }finally{
            session.close();
            factory.close();
        }
    }



}

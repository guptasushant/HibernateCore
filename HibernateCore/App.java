package com.sushant.HibernateCore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("com/sushant/HibernateCore/hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Scanner sc=new Scanner(System.in);
        List<Student>list=new ArrayList<Student>();
        Student student = new Student();
        System.out.println("enter the name");
        student.setName(sc.nextLine());
        System.out.println("enter the city");
        student.setCity(sc.next());
        list.add(student);
        Address add=new Address();
        System.out.println("enter the street");
        add.setStreet("45th avenue");
        System.out.println("enter the city");
        add.setCity("new york");
        add.setOPen(true);
        add.setAddedDate(new Date()); 
        Session k=factory.openSession();
     //   Session k = new Configuration().configure("com/sushant/HibernateCore/hibernate.cfg.xml").buildSessionFactory().openSession();
        k.save(student); 
        k.save(add);
         Transaction transaction = k.beginTransaction();
         transaction.commit();
         System.out.println("DONE!!");
         k.close();
        
    }
}

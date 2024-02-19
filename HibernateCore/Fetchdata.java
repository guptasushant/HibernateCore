package com.sushant.HibernateCore;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Fetchdata {
	public static void main(String[] args) {
		Session k= new Configuration().configure("com/sushant/HibernateCore/hibernate.cfg.xml").buildSessionFactory().openSession();
		Student student=k.get(Student.class, 1);
		Address address=k.get(Address.class, 1);
		System.out.println(student);
		System.out.println(address );
	
	}
}

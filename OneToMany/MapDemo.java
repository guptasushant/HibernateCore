package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		SessionFactory sessionf=new Configuration().configure("com\\OneToMany\\hiber.cfg.xml").buildSessionFactory();
		
		Question q=new Question();
		q.setQuestion_id(101);
		q.setQuestions("what is java basically");

		Answer a=new Answer();
		a.setAnswer_id(11);
		a.setAnswer("java is a programming language ");
		a.setQuestion(q);
		//new question
		
		Answer a1=new Answer();
		a1.setAnswer_id(12);
		a1.setAnswer("java is a secure language ");
		a1.setQuestion(q);
		
		Answer a2=new Answer();
		a2.setAnswer_id(13);
		a2.setAnswer("with the help of java we can create softwares s");
		List<Answer>list=new ArrayList<Answer>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		a2.setQuestion(q);
		
		
		
		
		
		Session session =sessionf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(q);
		session.save(a);
		session.save(a1);
		session.save(a2);
		
		
		tx.commit();
		
		
		
		
		sessionf.close();
		
	}

}

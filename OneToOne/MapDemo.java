package com.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		SessionFactory sessionf=new Configuration().configure("com/sushant/HibernateCore/hibernate.cfg.xml").buildSessionFactory();
		
		Question q=new Question();
		q.setQuestion_id(101);
		q.setQuestions("what is your name ");

		Answer a=new Answer();
		a.setAnswer_id(11);
		a.setAnswer("my name is sushant");
		q.setAnswer(a);
		//new question
		Question q1=new Question();
		q1.setQuestion_id(102);
		q1.setQuestions("where do you stay  ");
		
		Answer a1=new Answer();
		a1.setAnswer_id(12);
		a1.setAnswer("i stay in sakinaka ");
		q1.setAnswer(a1);
		
		Question q2=new Question();
		q2.setQuestion_id(103);
		q2.setQuestions("what do you do ? ");
		
		Answer a2=new Answer();
		a2.setAnswer_id(13);
		a2.setAnswer("i am a software developer");
		q2.setAnswer(a2);
		
		
		
		
		
		
		Session session =sessionf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(q);
		session.save(q1);
		session.save(q2);
		session.save(a);
		session.save(a1);
		session.save(a2);
		
		
		tx.commit();
		// fetching the answer related to question id 
		Question question = (Question)session.get(Question.class, 101);
		System.out.println(question.getAnswer().getAnswer());
		
		Question question1 = (Question)session.get(Question.class, 102);
		System.out.println(question1.getAnswer().getAnswer());
		
		
		
		sessionf.close();
		
	}

}

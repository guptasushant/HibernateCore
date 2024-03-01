package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.common.HibernateUtil;
import com.pojo.Addproduct;
import com.pojo.Admin;
import com.pojo.Register;

public class BlManager {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public void saveRegisterInfo(Register reg) {

		if (sessionFactory == null) {
			System.err.println("SessionFactory is null. Cannot open session.");
			return;
		}

		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(reg);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error occurred while saving register info: " + e.getMessage());
		}
	}

	public Register searchbyEmailpass(String email, String password) {
		Session sesh = sessionFactory.openSession();
		Criteria criteria=sesh.createCriteria(Register.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		Register uniqueResult = (Register) criteria.uniqueResult();
		return uniqueResult;
	}


	public Admin searchforAdmin(String username, String password) {
		Session sesh = sessionFactory.openSession();
		Criteria criteria=sesh.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		Admin uniqueResult = (Admin) criteria.uniqueResult();
		return uniqueResult;
	}

	public void saveProdInfo(Addproduct ap) {
		Session sesh=sessionFactory.openSession();
		Transaction t=sesh.beginTransaction();
		sesh.save(ap);
		t.commit();
		sesh.close();
	
	}

	public void delete(int rid) {
		Session sesh=sessionFactory.openSession();
		Criteria criteria=sesh.createCriteria(Register.class);
		criteria.add(Restrictions.eq("rid", rid));
		Register uniqueResult = (Register) criteria.uniqueResult();
		Transaction t=sesh.beginTransaction();
		sesh.delete(rid);
		t.commit();
		sesh.close();
	}

    public List<Register> showUserList() {
        List<Register> regList = new ArrayList<Register>();
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Register.class);
            regList = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return regList;
    }
}

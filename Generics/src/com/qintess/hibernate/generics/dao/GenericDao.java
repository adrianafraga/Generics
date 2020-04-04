package com.qintess.hibernate.generics.dao;

import com.qintess.hibernate.generics.HibernateConfig;
import com.qintess.hibernate.generics.modelo.*;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class GenericDao <T extends EntidadeBase> {
	
	
	/*private Session getSession() {
		Transaction transaction = null;
		Session session  = (Session) HibernateConfig.getSessionFactory().openSession();
		return session = null;
	}*/
	
	
	//leitura
	public T findById (Class<T> clazz, Long id) {
		Transaction transaction = null;
		Session session  = (Session) HibernateConfig.getSessionFactory().openSession();
		return session.find(clazz, id);
	}
	
	//salvar e update
	public void saveOrUpdate (T obj) {
		Transaction transaction = null;
		Session session  = (Session) HibernateConfig.getSessionFactory().openSession();
		
		try {
			(transaction = session.beginTransaction());
			
			if(obj.getId()==null) {
				session.persist(obj);			
			} else {
				session.merge(obj);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		finally {
		
		session.close();
		}
	}	
	
	
	

	//deletar
	public void remove (Class <T> clazz, Long id) {
		T t = findById(clazz, id);
		Transaction transaction = null;
		Session session  = (Session) HibernateConfig.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.remove(t);			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		finally {
				
				session.close();
				}
		}
	
	
}


	
	


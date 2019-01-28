package com.DAO;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.Bean.Abonnee;
import com.Bean.Agent;

import com.hibernate.HibernateUtil;

public class DAOImplement implements DaoInterface{

	@Override
	public List<Agent> listeAgent() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  
		 List<Agent> liste=(List<Agent>) session.createQuery("from Agent").list();
    session.getTransaction().commit();
    session.close();
    
   return liste;
	}

	@Override
	public List<Abonnee> listeAbonnees() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  
		 List<Abonnee> liste=(List<Abonnee>) session.createQuery("from Abonnee").list();
      session.getTransaction().commit();
      
      session.close();
     
     return liste;
	}

	@Override
	public Abonnee getAbonnee(int id) {
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  
		  Abonnee abonnee = (Abonnee) session.get(Abonnee.class, id);
		
		 session.getTransaction().commit();
		    session.close();
		   
		 return abonnee;
	}

	@Override
	public Agent getAgent(int id) {
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  
		  Agent agent = (Agent) session.get(Agent.class, id);
		
		 session.getTransaction().commit();
		    session.close();
		   
		 return agent;
	}

	@Override
	public void UpdatePayement(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  
		  Abonnee abn = (Abonnee) session.get(Abonnee.class, id);
		  
		  abn.setPayement(true);
		  session.update(abn);
		 session.getTransaction().commit();
		 
		 session.close();
	}
	
	

}

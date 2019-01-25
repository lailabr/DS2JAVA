package Test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.Bean.*;

import com.hibernate.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  
		  Agent agent = new Agent();
		  
		  agent.setLogin("laila");
		  agent.setPassword("laila");
		  
		  
		  session.save(agent);
		  
		 
		  Abonnee abn = new Abonnee();
		  abn.setLogin("test");
		  abn.setMontant(300);
		  abn.setNom("test");
		  abn.setPassword("test");
		  abn.setPrenom("test");
		  abn.setPayement(true);
		  
		  session.save(abn);
		  
		
		 session.getTransaction().commit();

	}

}

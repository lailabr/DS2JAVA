package com.Metier;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Bean.Abonnee;
import com.Bean.Agent;

import com.DAO.DAOImplement;
import com.hibernate.HibernateUtil;

public class Metier {
	
	private String role=null;
	private int id;
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	DAOImplement dao = new DAOImplement();
	
	
		//authentify function
		
		public Boolean authentify(HttpServletRequest request)
		{

			  Boolean result =false;
			  List<Agent> listeAgents=dao.listeAgent();
			  List<Abonnee> listeAbonnees = dao.listeAbonnees();
			  
			  String login = request.getParameter("login");
			  String password = request.getParameter("password");
			  
	  		  for (Agent agent : listeAgents) {
				if((agent.getLogin()).equals(login) && (agent.getPassword()).equals(password)){
					
					setRole("Agent");
					result=true;
					setId(agent.getId());
					
					//System.out.println(patient.getId());
					break;

				  }
				}
	  		  
	  		  for (Abonnee abonnee : listeAbonnees) {
				if((abonnee.getLogin()).equals(login) && (abonnee.getPassword()).equals(password)){
					
					setRole("Abonnee");
					result=true;
					setId(abonnee.getId());
					
					//System.out.println(medecin.getId());
					break;
					
				  }
				}
			  
			  
			 return result;
				
		}

		/**
		 * 
		 * @param id
		 * @return abonnee
		 */
		public Abonnee getAbonnee(int id) {

		return dao.getAbonnee(id);
		
		}
		
/**
 * 
 * @param id
 * @return agent
 */
		public Agent getAgent(int id) {
			return dao.getAgent(id);
		}

/**
 * 
 * @param id2
 * @return 
 * methode pour verifier si le compte existe ou nn
 */
public Boolean VerifierCompte(HttpServletRequest request) {
	boolean exist =false;
	String NumCompte = (request.getParameter("numCart"));
	int dateExpir =Integer.parseInt(request.getParameter("dateExpir"));
	int dernierChiffres =Integer.parseInt(request.getParameter("chiffres"));
	
	
	
	if(NumCompte.equals("0000000000000000") && dateExpir==1111 && dernierChiffres==222)
	{
		exist =true;
		
	}else {
		exist =false;
	}
	return exist;
}


public List<Abonnee> getAllAbonnee() {
	return dao.listeAbonnees();
}


public void ValiderPayement(int id) {
	dao.UpdatePayement(id);
	
}




}

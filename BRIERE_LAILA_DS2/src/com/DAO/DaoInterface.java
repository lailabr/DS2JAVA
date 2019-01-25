package com.DAO;

import java.util.List;

import com.Bean.*;



public interface DaoInterface {
	List<Agent> listeAgent();
	List<Abonnee> listeAbonnees();
	Abonnee getAbonnee(int id);
	Agent getAgent(int id);
	void UpdatePayement(int id);
	
}

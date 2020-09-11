package com.topjavatutorial.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Employes_has_posteDAO {
	private void addEmployeToPoste(int idEmploye, int idPoste) {

		Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();

	    Employes employes = (Employes) session.load(Employes.class, idEmploye);
	    Postes postes = (Postes) session.load(Postes.class, idPoste);

	    employes.getPostes().add(postes);

	    session.getTransaction().commit();
	}
	
	
	private void addEmploye_poste(int idEmploye , int idPoste){
        Employes_has_poste employes_poste = new Employes_has_poste();
        
       
    }
}

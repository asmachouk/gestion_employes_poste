package com.topjavatutorial.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class EmployeeDAO {
    
    public void addEmployes(Employes bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addEmployes(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addEmployes(Session session, Employes bean){
        Employes employes = new Employes();
        
        employes.setNom(bean.getNom());
        employes.setPrenom(bean.getPrenom());
        employes.setAdresse(bean.getAdresse());
        employes.setEmail(bean.getEmail());
        employes.setPostes(bean.getPostes());
        session.save(employes);
    }
    
    public List<Employes> getEmployes(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Employes");
        List<Employes> employees =  query.list();
        session.close();
        return employees;
    }
 
    public int deleteEmployes(int idEmploye) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Employes where idEmploye = :idEmploye";
        Query query = session.createQuery(hql);
        query.setInteger("idEmploye",idEmploye);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateEmployes(int idEmploye, Employes emp){
         if(idEmploye <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Employes set nom = :nom, prenom= :prenom, adresse= :adresse, email= :email where idEmploye = :idEmploye";
            Query query = session.createQuery(hql);
            query.setInteger("idEmploye",idEmploye);
            query.setString("nom",emp.getNom());
            query.setString("prenom",emp.getPrenom());
            query.setString("adresse",emp.getAdresse());
            query.setString("email",emp.getEmail());
           
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}
package com.topjavatutorial.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class PosteDAO {
    
    public void addPostes(Postes bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addPostes(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addPostes(Session session, Postes bean){
    	Postes postes = new Postes();
        
    	postes.setNom(bean.getNom());
    	postes.setDescription(bean.getDescription());
        
        
        session.save(postes);
    }
    
    public List<Postes> getPostes(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Postes");
        List<Postes> postes =  query.list();
        session.close();
        return postes;
    }
 
    public int deletePostes(int idPoste) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Postes where idPoste = :idPoste";
        Query query = session.createQuery(hql);
        query.setInteger("idPoste",idPoste);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updatePostes(int idPoste, Postes pos){
         if(idPoste <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Postes set nom = :nom, Description= :description where idPoste = :idPoste";
            Query query = session.createQuery(hql);
            query.setInteger("idPoste",idPoste);
            query.setString("nom",pos.getNom());
            query.setString("description",pos.getDescription());
            
           
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}
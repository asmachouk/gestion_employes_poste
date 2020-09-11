package com.topjavatutorial.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class FormationDAO {
    
    public void addFormations(Formations bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addFormations(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addFormations(Session session, Formations bean){
        Formations formations = new Formations();
        
        formations.setNom(bean.getNom());
        formations.setDuree(bean.getDuree());
        formations.setNomCabinet(bean.getNomCabinet());
        formations.setCommentaire(bean.getCommentaire());
        
        session.save(formations);
    }
    
    public List<Formations> getFormations(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Formations");
        List<Formations> formations =  query.list();
        session.close();
        return formations;
    }
 
    public int deleteFormations(int idFormation) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Formations where idFormation = :idFormation";
        Query query = session.createQuery(hql);
        query.setInteger("idFormation",idFormation);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateFormations(int idFormation, Formations form){
         if(idFormation <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Formations set nom = :nom, duree= :duree, nomCabinet= :nomCabinet, commentaire= :commentaire where idFormation = :idFormation";
            Query query = session.createQuery(hql);
            query.setInteger("idFormation",idFormation);
            query.setString("nom",form.getNom());
            query.setInteger("duree",form.getDuree());
            query.setString("nomCabinet",form.getNomCabinet());
            query.setString("commentaire",form.getCommentaire());
           
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}
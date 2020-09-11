package com.topjavatutorial.dao;

import java.util.ArrayList;
import java.util.HashSet;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import java.util.Set;
 
@Entity
public class Formations {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idFormation;
    private String nom;
    private int duree;
    private String nomCabinet;
    private String commentaire;
 //  @ManyToMany(mappedBy = "formations")
   Set<Postes> postes = new HashSet<>();
   //@ManyToMany(mappedBy = "formations")
    Set<Employes> employes = new HashSet<>();
    
	
	
	public Set<Postes> getPostes() {
		return postes;
	}
	public void setPostes(Set<Postes> postes) {
		this.postes = postes;
	}
	public Set<Employes> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<Employes> employes) {
		this.employes = employes;
	}
    
    
    
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getNomCabinet() {
		return nomCabinet;
	}
	public void setNomCabinet(String nomCabinet) {
		this.nomCabinet = nomCabinet;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	@Override
	public String toString() {
		return "Formations [idFormation=" + idFormation + ", nom=" + nom + ", duree=" + duree + ", nomCabinet="
				+ nomCabinet + ", commentaire=" + commentaire + ", postes=" + postes + ", employes=" + employes + "]";
	}
	
	
	
	
}
 
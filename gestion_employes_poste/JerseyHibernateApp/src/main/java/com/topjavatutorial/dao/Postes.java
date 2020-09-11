package com.topjavatutorial.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


 
@Entity
public class Postes {
	 @Id
	    @Column(name = "idPoste")
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPoste;
    private String nom;
    private String description;

    @ManyToMany(mappedBy = "postes")
    //private List<Employes> employes = new ArrayList<>();
    //@ManyToMany(mappedBy = "postes")
   // private List<Formations> formations = new ArrayList<>();
    Set<Employes> employes = new HashSet<>();

    
    
	
	
	/*public Postes(String nom, String description, Set<Employes> employes) {
		
		this.nom = nom;
		this.description = description;
		this.employes = employes;
	}*/
	public Postes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Employes> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<Employes> employes) {
		this.employes = employes;
	}
	public int getIdPoste() {
		return idPoste;
	}
	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Postes [idPoste=" + idPoste + ", nom=" + nom + ", description=" + description + ", employes=" + employes
				+ "]";
	}
	
   
}
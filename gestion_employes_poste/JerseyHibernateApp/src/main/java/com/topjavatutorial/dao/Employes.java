package com.topjavatutorial.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.NaturalId;

 
@Entity
public class Employes {
 
    @Id
    @Column(name = "idemploye")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idEmploye;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                },
                mappedBy = "employes")
    @JoinTable(name="Employes_has_poste", joinColumns={@JoinColumn(referencedColumnName="idemploye")}
    , inverseJoinColumns={@JoinColumn(referencedColumnName="idposte")})  

    
  @ManyToMany(mappedBy = "employes")
    Set<Postes> postes = new HashSet<>();
   // @ManyToMany(mappedBy = "employes")
    Set<Postes> formations = new HashSet<>();
   
    

	

	/*public Employes(String nom, String prenom, String adresse, String email, Set<Postes> postes) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.postes = postes;
	}*/



	public Employes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Set<Postes> getPostes() {
		return postes;
	}



	public void setPostes(Set<Postes> postes) {
		this.postes = postes;
	}



	public int getIdEmploye() {
		return idEmploye;
	}
	
	

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Employes [idEmploye=" + idEmploye + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", email=" + email + ", postes=" + postes + "]";
	}

	

	
	
    
    
}
 
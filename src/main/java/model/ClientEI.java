package model;

import java.util.List;

public class ClientEI extends Client{

	private String titrePhysique; //Pourra être transformé en un objet Enum Titre, si du temps
	private String prenom;
	
	
	public ClientEI(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titrePhysique, String prenom, List<Reservation> ListReservation) {
		super(id, nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
		this.titrePhysique = titrePhysique;
		this.prenom = prenom;
	}
	
	public ClientEI(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			String titrePhysique, String prenom) {
		super(id, nom, numeroTel, numeroFax, email, adresse);
		this.titrePhysique = titrePhysique;
		this.prenom = prenom;
	}
	
	public ClientEI(String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titrePhysique, String prenom, List<Reservation> ListReservation) {
		super(nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
		this.titrePhysique = titrePhysique;
		this.prenom = prenom;
	}

	public ClientEI() {
		super();
	}

	public String getTitrePhysique() {
		return titrePhysique;
	}

	public void setTitrePhysique(String titrePhysique) {
		this.titrePhysique = titrePhysique;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	
	

}

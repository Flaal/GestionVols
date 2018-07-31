package model;

import java.util.List;

public class ClientPhysique extends Client{
	private String titrePhysique; //Pourra être transformé en un objet Enum Titre, si du temps
	private String prenom;
	
	
	public ClientPhysique(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titrePhysique, String prenom, List<Reservation> ListReservation) {
		super(id, nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
		this.titrePhysique = titrePhysique;
		this.prenom = prenom;
	}
	
	public ClientPhysique(String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titrePhysique, String prenom, List<Reservation> ListReservation) {
		super(nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
		this.titrePhysique = titrePhysique;
		this.prenom = prenom;
	}

	public ClientPhysique() {
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

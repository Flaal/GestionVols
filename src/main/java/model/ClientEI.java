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

	public String gettitrePhysique() {
		return titrePhysique;
	}

	public void settitrePhysique(String titrePhysique) {
		this.titrePhysique = titrePhysique;
	}

	public String getprenom() {
		return prenom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}

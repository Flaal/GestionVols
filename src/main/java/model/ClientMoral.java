package model;

import java.util.List;

public class ClientMoral extends Client{
	
	private String titreMoral; //Pourra être transformé en un objet Enum Titre, si du temps
	private String siret;
	
	
	public ClientMoral(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titreMoral, String siret, List<Reservation> ListReservation) {
		super(id, nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
		this.titreMoral = titreMoral;
		this.siret = siret;
	}
	
	public ClientMoral(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
		 String titreMoral, String siret) {
		super(id, nom, numeroTel, numeroFax, email, adresse);
		this.titreMoral = titreMoral;
		this.siret = siret;
	}
	
	
	public ClientMoral(String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titreMoral, String siret, List<Reservation> ListReservation) {
		super(nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
		this.titreMoral = titreMoral;
		this.siret = siret;
	}

	public ClientMoral() {
		super();
	}

	public String getTitreMoral() {
		return titreMoral;
	}

	public void setTitreMoral(String titreMoral) {
		this.titreMoral = titreMoral;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	
	

}

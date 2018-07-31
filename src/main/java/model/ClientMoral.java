package model;

import java.util.List;

public class ClientMoral extends Client{
	
	private String titreMoral; //Pourra �tre transform� en un objet Enum Titre, si du temps
	private String siret;
	
	
	public ClientMoral(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login, String titreMoral, String siret, List<Reservation> ListReservation) {
		super(id, nom, numeroTel, numeroFax, email, adresse, login, ListReservation);
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

	public String gettitreMoral() {
		return titreMoral;
	}

	public void settitreMoral(String titreMoral) {
		this.titreMoral = titreMoral;
	}

	public String getsiret() {
		return siret;
	}

	public void setsiret(String siret) {
		this.siret = siret;
	}
	
	

}

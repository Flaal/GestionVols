package model;

public class Passager {

	private Integer id;
	private String nom;
	private String prenom;
	private Adresse adresse;
	
	//constructeurs passager
	
	//vide
	
	public Passager() {
		super();
	}

	//complet
	public Passager(Integer id, String nom, String prenom, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	//sans id
	public Passager(String nom, String prenom, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	//getter setter
	public Integer getIdPassager() {
		return id;
	}
	public void setIdPassager(Integer id) {
		this.id = id;
	}
	public String getNomPassager() {
		return nom;
	}
	public void setNomPassager(String nom) {
		this.nom= nom;
	}
	public String getPrenomPassager() {
		return prenom;
	}
	public void setPrenomPassager(String prenom_passager) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}

package model;

public class Passager {

	private Integer id_passager;
	private String nom_passager;
	private String prenom_passager;
	private Adresse adresse;
	
	//constructeurs passager
	
	//vide
	public Passager() {
	}
	//complet
	public Passager(Integer id_passager, String nom_passager, String prenom_passager, Adresse adresse) {
		super();
		this.id_passager = id_passager;
		this.nom_passager = nom_passager;
		this.prenom_passager = prenom_passager;
		this.adresse = adresse;
	}
	//sans id
	public Passager(String nom_passager, String prenom_passager, Adresse adresse) {
		super();
		this.nom_passager = nom_passager;
		this.prenom_passager = prenom_passager;
		this.adresse = adresse;
	}
	
	//getter setter
	public Integer getId_passager() {
		return id_passager;
	}
	public void setId_passager(Integer id_passager) {
		this.id_passager = id_passager;
	}
	public String getNom_passager() {
		return nom_passager;
	}
	public void setNom_passager(String nom_passager) {
		this.nom_passager = nom_passager;
	}
	public String getPrenom_passager() {
		return prenom_passager;
	}
	public void setPrenom_passager(String prenom_passager) {
		this.prenom_passager = prenom_passager;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}

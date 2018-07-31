package model;

public abstract class Client {
	private Integer id;
	private String nom;
	private String numeroTel;
	private String numeroFax;
	private String email;
	private Adresse adresse;
	private Login login;
	
	
	
	

	
	
	
	/**
	 * @param id
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param adresse
	 * @param login
	 */
	public Client(Integer id, String nom, String numeroTel, String numeroFax, String email, Adresse adresse,
			Login login) {
		super();
		this.id = id;
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
		this.login = login;
	}


	
	
	/**
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param adresse
	 * @param login
	 */
	public Client(String nom, String numeroTel, String numeroFax, String email, Adresse adresse, Login login) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
		this.login = login;
	}




	/**
	 * 
	 */
	public Client() {
		super();
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getNumeroTel() {
		return numeroTel;
	}


	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}


	public String getNumeroFax() {
		return numeroFax;
	}


	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}




	public Login getLogin() {
		return login;
	}




	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
	
	
}

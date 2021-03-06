package model;

public class Login {
	private Integer id;
	private String login;
	private String motDePasse;
	private Boolean admin;
	private Client client;

	public Login() {

	}

	public Login(Integer id, String login, String motDePasse, Boolean admin) {
		this.id = id;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public Login(String login, String motDePasse, Boolean admin) {
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}
	
	public Login(Client client,Integer id, String login, String motDePasse, Boolean admin) {
		this.client=client;
		this.id = id;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



}

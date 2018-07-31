package model;

import java.util.Date;
import java.util.List;

public class Reservation {
	
	private Long id;
	private Date date;
	private Integer numero;
	private Passager passager;
	private Client client;
	
	
	
	public Reservation() {
		super();
	}
	
	public Reservation(Date date, Integer numero) {
		super();
		this.date = date;
		this.numero = numero;
	}

	public Reservation(Long id, Date date, Integer numero) {
		super();
		this.id = id;
		this.date = date;
		this.numero = numero;
	}

	public Reservation(Long id, Date date, Integer numero, model.Passager passager, model.Client client) {
		super();
		this.id = id;
		this.date = date;
		this.numero = numero;
		this.passager = passager;
		this.client = client;
	}



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Passager getPassager() {
		return passager;
	}
	
	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

}

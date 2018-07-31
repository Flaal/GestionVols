package model;

import java.sql.Date;
import java.util.List;

public class Vol {

	private Integer id;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	private List<Reservation> listReservation;

	public Vol() {
		super();
	}

	public Vol(Date dateDepart, Date dateArrivee, Date heureDepdart, Date heureArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepdart;
		this.heureArrivee = heureArrivee;
	}

	public Vol(Integer id, Date dateDepart, Date dateArrivee, Date heureDepdart, Date heureArrivee) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepdart;
		this.heureArrivee = heureArrivee;
	}

	public Vol(Integer id, Date dateDepart, Date dateArrivee, Date heureDepdart, Date heureArrivee,
			List<Reservation> listReservation) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepdart;
		this.heureArrivee = heureArrivee;
		this.listReservation = listReservation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

}

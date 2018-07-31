package model;

import java.util.Date;
import java.util.List;

public class Vol {

	private Long id;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepdart;
	private Date heureArrivee;
	private List<Reservation> listReservation;

	public Vol() {
		super();
	}

	public Vol(Date dateDepart, Date dateArrivee, Date heureDepdart, Date heureArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepdart = heureDepdart;
		this.heureArrivee = heureArrivee;
	}

	public Vol(Long id, Date dateDepart, Date dateArrivee, Date heureDepdart, Date heureArrivee) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepdart = heureDepdart;
		this.heureArrivee = heureArrivee;
	}

	public Vol(Long id, Date dateDepart, Date dateArrivee, Date heureDepdart, Date heureArrivee,
			List<Reservation> listReservation) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepdart = heureDepdart;
		this.heureArrivee = heureArrivee;
		this.listReservation = listReservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getHeureDepdart() {
		return heureDepdart;
	}

	public void setHeureDepdart(Date heureDepdart) {
		this.heureDepdart = heureDepdart;
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

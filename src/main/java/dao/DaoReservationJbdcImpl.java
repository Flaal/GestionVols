package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Context;
import model.Reservation;
import sqlrequest.SQLRequestReservation;

public class DaoReservationJbdcImpl implements DaoReservation{

	@Override
	public List<Reservation> findAll() {
		List<Reservation> reservations = new ArrayList<>();
		SQLRequestReservation requetes = new SQLRequestReservation();
		Context ctx = Context.getInstance();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = ctx.getConnection().createStatement();
			rs = requetes.findAllReservation(st);
		}
		return null;
	}

	@Override
	public Reservation findByKey(Integer key) {
		
		return null;
	}

	@Override
	public void insert(Reservation obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation update(Reservation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reservation obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByKey(Integer key) {
		// TODO Auto-generated method stub
		
	}

}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Closer;
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
			while(rs.next()) {
				reservations.add(new Reservation(rs.getDate("date"), rs.getInt("numero")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return reservations;
	}

	@Override
	public Reservation findByKey(Integer key) {
		Reservation reservation = null;
		SQLRequestReservation requetes = new SQLRequestReservation();
		Context ctx = Context.getInstance();
		Statement st = null;
		ResultSet rs = null;
		try {
			rs = requetes.findReservationByKey(ctx, key);
			st = rs.getStatement();
			if(rs.next()) {
				reservation = new Reservation(rs.getDate("date"), rs.getInt("numero"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return reservation;
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

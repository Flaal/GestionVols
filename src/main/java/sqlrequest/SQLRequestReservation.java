package sqlrequest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.Closer;
import jdbc.util.Context;

public class SQLRequestReservation {
	private final static String FIND_ALL_RESA = "select * from Reservation";
	private final static String FIND_RESA_BY_KEY = "select * from Reservation where id=?";
	private final static String INSERT_RESA = "insert into Reservation(id, date, numero) values(nextval('seq_reservation'),?,?)";
	private final static String UPDATE_RESA = "update Reservation set date=?, numero=? where id=?";
	private final static String DELETE_RESA = "delete from Reservation where id=?";
	
	public ResultSet findAllReservation(Statement st) {
		ResultSet rs = null;
		try {
			rs = st.executeQuery(FIND_ALL_RESA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findReservationByKey(Context ctx, int key) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_RESA_BY_KEY);
			ps.setInt(1, key);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertReservation(Context ctx, Date date, Integer numero) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		int key = -1;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_RESA);
			ps.setDate(1, date);
			ps.setInt(2, numero);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_reservation')");
			if (rs.next()) {
				key = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
			Closer.closeStatement(st);
		}
		return key;
	}

	public int updateReservation(Context ctx, int key, Date date, Integer numero) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(UPDATE_RESA);
			ps.setDate(1, date);
			ps.setInt(2, numero);
			ps.setInt(3, key);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
	}
	
	public int deleteReservation(Context ctx, int key) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(DELETE_RESA);
			ps.setInt(1, key);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
	}
}

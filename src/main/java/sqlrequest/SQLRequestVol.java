package sqlrequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import jdbc.util.Closer;
import jdbc.util.Context;

//Execute les requetes SQL pour la classe vol
public class SQLRequestVol {
	
	private final static String FIND_ALL_VOL = "select * from Vol";
	private final static String FIND_VOL_BY_KEY = "select * from Vol where id=?";
	private final static String INSERT_VOL = "insert into Vol(id, dateDepart, dateArrivee, heureDepart, heureArrivee) values (nextval('seq_Vol'),?,?,?,?";
	private final static String UPDATE_VOL = "update Vol set dateDepart=?, dateArrivee=?, heureDepart=?, heureArrivee=? where id=?";
	private final static String DELETE_VOL = "delete from Vol where id=?";
	

	public ResultSet selectAllVol(Context ctx) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery(FIND_ALL_VOL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectVolByKey(Context ctx, Integer key) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_VOL_BY_KEY);
			ps.setInt(1, key);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertVol(Context ctx, Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee) {
		PreparedStatement ps = null;
		Statement st = null;
		int numeroGenere = -1;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_VOL);
			ps.setDate(1, dateDepart);
			ps.setDate(2, dateArrivee);
			ps.setDate(3, heureDepart);
			ps.setDate(4, heureArrivee);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_Vol')");
			if (rs.next()) {
				numeroGenere = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(st);
			Closer.closeStatement(ps);
		}
		return numeroGenere;
	}

	public int updateVol(Context ctx, Integer id, Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(UPDATE_VOL);
			ps.setDate(1, dateDepart);
			ps.setDate(2, dateArrivee);
			ps.setDate(3, heureDepart);
			ps.setDate(4, heureArrivee);
			ps.setInt(5, id);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}

		return retour;
	}
	
	public int deleteVol(Context ctx, Integer id) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(DELETE_VOL);
			ps.setInt(1, id);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
	}
	
	
}

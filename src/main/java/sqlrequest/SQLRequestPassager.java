package sqlrequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.Closer;
import jdbc.util.Context;

public class SQLRequestPassager {

	private final static String FIND_ALL_PASSAGER = "select * from passager";
	private final static String FIND_PASSAGER_BY_ID = "select * from passager where id=?";
	private final static String INSERT_PASSAGER = "insert into passager(id,nom,prenom,adresse,codePostal,ville,pays) values(nextval('seq_passager'),?,?,?,?,?,?)";
	private final static String UPDATE_PASSAGER = "update passager set nom=?,prenom=?,adresse=?,codePostal=?,ville=?,pays=? where id=?";
	private final static String DELETE_PASSAGER = "delete from passager where num_passager=?";
	

	public ResultSet selectAllPassager(Context ctx) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery(FIND_ALL_PASSAGER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectPassagerById(Context ctx, int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_PASSAGER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int insertPassager(Context ctx, String nom, String prenom, String adresse, String codePostal, String ville, String pays) {
		PreparedStatement ps = null;
		Statement st = null;
		int numeroGenere = -1;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_PASSAGER);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, adresse);
			ps.setString(4, codePostal);
			ps.setString(5, ville);
			ps.setString(6, pays);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_passager')");
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

	public int updatePassager(Context ctx, int id, String nom, String prenom, String adresse, String codePostal, String ville, String pays) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(UPDATE_PASSAGER);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, adresse);
			ps.setString(4, codePostal);
			ps.setString(5, ville);
			ps.setString(6, pays);
			ps.setInt(7, id);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}

		return retour;
	}

	public int deletePassager(Context ctx, int id) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(DELETE_PASSAGER);
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


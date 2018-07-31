package sqlrequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.util.*;

public class SQLRequestClient {

	private final static String FIND_ALL_CLIENT = "select * from client";
	private final static String FIND_CLIENT_BY_KEY = "select * from client where id=?";
	private final static String INSERT_CLIENT_PHYSIQUE = "insert into client(id, nom, email, adresse, codePostal, ville, pays, numeroTel, numeroFax, typeClient, titre, prenom)"
			+ " values (nextval('seq_client'),?,?,?,?,?,?,?,?,'P',?,?)";
	private final static String INSERT_CLIENT_MORAL = "insert into client(id, nom, email, adresse, codePostal, ville, pays, numeroTel, numeroFax, typeClient, titre, siret)"
			+ " values (nextval('seq_client'),?,?,?,?,?,?,?,?,'M',?,?)";
	private final static String INSERT_CLIENT_EI_ = "insert into client(id, nom, email, adresse, codePostal, ville, pays, numeroTel, numeroFax, typeClient, titre, prenom) "
			+ "values (nextval('seq_client'),?,?,?,?,?,?,?,?,'E',?,?)";
	private final static String UPDATE_CLIENT_PHYSIQUE = "update client nom=? , email=? , adresse=? , codePostal=? , ville=? , pays=? , numeroTel=? , numeroFax=? , titre=? , prenom=? where id=?";
	private final static String UPDATE_CLIENT_MORAL = "update client nom=? , email=? , adresse=? , codePostal=? , ville=? , pays=? , numeroTel=? , numeroFax=? ,  titre=? , siret=? where id=?";
	private final static String UPDATE_CLIENT_EI = "update client nom=? , email=? , adresse=? , codePostal=? , ville=? , pays=? , numeroTel=? , numeroFax=? ,  titre=? , prenom=? where id=?";
	private final static String DELETE_CLIENT = "delete from client where id=?";
	private static final String INSERT_CLIENT_EI = null;

	public ResultSet selectAllClient(Context ctx) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery(FIND_ALL_CLIENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectClientByKey(Context ctx, int key) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_CLIENT_BY_KEY);
			ps.setInt(1, key);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertClient(Context ctx, String nom, String email, String adresse, String codePostal, String ville,
			String pays, String numeroTel, String numeroFax, String type, String titre, String denomination) {
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		int numeroGenere = -1;
		try {
			if (type.equals("P")) {
				ps = ctx.getConnection().prepareStatement(INSERT_CLIENT_PHYSIQUE);
				ps.setString(1, nom);
				ps.setString(2, email);
				ps.setString(3, adresse);
				ps.setString(4, codePostal);
				ps.setString(5, ville);
				ps.setString(6, pays);
				ps.setString(7, numeroTel);
				ps.setString(8, numeroFax);
				ps.setString(9, titre);
				ps.setString(10, denomination);
				ps.executeUpdate();
			} else if (type.equals("M")) {
				ps = ctx.getConnection().prepareStatement(INSERT_CLIENT_MORAL);
				ps.setString(1, nom);
				ps.setString(2, email);
				ps.setString(3, adresse);
				ps.setString(4, codePostal);
				ps.setString(5, ville);
				ps.setString(6, pays);
				ps.setString(7, numeroTel);
				ps.setString(8, numeroFax);
				ps.setString(9, titre);
				ps.setString(10, denomination);
				ps.executeUpdate();
			} else if (type.equals("E")) {
				ps = ctx.getConnection().prepareStatement(INSERT_CLIENT_EI);
				ps.setString(1, nom);
				ps.setString(2, email);
				ps.setString(3, adresse);
				ps.setString(4, codePostal);
				ps.setString(5, ville);
				ps.setString(6, pays);
				ps.setString(7, numeroTel);
				ps.setString(8, numeroFax);
				ps.setString(9, titre);
				ps.setString(10, denomination);
				ps.executeUpdate();
			}
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_client')");
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

	public int update(Context ctx, int id, String nom, String email, String adresse, String codePostal, String ville,
			String pays, String numeroTel, String numeroFax, String type, String titre, String denomination) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			if (type.equals("P")) {
				ps = ctx.getConnection().prepareStatement(UPDATE_CLIENT_PHYSIQUE);
				ps.setString(1, nom);
				ps.setString(2, email);
				ps.setString(3, adresse);
				ps.setString(4, codePostal);
				ps.setString(5, ville);
				ps.setString(6, pays);
				ps.setString(7, numeroTel);
				ps.setString(8, numeroFax);
				ps.setString(9, titre);
				ps.setString(10, denomination);
				ps.setInt(11, id);
				retour = ps.executeUpdate();
			} else if (type.equals("M")) {
				ps = ctx.getConnection().prepareStatement(UPDATE_CLIENT_MORAL);
				ps.setString(1, nom);
				ps.setString(2, email);
				ps.setString(3, adresse);
				ps.setString(4, codePostal);
				ps.setString(5, ville);
				ps.setString(6, pays);
				ps.setString(7, numeroTel);
				ps.setString(8, numeroFax);
				ps.setString(9, titre);
				ps.setString(10, denomination);
				ps.setInt(11, id);
				retour = ps.executeUpdate();
			} else if (type.equals("P")) {
				ps = ctx.getConnection().prepareStatement(UPDATE_CLIENT_EI);
				ps.setString(1, nom);
				ps.setString(2, email);
				ps.setString(3, adresse);
				ps.setString(4, codePostal);
				ps.setString(5, ville);
				ps.setString(6, pays);
				ps.setString(7, numeroTel);
				ps.setString(8, numeroFax);
				ps.setString(9, titre);
				ps.setString(10, denomination);
				ps.setInt(11, id);
				retour = ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
	}
	
	public int delete(Context ctx, int id) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(DELETE_CLIENT);
			ps.setInt(1, id);
			retour = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
}
}

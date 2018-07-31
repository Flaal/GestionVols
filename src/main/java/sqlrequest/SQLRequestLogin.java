package sqlrequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.Closer;
import jdbc.util.Context;

public class SQLRequestLogin {
	
	private final static String FIND_ALL_LOGIN = "select * from Login";
	private final static String FIND_LOGIN_BY_KEY = "select * from Login where id=?";
	private final static String INSERT_LOGIN = "insert into login(id, login, motDePasse, admin) values (nextval('seq_login'),?, ?, ?)";
	private final static String UPDATE_LOGIN = "update login set login=?, motDePasse=?, admin=?) where id=?";
	private final static String DELETE_LOGIN = "delete from login where id=?";
	
	public ResultSet selectAllLogin (Context ctx) {
		ResultSet rs= null;
		Statement st;
		try {
			st = ctx.getConnection().createStatement();
			rs= st.executeQuery(FIND_ALL_LOGIN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectLoginByKey(Context ctx, int key) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(FIND_LOGIN_BY_KEY);
			ps.setInt(1, key);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insertLogin(Context ctx, String login, String motDePasse, Boolean admin) {
		PreparedStatement ps = null;
		Statement st = null;
		int numeroGenere = -1;
		ResultSet rs = null;
		try {
			ps = ctx.getConnection().prepareStatement(INSERT_LOGIN);
			ps.setString(1, login);
			ps.setString(2, motDePasse);
			ps.setBoolean(3, admin);
			ps.executeUpdate();
			st = ctx.getConnection().createStatement();
			rs = st.executeQuery("select currval('seq_login')");
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
	
	public int updateLogin(Context ctx, Integer id, String login, String motDePasse, Boolean admin) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(UPDATE_LOGIN);
			ps.setInt(1, id);
			ps.setString(2, login);
			ps.setString(3, motDePasse);
			ps.setBoolean(4, admin);
			retour = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeStatement(ps);
		}
		return retour;
	}
	
	public int deleteLogin(Context ctx, int id) {
		int retour = 0;
		PreparedStatement ps = null;
		try {
			ps = ctx.getConnection().prepareStatement(DELETE_LOGIN);
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

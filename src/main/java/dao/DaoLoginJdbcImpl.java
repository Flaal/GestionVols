package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Closer;
import jdbc.util.Context;
import model.Login;
import sqlrequest.SQLRequestLogin;





class DaoLoginJdbcImpl implements DaoLogin{

	@Override
	public List<Login> findAll() {
		
		List<Login> login = new ArrayList<>();
		SQLRequestLogin requetes = new SQLRequestLogin();
		ResultSet rs = requetes.selectAllLogin(Context.getInstance());
		Statement st = null;
		try {
			st = rs.getStatement();
			while (rs.next()) {
				login.add(new Login(rs.getInt("id"), rs.getString("login"), rs.getString("motDePasse"),
						rs.getBoolean("admin")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return login;
	}



	@Override
	public Login findByKey(Integer key) {

		Login login = null;
		SQLRequestLogin requetes = new SQLRequestLogin();
		ResultSet rs = requetes.selectLoginByKey(Context.getInstance(), key);
		Statement st = null;
		try {
			st = rs.getStatement();
			if (rs.next()) {
				login = new Login(rs.getInt("id"), rs.getString("login"), rs.getString("motDePasse"),
						rs.getBoolean("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return login;	
	}

	@Override
	public void insert(Login obj) {

		SQLRequestLogin requetes = new SQLRequestLogin();
		obj.setId(requetes.insertLogin(Context.getInstance(), obj.getLogin(),
				obj.getMotDePasse(), obj.getAdmin()));
	}

	@Override
	public Login update(Login obj) {
	
		SQLRequestLogin requetes = new SQLRequestLogin();
		requetes.updateLogin(Context.getInstance(), obj.getId(), obj.getLogin(),
				obj.getMotDePasse(), obj.getAdmin());
		return obj;

	}

	@Override
	public void delete(Login obj) {

		SQLRequestLogin requetes = new SQLRequestLogin();
		try {
			requetes.deleteLogin(Context.getInstance(), obj.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {

        SQLRequestLogin requetes = new SQLRequestLogin();
        try {
            requetes.deleteLogin(Context.getInstance(), key);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	

}

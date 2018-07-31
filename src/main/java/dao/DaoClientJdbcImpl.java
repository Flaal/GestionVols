package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;
import sqlrequest.SQLRequestClient;
import jdbc.util.*;

class DaoClientJdbcImpl implements DaoClient {

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		SQLRequestClient requetes = new SQLRequestClient();
		ResultSet rs = requetes.selectAllClient(Context.getInstance());
		Statement st = null;
		try {
			st = rs.getStatement();
			while (rs.next()) {
				if (rs.getString("typeClient").equals("P")) {
					clients.add(new ClientPhysique(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroTel"),
							rs.getString("numeroFax"), rs.getString("email"), new Adresse(rs.getString("adresse"),
									rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")),
							rs.getString("titre"), rs.getString("prenom")));
				} else if (rs.getString("typeClient").equals("M")) {
					clients.add(new ClientMoral(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroTel"),
							rs.getString("numeroFax"), rs.getString("email"), new Adresse(rs.getString("adresse"),
									rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")),
							rs.getString("titre"), rs.getString("siret")));
				} else if (rs.getString("typeClient").equals("E")) {
					clients.add(new ClientEI(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroTel"),
							rs.getString("numeroFax"), rs.getString("email"), new Adresse(rs.getString("adresse"),
									rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")),
							rs.getString("titre"), rs.getString("prenom")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return clients;
	}

	@Override
	public Client findByKey(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client update(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByKey(Integer key) {
		// TODO Auto-generated method stub

	}

}

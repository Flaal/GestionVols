package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.SQLRequest;
import model.*;
import sqlrequest.SQLRequestClient;
import jdbc.Closer;
import jdbc.Context;
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
		SQLRequestClient requetes = new SQLRequestClient();
		ResultSet rs = requetes.selectClientByKey(Context.getInstance(), key);
		Statement st = null;
		Client clienta=null;
		try {
			st = rs.getStatement();
			if (rs.next()) {
				if (rs.getString("typeClient").equals("P")) {
					ClientPhysique client=null;
					client = new ClientPhysique(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroTel"),
							rs.getString("numeroFax"), rs.getString("email"), new Adresse(rs.getString("adresse"),
									rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")),
							rs.getString("titre"), rs.getString("prenom"));
					clienta=client;
				} else if (rs.getString("typeClient").equals("M")) {
					ClientMoral client=null;
					new ClientMoral(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroTel"),
							rs.getString("numeroFax"), rs.getString("email"), new Adresse(rs.getString("adresse"),
									rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")),
							rs.getString("titre"), rs.getString("siret"));
					clienta=client;

				} else if (rs.getString("typeClient").equals("E")) {
					ClientEI client=null;
					client = new ClientEI(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroTel"),
							rs.getString("numeroFax"), rs.getString("email"), new Adresse(rs.getString("adresse"),
									rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")),
							rs.getString("titre"), rs.getString("prenom"));
					clienta=client;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return clienta;
	}
	

	@Override
	public void insert(Client obj) {
		SQLRequestClient requetes = new SQLRequestClient();
		try {
			String t;
			if (obj instanceof ClientPhysique) {t="P";
			int numeroGenere = requetes.insertClient(Context.getInstance(), obj.getNom(), obj.getEmail(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays(), obj.getNumeroTel(), obj.getNumeroFax(),
					t, ((ClientPhysique)obj).getTitrePhysique(), ((ClientPhysique)obj).getPrenom());
			obj.setId(numeroGenere);
			}
			else if (obj instanceof ClientMoral) {t="M";
			int numeroGenere = requetes.insertClient(Context.getInstance(), obj.getNom(), obj.getEmail(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays(), obj.getNumeroTel(), obj.getNumeroFax(),
					t, ((ClientMoral)obj).getTitreMoral(), ((ClientMoral)obj).getSiret());
			obj.setId(numeroGenere);
			}
			else if (obj instanceof ClientEI) {t="E";
			int numeroGenere = requetes.insertClient(Context.getInstance(), obj.getNom(), obj.getEmail(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays(), obj.getNumeroTel(), obj.getNumeroFax(),
					t, ((ClientEI)obj).getTitrePhysique(), ((ClientEI)obj).getPrenom());
			obj.setId(numeroGenere);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Client update(Client obj) {
		SQLRequestClient requetes = new SQLRequestClient();
		try {
			String t;
			if (obj instanceof ClientPhysique) {t="P";
			int numeroGenere = requetes.update(Context.getInstance(), obj.getId(), obj.getNom(), obj.getEmail(),
					obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(),
					obj.getAdresse().getPays(), obj.getNumeroTel(), obj.getNumeroFax(), t, ((ClientPhysique)obj).getTitrePhysique(), ((ClientPhysique)obj).getPrenom());
			obj.setId(numeroGenere);
			}
			else if (obj instanceof ClientMoral) {t="M";
			int numeroGenere = requetes.update(Context.getInstance(), obj.getId(), obj.getNom(), obj.getEmail(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays(), obj.getNumeroTel(), obj.getNumeroFax(),
					t, ((ClientMoral)obj).getTitreMoral(), ((ClientMoral)obj).getSiret());
			obj.setId(numeroGenere);
			}
			else if (obj instanceof ClientEI) {t="E";
			int numeroGenere = requetes.update(Context.getInstance(), obj.getId(), obj.getNom(), obj.getEmail(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays(), obj.getNumeroTel(), obj.getNumeroFax(),
					t, ((ClientEI)obj).getTitrePhysique(), ((ClientEI)obj).getPrenom());
			obj.setId(numeroGenere);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
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

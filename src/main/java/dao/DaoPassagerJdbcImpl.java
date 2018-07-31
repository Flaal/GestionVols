package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Closer;
import jdbc.util.Context;
import model.Adresse;
import model.Passager;
import sqlrequest.SQLRequestPassager;


class DaoPassagerJdbcImpl implements DaoPassager {

		@Override
		public List<Passager> findAll() {
			List<Passager> passagers = new ArrayList<>();
			SQLRequestPassager requetes = new SQLRequestPassager();
			ResultSet rs = requetes.selectAllPassager(Context.getInstance());
			Statement st = null;
			try {
				st = rs.getStatement();
				while (rs.next()) {
					passagers.add(new Passager(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), new Adresse(rs.getString("adresse"), rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays"))));
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Closer.closeResultSet(rs);
				Closer.closeStatement(st);
			}
			return passagers;
		}

		@Override
		public Passager findByKey(Integer id) {
			Passager passager = null;
			SQLRequestPassager requetes = new SQLRequestPassager();
			ResultSet rs = requetes.selectPassagerById(Context.getInstance(), id);
			Statement st = null;
			try {
				st = rs.getStatement();
				if (rs.next()) {
					passager = new Passager(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), new Adresse(rs.getString("adresse"), rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Closer.closeResultSet(rs);
				Closer.closeStatement(st);
			}
			return passager;
		}

		@Override
		public void insert(Passager obj) {
			SQLRequestPassager requetes = new SQLRequestPassager();
			obj.setId(requetes.insertPassager(Context.getInstance(), obj.getNom(), obj.getPrenom(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays()));
		}

		@Override
		public Passager update(Passager obj) {
			SQLRequestPassager requetes = new SQLRequestPassager();
			requetes.updatePassager(Context.getInstance(), obj.getId(), obj.getNom(), obj.getPrenom(), obj.getAdresse().getAdresse(), obj.getAdresse().getCodePostal(), obj.getAdresse().getVille(), obj.getAdresse().getPays());
			return obj;
		}

		@Override
		public void delete(Passager obj) {
			deleteByKey(obj.getId());
		}

		@Override
		public void deleteByKey(Integer key) {
			SQLRequestPassager requetes = new SQLRequestPassager();
			requetes.deletePassager(Context.getInstance(), key);
		}


}

package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Closer;
import jdbc.util.Context;
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
					passagers.add(new Passager(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Closer.closeResultSet(rs);
				Closer.closeStatement(st);
			}
			return adherents;
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
					adherent = new Adherent(rs.getInt("num_adherent"), rs.getString("prenom"), rs.getString("nom"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Closer.closeResultSet(rs);
				Closer.closeStatement(st);
			}
			return adherent;
		}

		@Override
		public void insert(Passager obj) {
			SQLRequestPassager requetes = new SQLRequestPassager();
			obj.setNumeroPassager(requetes.insertPassager(Context.getInstance(), obj.getPrenom(), obj.getNom()));
		}

		@Override
		public Adherent update(Adherent obj) {
			SQLRequest requetes = new SQLRequest();
			requetes.updateAdherent(Context.getInstance(), obj.getNumeroAdherent(), obj.getPrenom(), obj.getNom());
			return obj;
		}

		@Override
		public void delete(Adherent obj) {
			deleteByKey(obj.getNumeroAdherent());
		}

		@Override
		public void deleteByKey(Integer key) {
			SQLRequest requetes = new SQLRequest();
			requetes.deleteAdherent(Context.getInstance(), key);
		}

		@Override
		public Passager findByKey(Integer key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void insert(Passager obj) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Passager update(Passager obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(Passager obj) {
			// TODO Auto-generated method stub
			
		}

	}

}

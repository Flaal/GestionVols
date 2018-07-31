package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.Closer;
import jdbc.util.Context;
import model.Vol;
import sqlrequest.SQLRequestVol;

public class DaoVolJbdcImpl implements DaoVol {

	@Override
	public List<Vol> findAll() {
		List<Vol> vol = new ArrayList<>();
		SQLRequestVol requetes = new SQLRequestVol();
		ResultSet rs = requetes.selectAllVol(Context.getInstance());
		Statement st = null;
		try {
			st = rs.getStatement();
			while (rs.next()) {
				vol.add(new Vol(rs.getInt("id"), rs.getDate("dateDepart"), rs.getDate("dateArrivee"),
						rs.getDate("heureDepart"), rs.getDate("heureArrivee")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return vol;
	}

	@Override
	public Vol findByKey(Integer key) {
		Vol vol = null;
		SQLRequestVol requetes = new SQLRequestVol();
		ResultSet rs = requetes.selectVolByKey(Context.getInstance(), key);
		Statement st = null;
		try {
			st = rs.getStatement();
			if (rs.next()) {
				vol = new Vol(rs.getInt("id"), rs.getDate("dateDepart"), rs.getDate("dateArrivee"),
						rs.getDate("heureDepart"), rs.getDate("heureArrivee"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closer.closeResultSet(rs);
			Closer.closeStatement(st);
		}
		return vol;
	}

	@Override
	public void insert(Vol obj) {
		SQLRequestVol requetes = new SQLRequestVol();
		obj.setId(requetes.insertVol(Context.getInstance(), obj.getDateDepart(), obj.getDateArrivee(),
				obj.getHeureDepart(), obj.getHeureArrivee()));
	}

	@Override
	public Vol update(Vol obj) {
		SQLRequestVol requetes = new SQLRequestVol();
		requetes.updateVol(Context.getInstance(), obj.getId(), obj.getDateDepart(), obj.getDateArrivee(),
				obj.getHeureDepart(), obj.getHeureArrivee());
		return obj;
	}

	public void delete(Vol obj) {
		SQLRequestVol requetes = new SQLRequestVol();
		try {
			requetes.deleteVol(Context.getInstance(), obj.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
    public void deleteByKey(Integer key) {
        SQLRequestVol requetes = new SQLRequestVol();
        try {
            requetes.deleteVol(Context.getInstance(), key);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

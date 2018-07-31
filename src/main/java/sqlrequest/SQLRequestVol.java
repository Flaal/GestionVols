package sqlrequest;

//Execute les requetes SQL pour la classe vol
class SQLRequestVol {
	
	private final static String FIND_ALL_VOL = "select * from vol";
	private final static String FIND_VOL_BY_KEY = "select * from vol where id=?";
	private final static String INSERT_VOL = "insert into vol(id, dateDepart, dateArrivee, heureDepart, heureArrivee) values (nextval('seq_vol'),?,?,?,?";
	private final static String UPDATE_VOL = "update vol set dateDepart=?, dateArrivee=?, heureDepart=?, heureArrivee=? where id=?";
	private final static 
}

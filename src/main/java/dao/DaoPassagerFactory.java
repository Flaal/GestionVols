package dao;

public class DaoPassagerFactory {

	private DaoPassagerFactory() {

	}

	public static DaoPassager getInstance() {
		return new DaoPassagerJdbcImpl();
	}
}

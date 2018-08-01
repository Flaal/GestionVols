package dao;

public class DaoClientFactory {
	private DaoClientFactory() {
		// fait saut� le constructeur par d�faut
	}

	public static DaoClient getInstance() {
		return new DaoClientJdbcImpl();
	}
}

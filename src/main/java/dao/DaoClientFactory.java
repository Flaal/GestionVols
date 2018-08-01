package dao;

public class DaoClientFactory {
	private DaoClientFactory() {
		// fait sauté le constructeur par défaut
	}

	public static DaoClient getInstance() {
		return new DaoClientJdbcImpl();
	}
}

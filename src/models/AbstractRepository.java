package models;

import librairies.MysqlDriver;

public abstract class AbstractRepository {

	protected MysqlDriver driver;
	protected java.sql.Connection connexion;
	protected String table_name;
	
	public AbstractRepository(String table_name) {
		this.table_name = table_name;		
		
		try {
			this.driver = MysqlDriver.getDriver();
			this.connexion = driver.getConnector();
		} catch (Exception e){
			this.driver.disconnect();
			
			System.err.println("Internal error");
		}
	}

}

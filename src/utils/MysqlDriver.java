package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDriver {

    private String server, user, password, database;
    static MysqlDriver driver;
    Connection connector;
    
    public Connection getConnector() {
        return connector;
    }
   
    public MysqlDriver(String server, String user, String password, String database)
    {
        this.server = server;
        this.user = user;
        this.password = password;
        this.database = database;
        
        init();
    }
    
    private MysqlDriver()
    {	    
        this.server = "37.187.111.99";
        this.user = "java";
        this.password = "admin";
        this.database = "school_doodle";
        
        init();
    }
    
    private void connect()
    {
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    	} catch (InstantiationException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (IllegalAccessException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
     void init ()
    {
        // Ouverture d'une connexion au serveur Mysql
        this.connect();
        
        String url = "jdbc:mysql://"+this.server +"/"+this.database;
        
        try{
        	this.connector = DriverManager.getConnection(url, this.user, this.password);
        }
        catch (SQLException exp) {
            System.err.println("Erreur de connexion au serveur " + exp);
        }
    }
     
    public void disconnect()
    {
        if (this.connector != null)
        {
            try{
                this.connector.close();
            }
            catch (SQLException exp){
                System.out.println("Erreur lors de la fermeture de la connexion");
            }
        }
    }
    
    public static MysqlDriver getDriver()
    {
        if(driver==null)
        {
        	driver = new MysqlDriver("localhost", "root", "root", "school_doodle");
            // driver = new MysqlDriver();
        }
        
        return driver;
    }
   

}
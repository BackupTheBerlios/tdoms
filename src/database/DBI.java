import java.sql.*;

/**
 *La DBI (Data Base Interface) est la classe de gestion de la base de données contenant
 *l'ensemble des utilisateurs pouvant accéder à la gestion des Unités :
 * les enseignants et l'administrateur.
 */
public class DBI{
    
    private Connection connect;
    private String dbName;
    private String dbLogin;
    private String dbPasswd;
    private String dbHostName;
    private int dbPort;
    
    /**
     * The DBI constructor.
     * @param host, @param port, @param name, @param login, @param passwd: The attribute of the database.
     */
    public DBI(String host, int port, String name, String login, String passwd){

	this.dbName = name;
	this.dbLogin = login;
	this.dbPasswd = passwd;
	this.dbHostName = host;
	this.dbPort = port;
    }
    /**
     * Returns the name of the database.
     * @return String.
     */
    public String getDBName(){
	return dbName;
    }
    
    /**
     * Returns the login of the owner of the database.
     * @return String.
     */
    public String getDBLogin(){
	return dbLogin;
    }

    /**
     * Returns the password of the owner of the database.
     * @return String.
     */
    public String getDBPasswd(){
	return dbPasswd;
    }
    
    /**
     * Returns the name of the server host of the database.
     * @return String.
     */
    public String getDBHostName(){
	return dbHostName;
    }
    
     /**
     * Returns the port of the server host of the database.
     * @return int.
     */
    public int getDBPort(){
	return dbPort;
    }

    /**
     * Set the name of the database.
     * @param name.
     */
    public void setDBName(String name){
	this.dbName = name;
    }
    
    /**
     * Set the login of the owner of the database.
     * @param login.
     */
    public void setDBLogin(String login){
	this.dbLogin = login;
    }
    
    /**
     * Set the password of the owner of the database.
     * @param passwd.
     */
    public void setDBPasswd(String passwd){
	this.dbPasswd = passwd;
    }

    /**
     * Set the name of the server host of the database.
     * @param name.
     */
    public void setDBHostName(String hostname){
	this.dbHostName = hostname;
    }
    
    /**
     * Set the port of the server host of the database.
     * @param port.
     */
    public void setDBPort(int port){
	this.dbPort = port;
    }
    
    /**
     * Establish the connection to the database
     */
    public void establishConnection(){

	/**
	 *On construit l'url de la base de donnée avec la syntaxe suivante:
	 * Syntaxe: jdbc:TYPE:HOTE:PORT/DB_NAME/
	 */
	String url = "jdbc:postgresql://"+dbHostName+":"+dbPort+"/"+dbName+"/";

	//Chargement du driver !!
	try{
	    Class.forName("org.postgresql.Driver");
	}catch(Exception e){ System.err.println("Erreur de chargement du driver!!");}

	//Connection a la BDD
	try{
	    connect = DriverManager.getConnection(url,dbLogin,dbPasswd);
	    System.out.println("Connection établie");	    
	}catch(SQLException e){ System.out.println("La connection ne passe pas");}
    }


    public boolean reqSimple(String query){
	boolean res = false;
	try{
	    Statement stmt = connect.createStatement();
	    res = stmt.execute(query);
	    stmt.close();
	}catch(SQLException e){ System.out.println("Erreur lors de l'execution de la requête: "+query);}
	return res;
    }
    
    /**
     * Execution of a query which modify the database but doens't return anything.
     * It could be a query like CREATE, INSERT, UPDATE, ALTER...
     * @param query: The query to be executed.
     */
    public void reqUpdate(String query){
	try{
	    Statement stmt = connect.createStatement();
	    stmt.executeUpdate(query); 
	    stmt.close();
	}catch(SQLException e){ System.out.println("Erreur lors de l'execution de la requête: "+query);}
    }

    /**
     * Execution of a query to get some lines from the database but doens't modify it.
     * This metod would be most used for queries like SELECT...
     * @param query: The query to be executed.
     * @return a ResultSet containning the lines or null.
     */
    public ResultSet reqQuery(String query){
	ResultSet res = null;
	try{
	    Statement stmt = connect.createStatement();
	    res = stmt.executeQuery(query); 
	    stmt.close();
	}catch(SQLException e){ System.out.println("Erreur lors de l'execution de la requête: "+query);}
	return res;
    }
    
    /**
     * Close the connection to the database.
     */
    public void disconnect(){
	try{
	    connect.close();
	}catch(SQLException e){ e.printStackTrace();System.out.println("La connection ne s'est pas fermée");}
    }
    
    public void createTable(){
	try{
	    Statement stmt = connect.createStatement();
	    stmt.executeUpdate( "CREATE TABLE ACCOUNT ("  +
				"name        VARCHAR (20) NOT NULL, "    +
				"login       VARCHAR (10)  NOT NULL, "    +
				"passwd      VARCHAR (10) NOT NULL,"     +
				"rights      INTEGER      NOT NULL, "    +
				"PRIMARY KEY ( login )"                  +
				")" );
	}catch(SQLException e){ e.printStackTrace();System.out.println("La connection ne passe pas");}
    }

    /*
    public static void main(String [] args) throws Exception{
	
	DBI toto = new DBI("sqletud.univ-mlv.fr",5432,"rtchuitc","rtchuitc","papa");
	toto.establishConnection();
	ResultSet result = toto.reqQuery("SELECT * FROM client");

	while(result.next()){
	    System.out.println(result.getString("nom")+" "+result.getString("prenom")+" "+
			       result.getInt("age"));
	}
	toto.disconnect();
    }
    */
}


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
    
    public DBI(String host, int port, String name, String login, String passwd){

	this.dbName = name;
	this.dbLogin = login;
	this.dbPasswd = passwd;
	this.dbHostName = host;
	this.dbPort = port;
    }

    public String getDBName(){
	return dbName;
    }

    public String getDBLogin(){
	return dbLogin;
    }

    public String getDBPasswd(){
	return dbPasswd;
    }

    public String getDBHostName(){
	return dbHostName;
    }

    public void setDBName(String name){
	this.dbName = name;
    }

    public void setDBLogin(String login){
	this.dbLogin = login;
    }

    public void setDBPasswd(String passwd){
	this.dbPasswd = passwd;
    }

    public void setDBHostName(String hostname){
	this.dbHostName = hostname;
    }

    /**
     *Connection à la base de donnée 
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

    /**
     * Execution d'une requête qui modifie la BDD mais qui ne retourne rien.
     * Il s'agit de requête du genre CREATE, INSERT, UPDATE, ALTER...
     */
    public void reqUpdate(String query){
	try{
	    Statement stmt = connect.createStatement();
	    stmt.executeUpdate(query); 
	}catch(SQLException e){ System.out.println("Erreur lors de l'execution de la requête: "+query);}
    }

    /**
     * Execution d'une requête qui récupere des tuples dans la BDD mais qui
     * ne la modifie pas. Notamment pour un SELECT...
     */
    public ResultSet reqQuery(String query){
	ResultSet res = null;
	try{
	    Statement stmt = connect.createStatement();
	    res = stmt.executeQuery(query); 
	}catch(SQLException e){ System.out.println("Erreur lors de l'execution de la requête: "+query);}
	return res;
    }
    
    public void disconnect(){
	try{
	    connect.close();
	}catch(SQLException e){ e.printStackTrace();System.out.println("La connection ne passe pas");}
    }

    public void create(){
	try{
	    Statement stmt = connect.createStatement();
	    String createString = "create table COFFEES " +
		"(COF_NAME VARCHAR(32), " +
		"SUP_ID INTEGER, " +
		"PRICE FLOAT, " +
		"SALES INTEGER, " +
		"TOTAL INTEGER)";
	    stmt.executeUpdate(createString); 
	}catch(SQLException e){ e.printStackTrace();System.out.println("La connection ne passe pas");}
    }

    
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
}


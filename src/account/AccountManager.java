import java.sql.*;

/**
 * This class will manage the account of the users in the table nammed "ACCOUNT"
 */
public class AccountManager{

    /* The data base handler */
    private DBI dbh;
    /* The  name of the table */
    private String acctable;

    public AccountManager(DBI dbh, String table){
	this.dbh = dbh;
	this.acctable = table;
    }

    /**
     * Add a new account in the table 
     * @param name: The name of the user,
     * @param login: The login of the user,
     * @param passwd: The password of the user,
     * @param rights: The rights of the user.
     * @return false if the execution didn't succeed or if there's already an account with that login, true otherwise.
     */
    public boolean addNewAccount(String name, String login, String passwd, int rights){
	
	dbh.establishConnection();
	
	String tmp = "SELECT * FROM "+acctable+" WHERE login='"+login+"';";
	System.out.println("Requete --> "+tmp);
	if(!dbh.reqSimple(tmp)){
	    System.out.println("An entry with the login ->"+login+"<- already exist in the database");
	    dbh.disconnect();
	    return false;
	}
	
	String query = "INSERT INTO "+acctable+" VALUES ('"+name+"','"+login+"','"+passwd+"',"+rights+");";
	dbh.reqUpdate(query);
	dbh.disconnect();
	return true;
    }

    /**
     * Delete the account of the user with the specified login in the table.
     * @param login: The login of the user.
     */
    public void deleteAccount(String login){
	String query = "DELETE FROM "+acctable+" WHERE (login='"+login+"');";
	dbh.establishConnection();
	dbh.reqUpdate(query);
	dbh.disconnect();
    }

    /**
     * Update the password of an user.
     * @param login: The login of the user,
     * @param oldpasswd: His old password,
     * @param newpasswd: His new password.
     */
    public void updateAccount(String login, String oldpasswd, String newpasswd){
	String query = "UPDATE "+acctable+" SET passwd = '"+newpasswd+"'WHERE (login='"+login+"' AND passwd='"+
	    oldpasswd+"');";
	dbh.establishConnection();
	dbh.reqUpdate(query);
	dbh.disconnect();
    }
}

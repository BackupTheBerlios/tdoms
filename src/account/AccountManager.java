package account;

import java.sql.*;
import java.util.*;
import database;

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
     * @param email: The email address of the user.
     * @return false if the execution didn't succeed or if there's already an account with that login, true otherwise.
     */
    public boolean addNewAccount(String name, String login, String passwd, String email){

	dbh.establishConnection();
	
	String tmp = "SELECT * FROM "+acctable+" WHERE login='"+login.trim()+"';";
	System.out.println("Requete --> "+tmp);
	if(!dbh.reqSimple(tmp)){
	    System.out.println("An entry with the login ->"+login.trim()+"<- already exist in the database");
	    dbh.disconnect();
	    return false;
	}
	
	String query = "INSERT INTO "+acctable+" VALUES ('"+name.trim()+"','"+login.trim()+"','"+passwd.trim()+"','"+email.trim()+"');";
	dbh.reqUpdate(query);
	dbh.disconnect();
	return true;
    }

    /**
     * Delete the account of the user with the specified login in the table.
     * @param login: The login of the user.
     */
    public void deleteAccount(String login){
	String query = "DELETE FROM "+acctable+" WHERE (login='"+login.trim()+"');";
	dbh.establishConnection();
	dbh.reqUpdate(query);
	dbh.disconnect();
    }

    /**
     * Update the password and the email address of an user.
     * @param login: The login of the user,
     * @param newemail: His new email address,
     * @param newpasswd: His new password.
     */
    public void updateAccount(String login, String newpasswd, String newemail){
	String query = "UPDATE "+acctable+" SET passwd = '"+newpasswd.trim()+"',email = '"+newemail.trim()+
	    "' WHERE (login='"+login.trim()+"');";
	dbh.establishConnection();
	dbh.reqUpdate(query);
	dbh.disconnect();
    }

    /**
     * Check the login and the passwd of the user in the database, and return his name
     * if everything's ok, return NULL otherwise
     * @param login: The login of the user,
     * @param passwd: The password of the user
     * @return the name of the user, NULL otherwise.
     */
    public String checkLogon(String login, String passwd){
	String query = "SELECT * FROM " +acctable+ " WHERE login='"+login.trim()+"';";
	dbh.establishConnection();
	HashMap res = dbh.reqQuery(query);
	dbh.disconnect();

	if (res == null)
	    return false;
	String real_passwd = null;
	real_passwd = (String) res.get("passwd");
	if(real_passwd.equals(passwd.trim()))
	    return (String) res.get("name").trim();
	return null;
    }
}

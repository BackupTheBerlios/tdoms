package account;

import java.sql.*;
import database.DBI;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LogSession{
    
    private String login;
    private String password;

    
    public String getLogin(){
	return login;
    }

    public void setLogin(String login){
	this.login=login;
	//affichePourTests("ICI9 login -->"+login);
    }

    public String getPassword(){
	return password;
    }
    
    public void setPassword(String password){
	this.password = password;
    }

    /*
     * pour les tests      
     */
    private void affichePourTests(String message)
    {
	try{
	    BufferedWriter file = new BufferedWriter(new FileWriter("/home/main01/rtchuitc/tdoms_test"));
	    file.write(message);
	    file.close();
	}catch(IOException ioe){ ioe.printStackTrace(); }
    } 
    
    public boolean getAuthorisation(){
	boolean res = false;
	
	String log = getLogin();
	String pass = getPassword();

	affichePourTests("ICI2 login -->"+log+"<-- pass -->"+pass);
	
	DBI dbh = new DBI("sqletud.univ-mlv.fr",5432,"rtchuitc","rtchuitc","papa");
	AccountManager am = new AccountManager(dbh,"account_tdoms");
	
	
	//System.out.println("----> ICI 1");
	
	try{
	    res = am.checkLogon(log,pass);
	    affichePourTests("ICI89 login -->"+log+"<-- pass -->"+pass);
	}catch(SQLException e){ e.printStackTrace(); }
	
      
	return res;
    }
}

package account;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBI;
import utils.Mailer;
import java.net.InetAddress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

/**
 * This class manages the subscription of a user. It is called by Struts
 * after that the user has validated the subscription form contained in
 * teacher/subscribe.jsp.
 * If the user is allowed to subscribe, a temporary file is created. He will
 * then receive a mail which tells him to visit that file. He will have to visit
 * that page to confirm subscription.
 */
public class SubscribeAction extends Action
{
    private String appliPath;
    private static int PORT=8080;
    
    private final static char [] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
					    'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
					    's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
					    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
					    'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
					    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /*
     * pour les tests       
     */
    private void affichePourTests(String message)
    {
	try{
	    BufferedWriter file = new BufferedWriter(new FileWriter(this.appliPath+"tdoms_test"));
	    file.write(message);
	    file.close();
	}catch(IOException ioe)
	    { ioe.printStackTrace(); }
    }
    
    
    private void initApplicationPath()
    {
	this.appliPath =
	    "/home/main01/mbriend/genie_logiciel/jakarta-tomcat-4.1.18-LE-jdk14/"+"webapps/tdoms/";
    }
    
    
    /**
     * Generates a random word. Here, a word is a group of letter, that
     * globally doesn't necessarily have sense.
     * @return the generated password.
     */
    private String generateRandomWord()
    {	
	Random randomNb = new Random(System.currentTimeMillis());
	char [] word    = new char[randomNb.nextInt(3)+5];
	for(int i=0; i<word.length; i++)
	    word[i] = letters[randomNb.nextInt(letters.length)];
	return new String(word);
    }
    
    
    /**
     * Tells if the user is authorized to subscribe or not.
     * Reads the configuration file located in APP_PATH/conf/teacher_list.txt.
     * This file contains the address mail of all the authorized users.
     * @param addressMail the address mail given by the user.
     * @return true if the user is authorized, false otherwise.
     */
    private boolean isAuthorized2Subscribe(String addressMail)
	throws IOException
    {
	String addressRead=null;
	BufferedReader fic = 
	    new BufferedReader(new FileReader(this.appliPath+"conf/teacher_list.txt"));
	while( ((addressRead = fic.readLine())!=null) && (!addressRead.equals(addressMail)) );
	fic.close();
	if(addressRead==null)return false;
	
	return true;
    }
    
    
    /**
     * Creates a temporary confirmation page. Its name is generated randomly.
     * @return true if the creation succeeded, false otherwise.
     */
    private String createTemporaryConfirmationPage(String login, String pwd, String addressMail)
    {
	String pageName = generateRandomWord()+".jsp";
	String pagePath = this.appliPath+"user-files/tmpfiles/"+pageName;
	String message  = "<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>\n<%@ taglib uri=\"/WEB-INF/struts-bean.tld\" prefix=\"bean\" %>\n<%@ taglib uri=\"/WEB-INF/struts-html.tld\" prefix=\"html\" %>\n\nPour confirmer votre inscription, cliquez sur le bouton ci-dessous.<br/>\n<html:form action=\"/confirm\" name=\"confirm\" type=\"account.SubscribeForm\">\n<html:hidden property=\"login\" name=\"login\" value=\""+login+"\"/>\n<html:hidden property=\"pwd\" name=\"pwd\" value=\""+pwd+"\"/>\n<html:hidden property=\"mail\" name=\"mail\" value=\""+addressMail+"\"/>\n<html:submit property=\"confirmation\" title=\"confirmationTitle\" value=\"Confirmer\"/>\n</html:form>";
	try{
	    BufferedWriter file = new BufferedWriter(new FileWriter(pagePath));
	    file.write(message);
	    file.close();
	}catch(IOException ioe)
	    { ioe.printStackTrace(); affichePourTests(ioe.getMessage()); return null; }
	return pageName;
    }
    
    
    /**
     * Sends the confirmation mail that will ask the user to go to a random
     * generated file, that will confirm the subscribtion.
     * @return true if the mail was correctly sent, false otherwise
     */
    private boolean sendConfirmationMail(String login,
					 String password,
					 String addressMail,
					 String pageName)
    {
	try {
	    String text = "Bonjour\n\n   Nous avons re�u une demande d'inscription au syst�me de gestion de documents d'enseignement. Si vous avez demand� l'inscription, veuillez vous rendre � l'adresse suivante:\n\n\thttp://"+(InetAddress.getLocalHost()).getHostAddress()+":"+this.PORT+"/tdoms/index.jsp?pg=user-files/tmpfiles/"+pageName+"\n\n   Votre inscription au syst�me ne sera effective que lorsque vous vous serez rendu sur cette page. Le login et le mot de passe de votre compte seront alors:\n\n\tLogin: "+login+"\n\tMot de passe: "+password+"\n\n   Si vous n'avez pas demand� l'inscription au syst�me t-doms, quelqu'un a utilis� votre adresse mail pour essayer de s'inscrire. Nous vous pr�sentons dans ce cas nos plus sinc�res excuses.\n\n   Cordialement,\n     le syst�me T-doms";
	    String mailHostFile = this.appliPath+"conf/mailhost.txt";
	    new Mailer().sendMail("matthieubriend@club-internet.fr", addressMail,
				  "Confirmation de l'inscription", text, mailHostFile);
	} catch (Exception e) {
	    affichePourTests(e.getMessage());
	    return false;
	}
	return true;
    }
    
    
    /**
     * Tells if the subscriptor is already in the database;
     * @return true if the user is already inserted, false otherwise.
     */
    private boolean isAlreadySubscribed(String addressMail) throws SQLException
    {
	DBI database = new DBI("sqletud.univ-mlv.fr",5432,"rtchuitc","rtchuitc","papa");
	/*
	  database.establishConnection();
	  ResultSet result = database.reqQuery("select * from account_tdoms where mail="+addressMail);
	  if(result==null)return false;
	  res = result.isFirst()&&result.isLast();
	  database.disconnect();
	*/
	AccountManager am = new AccountManager(database, "account_tdoms");
	return am.isAccountCreated(addressMail);
    }
    
    
    /**
     * Method called by Struts
     */
    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException
    {
	String target;
	
	SubscribeForm subForm = (SubscribeForm) form;
	String mail = subForm.getMail();
	String domain = subForm.getDomain();
	String login = subForm.getLogin();
	
	initApplicationPath();
	String addressMail = mail+"@"+domain;
	if(!isAuthorized2Subscribe(addressMail))
	    return mapping.findForward("unauthorized");
	
	try{
	    if(isAlreadySubscribed(addressMail))
		return mapping.findForward("multi_subscr");
	}
	catch(SQLException sqle){}
	
	String password = generateRandomWord();
	
	String pageName = createTemporaryConfirmationPage(login, password, addressMail);
	if( (pageName != null) && sendConfirmationMail(login, password, addressMail, pageName) )
	    return mapping.findForward("success");
	
	//the creation of the temporary confirmation page has failed
	//or the confirmation mail couldn't have been sent.
	return mapping.findForward("errorsys");
    }
}

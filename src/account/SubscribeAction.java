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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;


public class SubscribeAction extends Action
{
    private final static char [] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
					    'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
					    's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
					    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
					    'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
					    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
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
	
	BufferedReader fic = new BufferedReader(new FileReader("../../../conf/teacher_list.txt"));
	while( ((addressRead = fic.readLine())!=null) && (!addressRead.equals(addressMail)) );
	fic.close();
	
	if(addressRead==null)return false;
	
	return true;
    }
    
    
    /**
     * Creates a temporary confirmation page. Its name is generated randomly.
     * @return true if the creation succeeded, false otherwise.
     */
    private String createTemporaryConfirmationPage()
    {
	String pageName = generateRandomWord()+".jsp";
	String pagePath = "../../../user-files/tmpfiles/"+pageName;
	//index.jsp?pg=message.jsp&inside=pageName.tmp
	String message = "<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>\n<%@ taglib uri=\"/WEB-INF/struts-bean.tld\" prefix=\"bean\" %><%@ taglib uri=\"/WEB-INF/struts-html.tld\" prefix=\"html\" %>\nPour confirmer votre inscription, cliquez sur le bouton ci-dessous.<br/>\n<html:form action=\"/confirm\" name=\"confirm\" type=\"account.SubscribeForm\">\n<html:button property=\"confirmation\" title=\"confirmationTitle\" value=\"Confirm\">\n</html:form>"+pageName;
	try{
	    BufferedWriter file = new BufferedWriter(new FileWriter(pagePath));
	    file.write(message);
	    file.close();
	}catch(IOException ioe)
	    { ioe.printStackTrace(); return null; }
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
	    String text = "Bonjour\n\n   Nous avons reçu une demande d'inscription au système de gestion de documents d'enseignement. Si vous avez demandé l'inscription, veuillez vous rendre à l'adresse suivante:\n\n\thttp://127.0.0.1:8080/index.jsp?pg=message.jsp&inside="+pageName+"\n\n   Votre inscription au système ne sera effectif que lorsque vous vous serez rendu sur cette page. Le login et le mot de passe de votre compte seront alors:\n\n\tLogin: "+login+"\n\tMot de passe: "+password+"\n\n   Si vous n'avez pas demandé l'inscription au système t-doms, quelqu'un a utilisé votre adresse mail pour essayer de s'inscrire. Nous vous présentons dans ce cas nos plus sincères excuses.\n\n   Cordialement,\n     le système T-doms";
	    new Mailer().sendMail("mbriend@etudiant.univ-mlv.fr",
				  addressMail, "Confirmation de l'inscription", text);
	} catch (Exception e) {
	    return false;
	}
	return true;
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
	
	String addressMail = mail+"@"+domain;
	if(!isAuthorized2Subscribe(addressMail))
	    return mapping.findForward("error");
	
	String password = generateRandomWord();

	String pageName = createTemporaryConfirmationPage();
	if( (pageName != null) && sendConfirmationMail(login, password, addressMail, pageName) )
	    return mapping.findForward("success");
	
	//the creation of the temporary confirmation page has failed
	//or the confirmation mail couldn't have been sent.
	return mapping.findForward("errorsys");
    }
}

package utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Mailer
{
    private void setProperties(Properties props, String mailHostFile)throws IOException
    {	
	BufferedReader file = new BufferedReader(new FileReader(mailHostFile));
	String mailhost = file.readLine();
	file.close();
	if(mailhost==null)
	    throw new IOException("APP_PATH/conf/mailhost.txt is empty. Please give a smtp mail host");
	System.out.println("mail host: "+mailhost);
	props.put("mail.smtp.host", mailhost);
    }
    
    
    /**
     * Sends a mail with the given arguments. The smtp mail host is automatically read
     * in the APP_PATH/conf/mailhost.txt file.
     */
    public void sendMail(String sfrom, String sto, String ssubject, String stext, String mailHostFile)
	throws MessagingException, AddressException, IOException
    {
	Properties props = new Properties();
	setProperties(props, mailHostFile);
	
	Session s = Session.getInstance(props, null);
	
	MimeMessage message = new MimeMessage(s);
	InternetAddress from = new InternetAddress(sfrom);
	message.setFrom(from);
	InternetAddress to = new InternetAddress(sto);
	message.addRecipient(Message.RecipientType.TO, to);
	message.setSubject(ssubject);
	message.setText(stext);
	Transport.send(message);
    }
    
    public static void main(String [] args)
    {
	try{
	    String addressMail = "matthieubriend@club-internet.fr";
	    String text = "Bonjour\n\n\tNous avons reçu une demande d'inscription au système de gestion des documents d'enseignement. Si vous avez demandé l'inscription, veuillez vous rendre à l'adresse suivante:\n\tXXXXX\n\n\tVotre inscription au système ne sera effectif que lorsque vous vous serez rendu sur cette page. Le login et le mot de passe de votre compte seront alors:\n\tLogin: YYYYY\n\tMot de passe: ZZZZZ\n\nCordialement,\n le système T-doms";
	    new Mailer().sendMail("mbriend@etudiant.univ-mlv.fr", addressMail,
				  "Confirmation de l'inscription", text, "../../../conf/mailhost.txt");
	}catch(Exception e)
	    {
		System.err.println("Error: "+e.getMessage());
		e.printStackTrace();
	    }
    }
}

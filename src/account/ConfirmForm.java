package account;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

/**
 * Bean filled by Struts when the user validated the form
 * contained in a temporary page.
 */
public class ConfirmForm extends ActionForm{
    
    private String login = null;
    private String pwd   = null;
    private String mail  = null;
        
    
    public String getPwd(){
	return pwd;
    }
    public void setPwd(String pwd){
	this.pwd=pwd;
    }
    
    
    public String getMail(){
	return mail;
    }
    public void setMail(String mail){
	this.mail=mail;
    }
    
        
    public String getLogin(){
	return login;
    }
    public void setLogin(String login){
	this.login=login;
    }
    
    
    public void reset(ActionMapping mapping, HttpServletRequest request){
	this.pwd=null;
	this.login=null;
	this.mail=null;
    }
    
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	ActionErrors errors = new ActionErrors();
	
	if((login==null) || (login.length()==0)){
	    errors.add("login",new ActionError("error.login.required"));
	}
	
	if((pwd==null) || (pwd.length()==0)){
	    errors.add("pwd",new ActionError("error.pwd.required"));
	}
	
	if((mail==null) || (mail.length()==0)){
	    errors.add("mail",new ActionError("error.mail.required"));
	}
	
	return errors;
    }
}

package account;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

/**
 * Bean filled by Struts when the user entered the subscription form
 * contained in teacher/subscribe.jsp
 */
public class SubscribeForm extends ActionForm{
    
    private String mail = null;
    private String login = null;
    private String domain = null;
    private String validate = null;
    private String ref = null;
    
    
    public String getValidate(){
	return validate;
    }    
    public void setValidate(String validate){
	this.validate=validate;
    }

    
    public String getRef(){
	return ref;
    }    
    public void setRef(String ref){
	this.ref=ref;
    }
    
    
    public String getDomain(){
	return domain;
    }    
    public void setDomain(String domain){
	this.domain=domain;
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
	this.mail=null;
	this.login=null;
    }
    
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	ActionErrors errors = new ActionErrors();
	
	if((ref==null) || (ref.length()==0)){
	    errors.add("ref",new ActionError("error.ref.required"));
	}
	if((validate==null) || (validate.equals(""))){
	    errors.add("validate",new ActionError("error.validate.required"));
	}
	if((login==null) || (login.length()==0)){
	    errors.add("login",new ActionError("error.login.required"));
	}
	if((mail==null) || (mail.equals(""))){
	    errors.add("mail",new ActionError("error.mail.required"));
	}
	if(domain==null){
	    errors.add("domain",new ActionError("error.domain.required"));
	}
	return errors;
    }
}

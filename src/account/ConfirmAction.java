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

/**
 * This class manages the subscription of a user. It is called by Struts
 * after that the user has validated the subscription form contained in
 * teacher/subscribe.jsp.
 * If the user is allowed to subscribe, a temporary file is created. He will
 * then receive a mail which tells him to visit that file. He will have to visit
 * that page to confirm subscription.
 */
public class ConfirmAction extends Action
{
    /**
     * Inserts the informations in the database.
     * @return the target page
     */
    private String insertTupleInDB(String login, String passwd, String mail)
    {
	String target;
	
	DBI database = new DBI("sqletud.univ-mlv.fr",5432,"rtchuitc","rtchuitc","papa");
	/*
	  database.establishConnection();
	  if(database.reqUpdate("insert into account_tdoms (login, passwd, mail, rights) values('"+login+"', '"+passwd+"', '"+mail+"', 1000);"))//teacher has 1000 as permission id
	  target="success";
	  else
	  target="internal_error";
	  database.disconnect();
	*/
	AccountManager am = new AccountManager(database, "account_tdoms");
	if(am.addNewAccountNoCheck(1000, login, passwd, mail))
	    target = "success";
	else
	    target = "internal_error";
	
	return target;
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
	ConfirmForm subForm = (ConfirmForm) form;
	String login = subForm.getLogin();
	String pwd = subForm.getPwd();
	String mail = subForm.getMail();
	return mapping.findForward(insertTupleInDB(login, pwd, mail));
    }
}

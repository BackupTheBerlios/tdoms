package user;
public class SuperUser extends Etudiant {

    private String name;
    private String login;
    private String passwd;
    private String email;

    public SuperUser(int r, String n, String l, String p, String e){
	super(r);
	this.name = n;
	this.login = l;
	this.passwd = p;
	this.email = e;
    }

    /**
     * Returns the name of the user.
     * @return String.
     */
    public String getName(){
	return name;
    }

    
    /**
     * Returns the login of the user.
     * @return String.
     */
    public String getLogin(){
	return login;
    }
    
    /**
     * Returns the passwd of the user.
     * @return String.
     */
    public String getPasswd(){
	return passwd;
    }

    /**
     * Returns the email of the user.
     * @return String.
     */
    public String getEmail(){
	return email;
    }

    
    /**
     * Set the name of the user.
     * @param newname
     */
    public void setName(String newname){
	this.name = newname;
    }


    /**
     * Set the login of the user.
     * @param newlogin
     */
    public void setLogin(String newlogin){
	this.login = newlogin;
    }
    
    /**
     * Set the passwd of the user.
     * @param newpasswd.
     */
    public void setPasswd(String newpasswd){
	this.passwd = newpasswd;
    }

    /**
     * Set the email adress of the user.
     * @param newemail
     */
    public void setEmail(String newemail){
	this.email = newemail;
    }
}


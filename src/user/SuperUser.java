public class SuperUser extends Etudiant {

    private String login;
    private String passwd;

    public SuperUser(int r, String l, String p){
	super(r);
	this.login = l;
	this.passwd = p;
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
}


public class GenericUser{
    /**
     * Rights of that user.
     */
    private int rights;

    /**
     * 
     */
    public GenericUser(int r){
	this.rights = r;
    }

    public int getRights(){
	return rights;
    }
}

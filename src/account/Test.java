public class Test{

    public static void main(String [] args){

	DBI dbh = new DBI("sqletud.univ-mlv.fr",5432,"rtchuitc","rtchuitc","papa");
	//dbh.establishConnection();
	//dbh.createTable();

	AccountManager am = new AccountManager(dbh,"account");
	am.deleteAccount("tatayoyo");
	boolean toto = am.addNewAccount("Tymeng","tatayoyo","eastcoast","tyty@vachier.com");
	System.out.println(toto);

	am.updateAccount("tatayoyo","grumble","pistolty@vachier.com");
	dbh.disconnect();
    }
}

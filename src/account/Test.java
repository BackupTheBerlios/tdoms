public class Test{

    public static void main(String [] args){

	DBI dbh = new DBI("sqletud.univ-mlv.fr",5432,"rtchuitc","rtchuitc","papa");
	//dbh.establishConnection();
	//dbh.createTable();

	AccountManager am = new AccountManager(dbh,"account");
	am.deleteAccount("emlissa");
	boolean toto = am.addNewAccount("Melissa","emlissa","paola",700);
	System.out.println(toto);
	dbh.disconnect();
    }
}

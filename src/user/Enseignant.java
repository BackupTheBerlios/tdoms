import java.util.ArrayList;

public class Enseignant extends SuperUser {

    /* List of all the units created by this teacher */
    private ArrayList myUnits;

    public Enseignant(int r, String l, String p){
	super(r,l,p);
	this.myUnits = new ArrayList();	
    }

    /**
     * Test if the Teacher is the owner of this unit.
     * @param u.
     * @return true if the ArrayList "myUnits" contains the unit, false otherwise.
     */
    public boolean isUnitAuthor(Unit u){
	return myUnits.contains((Unit) u);
    }

    /**
     * Add an unit in the teacher Unit List.
     * @param u.
     * @return true if everything's ok, false otherwise.
     */
    public boolean addToUnitList(Unit u){
	return myUnits.add(u);
    }

    /**
     * Remove an unit from the teacher Unit List.
     * @param u
     * @return true if the unit have been removed from the list, false otherwise.
     */
    public boolean removeFromUnitList(Unit u){
	int index = myUnits.indexOf(u); 
	Unit tmp = (Unit) myUnits.remove(index);
	return tmp.equals(u);
    }
}


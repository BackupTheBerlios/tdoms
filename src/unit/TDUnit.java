import java.util.ArrayList;

public class TDUnit extends MultipleUnit
{
    /* List of all the Single units contained in this object */
    private ArrayList list_elements;
    

    public TDUnit()
    {
	this.list_elements = new ArrayList();
    }
    
    
    /**
     * Adds a SingleUnit Element to this object's list of SingleUnit.
     * @return true (as per the general contract of Collection.add).
     */
    public boolean addSingleUnit(SingleUnit u)
    { return this.list_elements.add(u); }
    
    /**
     * Adds a SingleUnit Element to this object's list of SingleUnit.
     * @return true (as per the general contract of Collection.add).
     */
    public void addSingleUnit(int index, SingleUnit u)
    { this.list_elements.add(index, u); }
        
    /**
     * Removes an element from this object's list of SingleUnit.
     * @return the element removed from the list.
     */
    public SingleUnit removeSingleUnit(int index)
    { return (SingleUnit)this.list_elements.remove(index); }
    
    
    /**
     * Returns the element located at 'index' from the beginning of the list.
     * @return the element at the specified position in this list. 
     */
    public SingleUnit getSingleUnit(int index)
    { return (SingleUnit)this.list_elements.get(index); }
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     */
    public void setSingleUnit(int index, SingleUnit u)
    { this.list_elements.set(index, u); }
}

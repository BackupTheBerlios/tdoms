package unit;
import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

import xmlProcessing.Bean2XML;

/**
   CE QUI MANQUE:
   -description XML
 */
/**
 * This object represents a TD unit. A TDUnit is most commonly a set of exercises.
 */
public class TDUnit extends MultipleUnit {
	/* List of all the Single units contained in this object */
	private ArrayList list_elements;

	/**
	 * Creates a TD unit with the given parameters.
	 * <code>list_elements</code> can be null. In this case, an ArrayList
	 * reference is assigned to it.
	 */
	public TDUnit(
		String title,
		String description,
		String file_name,
		ArrayList keyword_list,
		Teaching location,
		ArrayList list_elements) {
		super(title, description, file_name, keyword_list, location);
		if (list_elements == null)
			this.list_elements = new ArrayList();
		else
			this.list_elements = list_elements;
	}

	/**
	 * Adds a SingleUnit Element to this object's list of SingleUnit.
	 * @return true (as per the general contract of Collection.add).
	 */
	public boolean addSingleUnit(SingleUnit u) {
		return this.list_elements.add(u);
	}

	/**
	 * Adds a SingleUnit Element to this object's list of SingleUnit.
	 * @return true (as per the general contract of Collection.add).
	 */
	public void addSingleUnit(int index, SingleUnit u) {
		this.list_elements.add(index, u);
	}

	/**
	 * Removes an element from this object's list of SingleUnit.
	 * @return the element removed from the list.
	 */
	public SingleUnit removeSingleUnit(int index) {
		return (SingleUnit) this.list_elements.remove(index);
	}

	/**
	 * Returns the element located at 'index' from the beginning of the list.
	 * @return the element at the specified position in this list. 
	 */
	public SingleUnit getSingleUnit(int index) {
		return (SingleUnit) this.list_elements.get(index);
	}

	/**
	 * Returns an iterator that enables to get all the element of this Unit
	 * @return the iterator
	 */
	public ListIterator getElementIterator() {
		return this.list_elements.listIterator();
	}

	/**
	 * Returns an iterator that enables to get all the element of this Unit
	 * beginning from index
	 * @param index: index of the first element to be returned from the list
	 * iterator (by a call to the next method)
	 * @return the iterator
	 */
	public ListIterator getElementIterator(int index) {
		return this.list_elements.listIterator(index);
	}

	/**
	 * Returns the description of a unit in the XML form.
	 */
	public String getXMLDescription() {
		return "TDUnit: VOID";
	}

	/**
	 * Returns the teaching location of a td unit.
	 */
	public String getTeachingLocation() {
		return getUnitTeachingLocation()
			+ File.separator
			+ "tdunit"
			+ File.separator;
	}
	
	public Bean2XML getCurrentBean2XMLObject() {
		Bean2XML currentBean2XML = super.getCurrentBean2XMLObject();
		currentBean2XML.setBeanType("td");
		return currentBean2XML;
	}


	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 */
	public void setSingleUnit(int index, SingleUnit u) {
		this.list_elements.set(index, u);
	}
}

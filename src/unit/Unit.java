package unit;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.ListIterator;

import xmlProcessing.Bean2XML;


/**
 * Describes a Unit. A Unit is a generalization of all the documents
 * teachers will be able to put and read online.
 */
public abstract class Unit {
	//Attributes
	private String title;
	private String description;
	private ArrayList keywordList;
	private Teaching location;
	private String fileName;

	//Constructors
	public Unit(
		String title,
		String description,
		String fileName,
		ArrayList keywordList,
		Teaching location) {
		this.title = title;
		this.description = description;
		this.fileName = fileName;
		this.keywordList = keywordList;
		this.location = location;
	}

	//-------------------getters    
	/**
	 * @return the unit's title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return the unit's description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return the unit's file name
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Returns this unit's teaching location, ie field/section/year/
	 */
	public String getUnitTeachingLocation() {
		return this.location.getSubPath();
	}

	public String getXMLRepresentation() {
		return getCurrentBean2XMLObject().getBeanXMLString();
	}

	public void writeXMLRepresentation(String filePath) {
		getCurrentBean2XMLObject().WriteDownToFile(filePath);
	}

	public Bean2XML getCurrentBean2XMLObject() {
		Bean2XML currentBean2XML = new Bean2XML();
		currentBean2XML.addXMLElement("title", getTitle());
		currentBean2XML.addXMLElement("description", getDescription());
		currentBean2XML.addXMLMutliElement(
			"keywords",
			"key",
			getKeywordIterator());

		return currentBean2XML;

	};

	//-------------------setters
	/**
	 * Sets the unit's title
	 */
	public void setTitle(String title) {
		if (title != null)
			this.title = title;
		else
			this.title = "";
	}

	/**
	 * Sets the unit's description
	 */
	public void setDescription(String description) {
		if (this.description != null)
			this.description = description;
		else
			this.description = "";
	}

	/**
	 * Sets the unit's file name
	 */
	public void setFileName(String new_file_name) {
		if (this.fileName != null)
			this.fileName = new_file_name;
		else
			throw new InvalidParameterException("Parameter mustn't be null");
	}

	/**
	 * Sets the teaching location.
	 * If field or section is void or null, they won't be respectively updated.
	 * If year >= 1980 and year < 3000, the year will be updated.
	 */
	public void setTeachingLocation(String field, String section, short year) {
		if (field != null && !field.equals(""))
			this.location.setField(field);
		if (section != null && !section.equals(""))
			this.location.setSection(section);
		if (year >= 1980 && year < 3000)
			this.location.setYear(year);
	}

	/**
	 * Sets the teaching location.
	 */
	public void setTeachingLocation(Teaching location) {
		if (location != null)
			this.location = location;
		else
			throw new InvalidParameterException("Parameter mustn't be null");
	}

	/**
	 * Returns an iterator that enables to get all the keyword of this Unit
	 * @return the iterator
	 */
	public ListIterator getKeywordIterator() {
		return this.keywordList.listIterator();
	}

	/**
	 * Returns an iterator that enables to get all the keyword of this Unit
	 * beginning from index
	 * @param index: index of the first element to be returned from the list
	 * iterator (by a call to the next method)
	 * @return the iterator
	 */
	public ListIterator getKeywordIterator(int index) {
		return this.keywordList.listIterator(index);
	}
}

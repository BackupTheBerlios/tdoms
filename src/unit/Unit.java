import java.util.ArrayList;
import java.util.ListIterator;
import java.security.InvalidParameterException;

/**
 * Describes a Unit. A Unit is a generalization of all the documents
 * teachers will be able to put and read online.
 */
public abstract class Unit
{
    //Attributes
    private String    title;
    private String    description;
    private ArrayList keyword_list;
    private Teaching  location;
    private String    file_name;
    
    
    
    //Constructors
    public Unit(String title, String description, String file_name,
		ArrayList keyword_list, Teaching location)
    {
	this.title        = title;
	this.description  = description;
	this.file_name    = file_name;
	this.keyword_list = keyword_list;
	this.location     = location;
    }
    
    
    
    //-------------------getters    
    /**
     * @return the unit's title
     */
    public String getTitle()
    { return this.title; }
    
    /**
     * @return the unit's description
     */
    public String getDescription()
    { return this.description; }
    
    /**
     * @return the unit's file name
     */
    public String getFileName()
    { return this.file_name; }
    
    /**
     * Returns this unit's teaching location, ie field/section/year/
     */
    public String getUnitTeachingLocation()
    { return this.location.getSubPath(); }
    
    /**
     * Returns the description of a unit in the XML form.
     */
    public abstract String getXMLDescription();
    
    
    
    //-------------------setters
    /**
     * Sets the unit's title
     */
    public void setTitle(String new_title)
    {
	if(new_title != null) this.title = new_title;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    /**
     * Sets the unit's description
     */
    public void setDescription(String new_description)
    {
	if(this.description != null) this.description = new_description;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    /**
     * Sets the unit's file name
     */
    public void setFileName(String new_file_name)
    {
	if(this.file_name != null)this.file_name = new_file_name;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    /**
     * Sets the teaching location.
     * If field or section is void or null, they won't be respectively updated.
     * If year >= 1980 and year < 3000, the year will be updated.
     */
    public void setTeachingLocation(String field, String section, short year)
    {
	if(field != null && !field.equals(""))
	    this.location.setField(field);
	if(section != null && !section.equals(""))
	    this.location.setSection(section);
	if(year >= 1980 && year < 3000)
	    this.location.setYear(year);
    }
    
    /**
     * Sets the teaching location.
     */    
    public void setTeachingLocation(Teaching location)
    {
	if(location != null) this.location = location;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    
    
    /**
     * Returns an iterator that enables to get all the keyword of this Unit
     * @return the iterator
     */
    public ListIterator getKeywordIterator()
    { return this.keyword_list.listIterator(); }
    
    /**
     * Returns an iterator that enables to get all the keyword of this Unit
     * beginning from index
     * @param index: index of the first element to be returned from the list
     * iterator (by a call to the next method)
     * @return the iterator
     */
    public ListIterator getKeywordIterator(int index)
    { return this.keyword_list.listIterator(index); }
}

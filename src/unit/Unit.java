import java.security.InvalidParameterException;

public class Unit
{
    //Attributes
    private String title;
    private String description;
    private String file_name;
    
    //Constructors
    public Unit(String title, String description, String file_name)
    {
	this.title       = title;
	this.description = description;
	this.file_name   = file_name;
    }
    
    public Unit(){}
    
    //getters    
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
    
    //setters
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
}

package unit;
import java.security.InvalidParameterException;
import java.io.File;

/**
 * Contains all the properties of a teaching(field, section and year). It enables
 * the location of a unit.
 */
public class Teaching
{
    private String field;
    private String section;
    private int  year;
    
    
    
    public Teaching(String field, String section, int year)
    {
	this.field   = field;
	this.section = section;
	this.year    = year;
    }
    
    
    
    /**
     * Returns the year when the Teaching was created
     */
    public int getYear()
    { return this.year; }
    
    /**
     * Sets the section to which the Teaching belongs
     */  
    public String getSection()
    { return this.section; }
    
    /**
     * Sets the field to which the Teaching belongs
     */
    public String getField()
    { return this.field; }
    
    /**
     * Returns the subpath of this Teaching, ie field/section/year/(on *nix)
     */
    public String getSubPath()
    { return this.field+File.separator+this.section+File.separator+this.year; }
    
    
    
    /**
     * Sets the year when the Teaching was created
     * The year must be greater than or equal to 1980 and lesser than 3000(arbitrary)
     */
    public void setYear(short year)
    {
	if(year >= 1980 && year < 3000)this.year = year;
	else throw new InvalidParameterException("Parameter must be a reasonable year");
    }
    
    /**
     * Sets the section to which the Teaching belongs
     */
    public void setSection(String section)
    {
	if( (section != null)&&(!section.equals("")) )this.section = section;
	else throw new InvalidParameterException("Parameter must be neither null nor a void String");
    }
    
    /**
     * Sets the field to which the Teaching belongs
     */
    public void setField(String field)
    { 
	if( (field != null)&&(!field.equals("")) )this.field = field;
	else throw new InvalidParameterException("Parameter must be neither null nor a void String");
    }
}

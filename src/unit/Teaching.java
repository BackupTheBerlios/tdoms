import java.security.InvalidParameterException;

public class Teaching
{
    private String field;
    private String section;
    private short year;
    
    public Teaching(String field, String section, short year)
    {
	this.field   = field;
	this.section = section;
	this.year    = year;
    }
    
    /**
     * Returns the year when the Teaching was created
     */
    public short getYear()
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

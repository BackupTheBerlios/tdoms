import java.security.InvalidParameterException;

public class Exercise extends SingleUnit
{
    private String correction;//To add images to the correction, use the SingleUnit class
    
    public Exercise(String correction,
		    String text, String title, String description, String file_name,
		    ArrayList keyword_list, Teaching location)
    {
	super(text, title, description, file_name, keyword_list, location);
	if(correction != null) this.correction = correction;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    public Exercise() {}
    
    public void setCorrection(String correction)
    {
	if(correction != null) this.correction = correction;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    public String getCorrection()
    { return this.correction; }
    
    /**
     * Returns the description of a unit in the XML form.
     */
    public String getXMLDescription()
    { return "Exercise: VOID"; }
    
    /**
     * Returns the relative location of the teaching
     */
    public String getTeachingLocation()
    { return super.getTeachingLocation()+"exercise/"; }
}

import java.util.ArrayList;

public class Project extends SingleUnit
{
    public Project(String text, String title, String description, String file_name,
		   ArrayList keyword_list, Teaching location)
    {
	super(text, title, description, file_name, keyword_list, location);
    }
    
    /**
     * Returns the relative location of the teaching
     */
    public String getTeachingLocation()
    { return super.getTeachingLocation()+"projet/"; }
    
    /**
     * Returns the description of a unit in the XML form.
     */
    public String getXMLDescription()
    { return "ProjectUnit2: VOID"; }
}

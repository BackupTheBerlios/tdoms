import java.util.ArrayList;

public abstract class MultipleUnit extends Unit
{
    public MultipleUnit(String title, String description, String file_name,
			ArrayList keyword_list, Teaching location)
    {
	super(title, description, file_name, keyword_list, location);
    }
    
    
    abstract public boolean    addSingleUnit(SingleUnit u);
    abstract public void       addSingleUnit(int index, SingleUnit u);
    
    abstract public SingleUnit removeSingleUnit(int index);
    
    abstract public SingleUnit getSingleUnit(int index);
    abstract public void       setSingleUnit(int index, SingleUnit u);
    
    /**
     * Returns the description of a unit in the XML form.
     */
    public abstract String getXMLDescription();
    
    public abstract String getTeachingLocation();
}

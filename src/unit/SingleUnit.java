import java.util.ArrayList;
import java.util.ListIterator;
import java.security.InvalidParameterException;


/*
  ce qu'il reste a faire:
  -changer eventuellement le type d'une image dans les fonctions d'ajout
*/
/**
 * Represents a single unit. A single unit is generalisation of exercises, projects, ...
 */
public abstract class SingleUnit extends Unit
{
    private String text;
    private ArrayList images_list;
    
    
    
    public SingleUnit(String text, //for this class
		      String title, String description, String file_name,//parameters for super class
		      ArrayList keyword_list, Teaching location)
    {
	super(title, description, file_name, keyword_list, location);
	
	this.images_list = new ArrayList();
	this.text = text;
    }
    
    
    
    /**
     * Returns this object's text.
     */
    public String getText()
    { return this.text; }
    
    /**
     * Returns the description of a unit in the XML form.
     */
    public abstract String getXMLDescription();
    
    public abstract String getTeachingLocation();
    
    
    
    /**
     * Sets this object's text.
     */
    public void setText(String text)
    {
	if(this.text != null) this.text = text;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    
    
    //operations on the image list
    /**
     * Returns an iterator that enables to get all the image of this Unit
     * @return the iterator
     */
    public ListIterator getImageIterator()
    { return this.images_list.listIterator(); }
    
    /**
     * Returns an iterator that enables to get all the image of this Unit
     * beginning from index
     * @param index: index of the first image to be returned from the list
     * iterator (by a call to the next method)
     * @return the iterator
     */
    public ListIterator getImageIterator(int index)
    { return this.images_list.listIterator(index); }
    
    
    
    /**
     * Returns the image located at the <code>index</code> index
     */
    public Object getImage(int index)
    { return this.images_list.get(index); }
    
    
    
    /**
     * Sets the value of an image located at <code>index</code>.
     */
    public Object setImage(int index, Object image)
    { return this.images_list.set(index, image); }
    
    
    
    /**
     * Adds an image to the list of images
     * CHANGER LE TYPE DU PARAMETRE UNE FOIS LE TYPE DE L'IMAGE FIXE
     */
    public void addImage(Object image)
    { this.images_list.add(image); }
    
    /**
     * Adds an image to the list of images
     * CHANGER LE TYPE DU PARAMETRE UNE FOIS LE TYPE DE L'IMAGE FIXE
     */
    public void addImage(int index, Object image)
    { this.images_list.add(index, image); }
    
    
    
    /**
     * Removes an image from the image list
     * CHANGER LE TYPE DU PARAMETRE UNE FOIS LE TYPE DE L'IMAGE FIXE
     */
    public Object removeImage(int index)
    { return this.images_list.remove(index); }
}

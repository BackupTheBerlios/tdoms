import java.util.ArrayList;
import java.security.InvalidParameterException;

public abstract class SingleUnit extends Unit
{
    private String text;
    private ArrayList images_list;
    
    public SingleUnit()
    {
	this.images_list = new ArrayList();
    }
    
    public SingleUnit(String text)
    {
	this.images_list = new ArrayList();
	this.text = text;
    }
    
    /**
     * Returns this object's text.
     */
    public String getText()
    { return this.text; }
    
    
    /**
     * Sets this object's text.
     */
    public void setText(String text)
    {
	if(this.text != null) this.text = text;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }

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

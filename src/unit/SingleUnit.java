package unit;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.ListIterator;

import xmlProcessing.Bean2XML;

/*
  ce qu'il reste a faire:
  -changer eventuellement le type d'une image dans les fonctions d'ajout
*/
/**
 * Represents a single unit. A single unit is generalisation of exercises, projects, ...
 */
public abstract class SingleUnit extends Unit {
	protected ArrayList questionList;
	protected ArrayList imageList;

	public SingleUnit(ArrayList questionList, //parameters for this class
	String title, String description, String fileName,
	//parameters for super class
	ArrayList keywordList, Teaching location) {
		super(title, description, fileName, keywordList, location);

		this.imageList = new ArrayList();
		this.questionList = questionList;
	}

	
	/**
	 * Returns this object's questionList.
	 */
	public ArrayList getText() {
		return this.questionList;
	}

	public abstract String getTeachingLocation();

	/**
	 * Sets this object's questionList.
	 */
	public void setText(ArrayList questionList) {
		if (this.questionList != null)
			this.questionList = questionList;
		else
			throw new InvalidParameterException("Parameter shouldn't be null");
	}
	
	public Bean2XML getCurrentBean2XMLObject() {
		Bean2XML currentBean2XML = super.getCurrentBean2XMLObject();
		currentBean2XML.addXMLMutliElement(
			"questions",
			"q",
			getQuestionIterator());
		return currentBean2XML;
	}
	

	//operations on the image list
	/**
	 * Returns an iterator that enables to get all the image of this Unit
	 * @return the iterator
	 */
	public ListIterator getImageIterator() {
		return this.imageList.listIterator();
	}

	public ListIterator getQuestionIterator() {
		return this.questionList.listIterator();
	}

	/**
	 * Returns an iterator that enables to get all the image of this Unit
	 * beginning from index
	 * @param index: index of the first image to be returned from the list
	 * iterator (by a call to the next method)
	 * @return the iterator
	 */
	public ListIterator getImageIterator(int index) {
		return this.imageList.listIterator(index);
	}

	/**
	 * Returns the image located at the <code>index</code> index
	 */
	public Object getImage(int index) {
		return this.imageList.get(index);
	}

	/**
	 * Sets the value of an image located at <code>index</code>.
	 */
	public Object setImage(int index, Object image) {
		return this.imageList.set(index, image);
	}

	/**
	 * Adds an image to the list of images
	 * CHANGER LE TYPE DU PARAMETRE UNE FOIS LE TYPE DE L'IMAGE FIXE
	 */
	public void addImage(Object image) {
		this.imageList.add(image);
	}

	/**
	 * Adds an image to the list of images
	 * CHANGER LE TYPE DU PARAMETRE UNE FOIS LE TYPE DE L'IMAGE FIXE
	 */
	public void addImage(int index, Object image) {
		this.imageList.add(index, image);
	}

	/**
	 * Removes an image from the image list
	 * CHANGER LE TYPE DU PARAMETRE UNE FOIS LE TYPE DE L'IMAGE FIXE
	 */
	public Object removeImage(int index) {
		return this.imageList.remove(index);
	}
}

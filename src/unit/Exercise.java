package unit;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import xmlProcessing.Bean2XML;

/*
  Ce qu'il reste a faire:
  -description XML
 */
public class Exercise extends SingleUnit {
	private String correction;
	//To add images to the correction, use the SingleUnit class   

	public Exercise(
		String title,
		ArrayList keywordList,
		ArrayList questionList,
		String description,
		String fileName,		
		String correction,
		Teaching location) {
		super(questionList, title, description, fileName, keywordList, location);
		if (correction != null)
			this.correction = correction;
		else
			this.correction = "";
	}

	public void setCorrection(String correction) {
		if (correction != null)
			this.correction = correction;
		else
			this.correction = "";
	}

	public String getCorrection() {
		return this.correction;
	}

	public Bean2XML getCurrentBean2XMLObject() {
		Bean2XML currentBean2XML = super.getCurrentBean2XMLObject();
		currentBean2XML.setBeanType("exo");
		currentBean2XML.addXMLElement("correction", getCorrection());
		return currentBean2XML;
	}

	/**
	 * Returns the relative location of the teaching
	 */
	public String getTeachingLocation() {
		return getUnitTeachingLocation()
			+ File.separator
			+ "exercise"
			+ File.separator;
	}
}

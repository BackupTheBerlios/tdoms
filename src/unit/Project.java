package unit;
import java.io.File;
import java.util.ArrayList;

import xmlProcessing.Bean2XML;

/*
  ce qui manque:
  -description XML
  -tester getTeachingLocation()
*/
public class Project extends SingleUnit {
	public Project(
		ArrayList questions,
		String title,
		String description,
		String fileName,
		ArrayList keywordList,
		Teaching location) {
		super(questions, title, description, fileName, keywordList, location);
	}

	/**
	 * Returns the relative location of the teaching
	 */
	public String getTeachingLocation() {
		return getUnitTeachingLocation()
			+ File.separator
			+ "project"
			+ File.separator;
	}
	public String getXMLRepresentation() {
		return getCurrentBean2XMLObject().getBeanXMLString();
	}

	public void writeXMLRepresentation(String filePath) {
		getCurrentBean2XMLObject().WriteDownToFile(filePath);
	}

	public Bean2XML getCurrentBean2XMLObject() {
		Bean2XML currentBean2XML = super.getCurrentBean2XMLObject();
		currentBean2XML.setBeanType("project");
		return currentBean2XML;
	}
}

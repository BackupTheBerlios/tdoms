package xmlProcessing;
/**
 * @author mehdi
 *
 */

import java.io.FileOutputStream;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.elharo.xml.xinclude.SAXXIncluder;
import com.elharo.xml.xinclude.XIncludeFilter;

/**
 * This Class deals with XInlcusion 
 */
public class XIncluder {

	
	/**
	 * Main Method for processing Transformation 
	 * @param xmlin the path of the xml file to interpret xinclusion from
	 * @param xmlout the path of the resulting xml file with the included files in its body
	 */
	public static void process(String xmlin, String xmlout) {
		System.out.println("Test Started...");

		XMLReader parser;
		try {
			parser = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			try {
				parser =
					XMLReaderFactory.createXMLReader(
						"org.apache.xerces.parsers.SAXParser");
			} catch (SAXException e2) {
				System.err.println("Could not find an XML parser");
				return;
			}
		}

		try {
			parser.setFeature(
				"http://xml.org/sax/features/namespace-prefixes",
				true);
		} catch (SAXException e) {
			System.err.println(e);
			return;
		}

		EntityResolver resolver = null;

		try {

			XIncludeFilter includer = new XIncludeFilter();
			includer.setParent(parser);
			SAXXIncluder s = new SAXXIncluder(new FileOutputStream(xmlout));
			includer.setContentHandler(s);

			try {
				includer.setProperty(
					"http://xml.org/sax/properties/lexical-handler",
					s);
				s.setFilter(includer);
			} catch (SAXException e) {
				// Will not support comments
			}
			includer.parse(xmlin);
		} catch (SAXParseException e) {
			System.err.println(e);
			System.err.println(
				"Problem in "
					+ e.getSystemId()
					+ " at line "
					+ e.getLineNumber());
		} catch (Exception e) { // be specific about exceptions????
			System.err.println(e);
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	public static void main(String[] args) {
		String xmlin =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/tds/td.xml";

		String xmlout =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/tds/include.xml";

		XIncluder inc = new XIncluder();
		inc.process(xmlin, xmlout);
	}

}

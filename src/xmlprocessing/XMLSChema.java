package xmlProcessing;

/**
 * @author mlamrani
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

public class XMLSChema extends DefaultHandler {

	private static final String JAXP_SCHEMA_LANGUAGE =
		"http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA =
		"http://www.w3.org/2001/XMLSchema";

	public static void main(String argv[]) throws IOException {
		try {
			System.setProperty(
				"javax.xml.parsers.SAXParserFactory",
				"org.apache.xerces.jaxp.SAXParserFactoryImpl");
			System.setProperty(
				"javax.xml.parsers.SAXParser",
				"org.apache.xerces.jaxp.SAXParserImpl");		

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
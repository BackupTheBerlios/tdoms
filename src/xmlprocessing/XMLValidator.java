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

public class XMLValidator extends DefaultHandler {

	private static final String JAXP_SCHEMA_LANGUAGE =
		"http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA =
		"http://www.w3.org/2001/XMLSchema";
	private static final String JAXP_SCHEMA_SOURCE =
		"http://java.sun.com/xml/jaxp/properties/schemaSource";

	public static void main(String argv[]) throws IOException {

		System.setProperty(
			"javax.xml.parsers.SAXParserFactory",
			"org.apache.xerces.jaxp.SAXParserFactoryImpl");
		System.setProperty(
			"javax.xml.parsers.SAXParser",
			"org.apache.xerces.jaxp.SAXParserImpl");
		System.setProperty(
			"javax.xml.transform.TransformerFactory",
			"org.apache.xalan.processor.TransformerFactoryImpl");
		System.setProperty(
			"org.xml.sax.parser",
			"org.apache.xerces.parsers.SAXParser");

		String XMLFile =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exo2.xml";
		String SCHEMAFile =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exo.xsd";

		System.out.println("beginning process...");
		DefaultHandler handler = new XMLValidator();

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);

		// la factory produira un parseur validant
		try {

			SAXParser saxParser = factory.newSAXParser();
			saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			saxParser.setProperty(JAXP_SCHEMA_SOURCE, SCHEMAFile);

			saxParser.parse(new FileInputStream(XMLFile), handler);
		} catch (SAXException e) {
			// prise en charge des erreurs SAX
			// donc en particulier celles de parsing
			System.out.println("erreur de parsing");
			e.printStackTrace();
			System.exit(1);
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("erreur autre que parsing");
			System.exit(2);
		}
		System.out.println("parsing reussi");
		System.exit(0);
	}
	public void error(SAXParseException e)
	// le "handler" (le traitement) lors du
	// parsing d'une erreur
	throws SAXParseException {
		throw e;
		// transmettre au lieu, par defaut, d'ignorer
	}
}
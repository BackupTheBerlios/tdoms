/**
 * @author mehdi
 *
 */
package xmlProcessing;
import javax.xml.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

/**
 * This class deals with XML > HTML Conversion via JAXP (XSLT)
 */
public class XML2HTMLTransformer extends XMLTransformer {

	/**
	 * Main Method for processing Transformation 
	 * @param XMLFilePath the path of the xml file to transform
	 * @param XSLFilePath the path of the xsl file 
	 * @param HTMLFileResult the path of the desired html file
	 */
	public void process(
		String XMLFilePath,
		String XSLFilePath,
		String HTMLFileResult) {

		System.out.println("Processing HTML Transformation...");

		if (HTMLFileResult == null) {
			HTMLFileResult =
				XMLFilePath.substring(0, XMLFilePath.length() - 3) + "html";
		}

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Source xslSource = new StreamSource(XSLFilePath);
			Transformer transformer = tFactory.newTransformer(xslSource);

			transformer.transform(
				new StreamSource(XMLFilePath),
				new StreamResult(new FileOutputStream(HTMLFileResult)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Done.");
	}

	public static void main(String[] args) {
		System.out.println("Test Started...");
		String XSLFilePath =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exohtml.xsl";
		String XMLFilePath =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exobean.xml";
		XML2HTMLTransformer transfo = new XML2HTMLTransformer();
		transfo.process(XMLFilePath, XSLFilePath);
		System.out.println("Done.");
	}
}

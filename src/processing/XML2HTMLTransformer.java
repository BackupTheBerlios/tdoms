/**
 * @author mlamrani
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
package XMLProcessing;
import javax.xml.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class XML2HTMLTransformer implements XMLTransformer {
	
	public void process(String XMLFilePath, String XSLFilePath) {
		
		System.out.println("Processing...");
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Source xslSource = new StreamSource(XSLFilePath);
			Transformer transformer = tFactory.newTransformer(xslSource);

			transformer
				.transform(
					new StreamSource(XMLFilePath),
						new StreamResult(
							new FileOutputStream(XMLFilePath.substring(0,XMLFilePath.length()-3)+"html")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Done.");
	}


	public static void main(String[] args) {

		String XSLFilePath = "/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exohtml.xsl";
		String XMLFilePath = "/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exo2.xml";	
		XML2HTMLTransformer transfo = new XML2HTMLTransformer();
		transfo.process(XMLFilePath,XSLFilePath);
	}
}

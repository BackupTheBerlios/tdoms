package xmlProcessing;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.sax.*;
import org.apache.avalon.framework.*;
import org.apache.avalon.framework.logger.*;
import org.apache.fop.*;
import org.apache.fop.apps.*;
import org.apache.fop.messaging.*;

/**
 * This class deals with XML > HTML Conversion via JAXP (XSLT) + FOP (XSL:FO).
 */
public class XML2PDFTransformer extends XMLTransformer {

	/**
	 * Main Method for processing Transformation 
	 * @param XMLFilePath the path of the xml file to transform
	 * @param XSLFilePath the path of the xsl file 
	 * @param HTMLFileResult the path of the desired html file
	 */
	public void process(String XMLFilePath, String XSLTFilePath, String PDFFileResult) {

		System.out.println("Processing...");

		if (PDFFileResult == null) {
			PDFFileResult =
				XMLFilePath.substring(0, XMLFilePath.length() - 3) + "pdf";
		}

		Driver driver = new Driver();

		Logger logger = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);
		driver.setLogger(logger);
		MessageHandler.setScreenLogger(logger);

		driver.setRenderer(Driver.RENDER_PDF);

		OutputStream out = null;
		try {

			out =
				new java.io.FileOutputStream(PDFFileResult);

			driver.setOutputStream(out);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer =
				factory.newTransformer(new StreamSource(XSLTFilePath));

			Source src = new StreamSource(XMLFilePath);

			Result res = new SAXResult(driver.getContentHandler());

			transformer.transform(src, res);

			out.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("FOP XML2PDF\n");
					System.out.println("Test Started...");

			String xmlfile =
				"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exobean.xml";
			String xsltfile =
				"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exopdf.xsl";
			
			System.out.println("Transforming...");

			XML2PDFTransformer app = new XML2PDFTransformer();
			app.process(xmlfile, xsltfile);

			System.out.println("Success!");
		} catch (Exception e) {
			System.err.println(ExceptionUtil.printStackTrace(e));
			System.exit(-1);
		}
	}
}

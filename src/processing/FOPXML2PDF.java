/*
 * $Id: FOPXML2PDF.java,v 1.1 2003/04/22 16:49:57 mehdi Exp $
 * Copyright (C) 2002-2003 The Apache Software Foundation. All rights reserved.
 * For details on use and redistribution please refer to the
 * LICENSE file included with these sources.
 */
package XMLProcessing;

//Java
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

//JAXP
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;

//Avalon
import org.apache.avalon.framework.ExceptionUtil;
import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;

//FOP
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;

/**
 * This class demonstrates the conversion of an XML file to PDF using 
 * JAXP (XSLT) and FOP (XSL:FO).
 */
public class FOPXML2PDF {

    public void convertXML2PDF(File xml, File xslt, File pdf) 
                throws IOException, FOPException, TransformerException {
        //Construct driver
        Driver driver = new Driver();
        
        //Setup logger
        Logger logger = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);
        driver.setLogger(logger);
        MessageHandler.setScreenLogger(logger);

        //Setup Renderer (output format)        
        driver.setRenderer(Driver.RENDER_PDF);
        
        //Setup output
        OutputStream out = new java.io.FileOutputStream(pdf);
        try {
            driver.setOutputStream(out);

            //Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslt));
        
            //Setup input for XSLT transformation
            Source src = new StreamSource(xml);
        
            //Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(driver.getContentHandler());

            //Start XSLT transformation and FOP processing
            transformer.transform(src, res);
        } finally {
            out.close();
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println("FOP XML2PDF\n");
            System.out.println("Preparing...");

            //Setup directories
            File baseDir = new File("../xml");
            File outDir = new File(baseDir, "../xml");
            outDir.mkdirs();

            //Setup input and output files            
/*            File xmlfile = new File(baseDir, "projectteam.xml");
            File xsltfile = new File(baseDir, "projectteam2fo.xsl");
            File pdffile = new File(outDir, "ResultXML2PDF.pdf");
            
/*             File xmlfile = new File(baseDir, "../xml/food.xml");
            File xsltfile = new File(baseDir, "../xml/foodfo.xsl");
            File pdffile = new File(outDir, "../xml/food.pdf");
*/

			File xmlfile = new File("/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exo2.xml");
            File xsltfile = new File("/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exopdf.xsl");
            File pdffile = new File("/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exo2.pdf");
            
            System.out.println("Input: XML (" + xmlfile + ")");
            System.out.println("Stylesheet: " + xsltfile);
            System.out.println("Output: PDF (" + pdffile + ")");
            System.out.println();
            System.out.println("Transforming...");
            
            FOPXML2PDF app = new FOPXML2PDF();
            app.convertXML2PDF(xmlfile, xsltfile, pdffile);
            
            System.out.println("Success!");
        } catch (Exception e) {
            System.err.println(ExceptionUtil.printStackTrace(e));
            System.exit(-1);
        }
    }
}

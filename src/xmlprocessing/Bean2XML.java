package xmlProcessing;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Element;
import unit.Exercise;
import unit.Teaching;

import com.ibm.xml.parser.TXDocument;

/*********************************************************/
public class Bean2XML {

	public TXDocument doc;
	public Element root;
	public Element el;
	public Element subel;

	public Bean2XML() {
		doc = new TXDocument();
		root = doc.createElement("unit");

	}
	
	public void setBeanType(String BeanType){
		root.setAttribute("type", BeanType);
	}
	

	private void commitDocument() {
		doc.appendChild(root);		
	}

	public void addXMLElement(String name, String value) {
		el = doc.createElement(name);
		el.appendChild(doc.createTextNode(value));
		root.appendChild(el);
	}

	public void addXMLMutliElement(String name, String subname, Iterator i) {
		el = doc.createElement(name);
		root.appendChild(el);

		while (i.hasNext()) {
			subel = doc.createElement(subname);
			subel.appendChild(doc.createTextNode(i.next().toString()));
			el.appendChild(subel);
		}
	}

	public void WriteDownToFile(String XMLFilePath) {
		try {
			commitDocument();
			doc.printWithFormat(new FileWriter(XMLFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBeanXMLString() {
		commitDocument();
		System.out.println(doc.getText());
		return doc.getText();
	}

	public static void main(String[] args) {
		// Create TXDocument object and cast it to Document object type

		System.out.println("Processing...");

		String XMLFile =
			"/home/main01/mlamrani/gl/xml/tdoms/matiere/section/annee/exercices/exobean.xml";

		ArrayList keywordList = new ArrayList();
		keywordList.add("Java");
		keywordList.add("Swing");
		keywordList.add("Interface Graphique");

		ArrayList questionList = new ArrayList();
		questionList.add("Creer une frame vide");
		questionList.add("Rajouter un panel et deux JButton");
		questionList.add(
			"Assigner des actions aux JButtons pour changer la couleur du Panel");

		Teaching ens = new Teaching("java", "license", 2001);

		Exercise exoBean =
			new Exercise(
				"creation d'une frame",
				keywordList,
				questionList,
				"description de l'exercice",
				"exoswing.xml",
				"pas de correction",
				ens);
		
		
		String a = exoBean.getXMLRepresentation();
		exoBean.writeXMLRepresentation(XMLFile);

		/*TXDocument doc = new TXDocument();
		
		Element root = doc.createElement("exo");
		Element el;
		Element subel;
		
		klsndlknhf
		
		el = doc.createElement("title");
		el.appendChild(doc.createTextNode(exoBean.getTitle()));
		root.appendChild(el);
		
		el = doc.createElement("description");
		el.appendChild(doc.createTextNode(exoBean.getDescription()));
		root.appendChild(el);
		
		el = doc.createElement("keywords");
		Iterator i = exoBean.getKeywordIterator();
		root.appendChild(el);
		
		while (i.hasNext()) {
			subel = doc.createElement("key");
			subel.appendChild(doc.createTextNode(i.next().toString()));
			el.appendChild(subel);
		}
		
		el = doc.createElement("text");
		el.appendChild(doc.createTextNode(exoBean.getText()));
		
		el = doc.createElement("correction");
		el.appendChild(doc.createTextNode(exoBean.getCorrection()));
		
		root.appendChild(el);
		
		doc.appendChild(root);
		
		try {
			doc.printWithFormat(new FileWriter(XMLFile));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("Done.");
	}

}
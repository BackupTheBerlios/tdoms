package unit;
import java.util.ArrayList;
import java.security.InvalidParameterException;
import java.util.Iterator;

/**
 * Tests all the unit classes.
 * Mustn't be in the final distribution.
 */
public class TestUnit {
	public static void main(String[] args) {
		/*ArrayList keyword_list = new ArrayList();
		keyword_list.add("keyword 1");
		keyword_list.add("keyword 2");
		keyword_list.add("keyword 3");

		System.out.println("<<<<Testing Teaching>>>>");
		Teaching location = new Teaching("field", "section", (short) 1995);
		try {
			location.setYear((short) 1200);
		} catch (InvalidParameterException ipe) {
			System.err.println("on peut pas ajouter 1200\n" + ipe.getMessage());
		}
		System.out.println(
			"subpath apres modif date: " + location.getSubPath());
		try {
			location.setField("blabla");
		} catch (InvalidParameterException ipe) {
			System.err.println(
				"on peut pas ajouter blabla\n" + ipe.getMessage());
		}
		try {
			location.setField("");
		} catch (InvalidParameterException ipe) {
			System.err.println("on peut pas ajouter \"\"\n" + ipe.getMessage());
		}
		System.out.println(
			"subpath apres modif matiere: " + location.getSubPath());

		System.out.println("\n<<<<Testing Exercise>>>>");
		Exercise e =
			new Exercise(
				"text",
				"title",
				"description",
				"file name",
				keyword_list,
				location);
		try {
			e.setCorrection("Correction2");
		} catch (InvalidParameterException ipe) {
			System.err.println(
				"on peut pas ajouter Correction2\n" + ipe.getMessage());
		}
		System.out.println("getTeachingLocation: " + e.getTeachingLocation());
		System.out.println("getXMLDescription: " + e.getXMLDescription());
		System.out.println("getCorrection: " + e.getCorrection());

		System.out.println("\n<<<<Testing Project>>>>");
		Project p =
			new Project(
				"text",
				"title",
				"description",
				"file name",
				keyword_list,
				location);
		System.out.println("getTeachingLocation: " + p.getTeachingLocation());
		System.out.println("getXMLDescription: " + p.getXMLDescription());
		p.setFileName("file name2");
		System.out.println("getFileName: " + p.getFileName());

		System.out.println("\n<<<<Testing TDUnit>>>>");
		ArrayList list_elements = new ArrayList();
		list_elements.add(e);
		TDUnit t =
			new TDUnit(
				"title",
				"description",
				"file name",
				keyword_list,
				location,
				list_elements);
		System.out.println("getTeachingLocation: " + t.getTeachingLocation());
		System.out.println("getXMLDescription: " + t.getXMLDescription());
		t.setTeachingLocation("field3", "section3", (short) 2500);
		System.out.println(
			"getTeachingLocation apres modif: " + t.getTeachingLocation());
		Iterator it = t.getElementIterator(0);
		while (it.hasNext())
			System.out.println(
				"getTeachingLocation de it.next():"
					+ (((Exercise) it.next()).getTeachingLocation()));
		System.out.println(
			"Premier exercice: " + t.getSingleUnit(0).getTeachingLocation());
		System.out.println("On supprime un exercice:");
		t.removeSingleUnit(0);
		it = t.getElementIterator(0);
		while (it.hasNext())
			System.out.println(
				"getTeachingLocation de it.next():"
					+ (((Exercise) it.next()).getTeachingLocation()));

		System.out.println("\n<<<<Testing Unit>>>>");
		Unit u =
			new Exercise(
				"Correction4",
				"text4",
				"title4",
				"description4",
				"file name4",
				keyword_list,
				location);
		System.out.println(
			"getTeachingLocation: " + u.getUnitTeachingLocation());
		System.out.println("getFileName: " + u.getFileName());
		*/
	}
}

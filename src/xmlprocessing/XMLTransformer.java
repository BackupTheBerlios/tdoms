/**
 * @author mlamrani
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

package xmlProcessing;
import javax.xml.*;

public abstract class XMLTransformer {

	public void process(String XMLFilePath, String XSLFilePath) {
		process(XMLFilePath, XSLFilePath, null);
	}
	public  abstract void process(String XMLFilePath, String XSLFilePath, String ResultFile);
	
}

package unit;
import java.security.InvalidParameterException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class UnitManager {
	private Unit unit;

	public UnitManager(Unit u) {
		if (u != null)
			this.unit = u;
		else
			throw new InvalidParameterException("Unit Parameter mustn't be null");
	}

	/**
	 * Removes the unit from the file system.
	 */
	public boolean removeUnit(Config conf) {
		File unitFile =
			new File(
				conf.getAbsoluteApplicationPath()
					+ this.unit.getUnitTeachingLocation());
		if (!unitFile.delete()) {
			System.err.println(
				"Unable to remove "
					+ conf.getAbsoluteApplicationPath()
					+ this.unit.getUnitTeachingLocation());
			return false;
		}
		return true;
	}

	/**
	 * INUTILE A PRESENT CHAQUE BEAN s'AUTO-GERE AU NIVEAU DU SAVE
	 * Saves the unit in the file system.
	 * @param conf: the configuration object that contains all the indications on the application.
	 * @return: true if everything went well, false otherwise.
	 */
	/*public boolean saveUnit(Config conf) {
		boolean res;
		try {
			String unitFile =
				conf.getAbsoluteApplicationPath()
					+ this.unit.getUnitTeachingLocation();
			return (unit.writeXMLRepresentation(unitFile);

		} catch (IOException ioe) {
			System.err.println(
				"Unable to save "
					+ conf.getAbsoluteApplicationPath()
					+ this.unit.getUnitTeachingLocation());
			return false;
		}
		return true;

	}*/

	public boolean updateUnit() {
		return false;
	}
}

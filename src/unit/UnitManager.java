import java.security.InvalidParameterException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class UnitManager
{
    private Unit unit;
    
    public UnitManager(Unit u)
    {
	if(u!=null)
	    this.unit = u;
	else
	    throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    
    /**
     * Removes the unit from the file system.
     */
    public boolean removeUnit(Config conf)
    {
	File ex_dir =
	    new File(conf.getAbsoluteApplicationPath()+this.unit.getTeachingLocation());
	if(!ex_dir.delete())
	    {
		System.err.println("Unable to remove "+conf.getAbsoluteApplicationPath()+this.unit.getTeachingLocation());
		return false;
	    }
	return true;
    }
    
    /**
     * Saves the unit in the file system.
     * @param conf: the configuration object that contains all the indications on the application.
     * @return: true if everything went well, false otherwise.
     */
    public boolean saveUnit(Config conf)
    {
	boolean res;
	File ex_dir =
	    new File(conf.getAbsoluteApplicationPath()+this.unit.getTeachingLocation());
	try{
	    BufferedWriter writer = new BufferedWriter(new FileWriter(ex_dir));
	    writer.write(this.unit.getXMLDescription());
	    writer.close();
	}
	catch(IOException ioe)
	    {
		System.err.println("Unable to save "+conf.getAbsoluteApplicationPath()+this.unit.getTeachingLocation());
		return false;
	    }
	return true;
    }
    
    public boolean updateUnit()
    { return false; }
}

import java.security.InvalidParameterException;

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
	    new File(conf.getApplicationPath()+this.unit.getTeachingLocation());
	if(!ex_dir.remove())
	    System.err.println("Unable to remove "+conf.getApplicationPath()+this.unit.getTeachingLocation());
    }
    
    /**
     * Saves the unit in the file system.
     * @param conf: the configuration object that contains all the indications on the application.
     * @return: true if everything went well, false otherwise.
     */
    public boolean saveUnit(Config conf)
    {
	File ex_dir =
	    new File(conf.getApplicationPath()+this.unit.getTeachingLocation());
	BufferedWriter writer = new BufferedWriter(new FileWriter(ex_dir));
	writer.write(this.unit.getXMLDescription());
	writer.close();
    }
    
    public boolean updateUnit()
    {}
}

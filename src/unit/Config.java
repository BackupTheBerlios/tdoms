package unit;
/*
  ce qu'il reste a faire:
  -compl?ter cette classe
 */
public class Config
{
    private static String application_path;
    
    public Config(String application_path)
    {
	this.application_path = application_path;
    }
    
    /**
     * Returns the application's absolute path.
     */
    public String getAbsoluteApplicationPath()
    { return this.application_path; }
}

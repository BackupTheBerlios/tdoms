import java.security.InvalidParameterException;

public class Exercise extends SingleUnit
{
    private String correction;//To add images to the correction, use the SingleUnit class
    
    public Exercise(String correction)
    {
	if(correction != null) this.correction = correction;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    public Exercise() {}
    
    public void setCorrection(String correction)
    {
	if(correction != null) this.correction = correction;
	else throw new InvalidParameterException("Parameter mustn't be null");
    }
    
    public String getCorrection()
    { return this.correction; }
}

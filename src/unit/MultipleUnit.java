public abstract class MultipleUnit extends Unit
{
    abstract public boolean    addSingleUnit(SingleUnit u);
    abstract public void       addSingleUnit(int index, SingleUnit u);
    
    abstract public SingleUnit removeSingleUnit(int index);
    
    abstract public SingleUnit getSingleUnit(int index);
    abstract public void       setSingleUnit(int index, SingleUnit u);
    
    /**
     * Returns the description of a unit in the XML form.
     */
    public abstract String getXMLDescription();
    
    public abstract String getTeachingLocation();
}

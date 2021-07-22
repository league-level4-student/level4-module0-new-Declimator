package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot negative. All negative parameters should set
     * itemsReceived to 0.
     */

    protected int itemsReceived;
    
    public int getItemsReceived() {
    	return itemsReceived; 
    }
    
    public void setItemsReceived(int item) {
    	if(item >= 0)
    		itemsReceived = item;
    	else
    		itemsReceived = 0;
    }
    
    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */
   
    protected double degreesTurned;
    
    public double getDegreesTurned() {
    	return degreesTurned;
    }
    public void setDegreesTurned(double degrees) {
    	if(degrees < 0)
    		degrees = 0;
    	else if(degrees > 360)
    		degrees = 360;
    	degreesTurned = degrees;
    }
    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    protected String nomenclature;
    
    public String getNomenclature() {
    	return nomenclature;
    }
    
    public void setNomenclature(String nomenclature) {
    	if(nomenclature.isEmpty())
    		nomenclature = " ";
    	this.nomenclature = nomenclature;
    }
    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    protected Object memberObj;
    
    public Object getMemberObj() {
    	return memberObj;
    }
    public void setMemberObj(Object obj) {
    	if(obj instanceof String) {
    		obj = new Object();
    	}
    	memberObj = obj;
    }
}

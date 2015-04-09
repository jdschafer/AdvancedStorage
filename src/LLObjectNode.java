/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      CRefUnsortedList.java
 *@included     N/A
 */

public class LLObjectNode {
    
    private LLObjectNode link;
    private Object info;
    
    public LLObjectNode(Object info) {
        this.info = info;
        link = null;
    }
    
    //Sets the value of info to the value passed the method
    public void setInfo(Object info) {
        this.info = info;
    }
    
    //Returns the info value
    public Object getInfo() {
        return info;
    }
    
    //Sets the value of link to the LLObjectNode passed to it
    public void setLink(LLObjectNode link) {
        this.link = link;
    }
    
    //Returns the LLObjectNode saved in the link variable
    public LLObjectNode getLink() {
        return link;
    }
}
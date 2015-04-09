/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      UnsortedListInterface.java
 *@included     N/A
 */

public class CRefUnsortedList implements UnsortedListInterface {
    
    protected LLObjectNode list;
    protected int numElements;
    protected boolean found;
    protected LLObjectNode location;
    protected LLObjectNode previous;
    protected LLObjectNode currentPos;
    
    public CRefUnsortedList() {
        list = null;
        numElements = 0;
        found = false;
        location = null;
        previous = null;
        currentPos = null;
    }
    
    //Returns number of elements in the list
    public int size() {
        return numElements;
    }
    
    //Finds the requested element and then sets location to its location
    protected void find(Object target) {
        boolean moreToSearch;
        location = list;
        found = false;
        
        moreToSearch = (location != null);
        while(moreToSearch && !found)
        {
            previous = location;
            location = location.getLink();
            
            if(location.getInfo().equals(target))
                found = true;
            
            moreToSearch = (location != list);
        }
    }
    
    //Returns if the list contains the target element
    public boolean contains(Object element) {
        find(element);
        return found;
    }
    
    //Returns a string of the contents of the list
    public String toString() {
        String listString = "List:\n";
        if(list != null)
        {
            LLObjectNode prevNode = list;
            do
            {
                listString = listString + " " + prevNode.getLink().getInfo() 
                        + "\n";
                prevNode = prevNode.getLink();
            }
            while(prevNode != list);
        }
        return listString;
    }
    
    //Removes the target element from the list and returns true
    //Otherwise returns false
    public boolean remove(Object element) {
        find(element);
        if(found)
        {
            if(list == list.getLink())
                list = null;
            else
                if(previous.getLink() == list)
                    list = previous;
                previous.setLink(location.getLink());
            numElements--;
        }
        return found;
    }
    
    //Returns the requested object
    public Object get(Object element) {
        find(element);
        if(found)
            return location.getInfo();
        else
            return null;
    }
    
    //Resets the location in the list to start a new iteration
    public void reset() {
        if(list != null)
            currentPos = list.getLink();
    }
    
    //Returns the next object in the list
    public Object getNext() {
        Object next = currentPos.getInfo();
        currentPos = currentPos.getLink();
        
        return next;
    }
    
    //Adds the new element to the list
    public void add(Object element) {
        LLObjectNode newNode = new LLObjectNode(element);
        if(list == null)
        {
            list = newNode;
            newNode.setLink(list);
        }
        else
        {
            newNode.setLink(list.getLink());
            list.setLink(newNode);
            list = newNode;
        }
        
        numElements++;
    }

}

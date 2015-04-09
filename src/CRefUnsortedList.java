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
    
    public int size() {
        return numElements;
    }
    
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

    public boolean contains(Object element) {
        find(element);
        return found;
    }
    
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

    public Object get(Object element) {
        find(element);
        if(found)
            return location.getInfo();
        else
            return null;
    }

    public void reset() {
        if(list != null)
            currentPos = list.getLink();
    }

    public Object getNext() {
        Object next = currentPos.getInfo();
        currentPos = currentPos.getLink();
        
        return next;
    }

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

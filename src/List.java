/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      SortedList.java, UnsortedList.java 
 *@included     N/A
 */

public class List {
    protected final int DEFCAP = 100;
    protected int origCap;
    protected Object[] list;
    protected int numElements;
    protected int currentPos;
    protected int compares;
    
    protected boolean found;
    protected int location;
    
    public List() {
        list = new Object[DEFCAP];
        origCap = DEFCAP;
        compares = 0;
        numElements = 0;
    }
    
    public List(int origCap) {
        list = new Object[origCap];
        this.origCap = origCap;
        compares = 0;
        numElements = 0;
    }
    
    //Increases the size of the list if it hits capacity
    protected void enlarge() {
        Object[] larger = new Object[list.length + origCap];
        
        for(int i = 0; i < numElements; i++) {
            larger[i] = list[i];
        }
        
        list = larger;
    }
    
    //Searches for an object and then saves it's index under location
    protected void find(Object target) {
        boolean moreToSearch;
        location = 0;
        found = false;
        moreToSearch = (location < numElements);
        while (moreToSearch && !found) {
            if(((Person)list[location]).equals((Person)target)) {
                found = true;
                compares++;
            }
            else {
                location++;
                moreToSearch = (location < numElements);
                compares++;
            }
        }
    }
    
    //Returns the number of elements in the list
    public int size() {
        return numElements;
    }
    
    //Returns true if the list contains the object and false if not
    public boolean contains(Object element) {
        find(element);
        return found;
    }
    
    //Removes the desired object from the list and returns true if done and
    //false if not
    public boolean remove(Object element) {
        find(element);
        if(found) {
            for(int i = location; i <= numElements - 2; i++)
                list[i] = list[i + 1];
            list[numElements - 1] = null;
            numElements--;
        }
        return found;
    }
    
    //Returns a string of the contents in the list
    public String toString() {
        String listString = "List:\n";
        for(int i = 0; i < numElements; i++)
            listString = listString + list[i] + "\n";
        return listString;
    }
    
    //Resets the current position counter used in the getNext method
    public void reset() {
        currentPos = 0;
    }
    
    //Returns the next object in the list
    public Object getNext() {
        Object next = list[currentPos];
        if(currentPos == (numElements - 1))
            currentPos = 0;
        else
            currentPos++;
        return next;
    }
    
}
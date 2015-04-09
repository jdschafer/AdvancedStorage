/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      CRefUnsortedList
 *@included     N/A
 */

public interface UnsortedListInterface {
    
    int size();
    //Returns number of elements
    
    boolean contains(Object element);
    //Returns true of element is in list, otherwise returns false
    
    boolean remove(Object element);
    //Removes the element from the list and returns true if successful
    //Otherwise returns false
    
    Object get(Object element);
    //Returns an element e such that e.equals(element) returns true
    //Otherwise returns null
    
    String toString();
    //Returns a string containing the data held in the list
    
    void reset();
    //Resets the current position in the list to the first element to allow
    //for a new iteration through the list
    
    Object getNext();
    //Returns the next object in the list
    
    void add(Object element);
    //Adds the parameter element to the list
}

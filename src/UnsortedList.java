/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      List.java
 *@included     N/A
 */

public class UnsortedList extends List {
    
    public UnsortedList() {
        super();
    }
    
    public UnsortedList(int initSize) {
        super(initSize);
    }
    
    //Adds the object into the list and increments the number of elements
    public void add(Object element) {
        compares++;
        if(numElements == list.length)
            enlarge();
        list[numElements] = element;
        numElements++;
    }
    
    //Removes the desired object from the list if the list contains the object
    //If the list does not contain the object it returns false
    //If the list does contain the object it removes it and returns true
    public boolean remove(Object element) {
        find(element);
        if(found) {
            list[location] = list[numElements - 1];
            list[numElements - 1] = null;
            numElements--;
        }
        return found;
    }
    
}
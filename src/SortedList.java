/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      List.java
 *@included     N/A
 */

public class SortedList extends List {
    
    public SortedList() {
        super();
    }
    
    public SortedList(int initSize) {
        super(initSize);
    }
    
    //Adds the comparable element into the list after finding where it
    //fits into the sorted scheme
    public void add(Person element) {
        Person listElement;
        int location = 0;
        boolean moreToSearch;
        
        if(numElements == list.length)
            enlarge();
        
        moreToSearch = (numElements > 0);
        
        while(moreToSearch) {
            listElement = (Person)list[location];
            if(listElement.compareTo(element) < 0) {
                location++;
                moreToSearch = (location < numElements);
                compares++;
            }
            else {
                moreToSearch = false;
                compares++;
            }
        }
        
        for(int index = numElements; index > location; index--)
            list[index] = list[index - 1];
        
        list[location] = element;
        numElements++;
    }
}
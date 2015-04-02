/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      BinarySearchTree.java
 *@included     N/A
 */

public interface BSTInterface {
    //Used to specify traversal order
    static final int INORDER = 1;
    static final int PREORDER = 2;
    static final int POSTORDER = 3;
    
    boolean isEmpty();
    //Return true if this BST is empty, otherwise returns false
    
    int size();
    //Returns the number of elements on this BST
    
    boolean contains(Comparable element);
    //Returns true if this BST contains an element e such that
    //e.compareTo(element) == 0, otherwise returns false
    
    boolean remove(Comparable element);
    //Removes an element e from this BST such that e.compareTo(element) == 0
    //and returns true, if no such element exists returns false
    
    Comparable get(Comparable element);
    //Returns an element e from this BST such that e.compareTo(element) == 0
    //if no such element exists, returns null
    
    void add(Comparable element);
    //Adds element to this BST.  The tree retains its BST property
    
    int reset(int orderType);
    //Initializes current position for an iteration through this BST
    //in orderType order. Returns current number of nodes in the BST
    
    Comparable getNext(int orderType);
    //Preconditions: The BST is not empty
    //               The BST has been reset for orderType
    //               The BST has not been modified since the most recent reset
    //               The end of orderType iteration has not been reached
    //
    //Returns the element at the current position on this BST for order Type
    //and advances the value of the current position based on the orderType.
}
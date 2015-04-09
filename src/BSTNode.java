/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      BinarySearchTree.java
 *@included     N/A
 */

public class BSTNode {
    
    protected Comparable info;
    protected BSTNode left;
    protected BSTNode right;
    
    public BSTNode(Comparable info) {
        this.info = info;
        left = null;
        right = null;
    }
    
    //Sets the info variable to the target info
    public void setInfo(Comparable info) {
        this.info = info;
    }
    
    //Returns the info variable
    public Comparable getInfo() {
        return info;
    }
    
    //Sets the value of the left BSTNode
    public void setLeft(BSTNode link) {
        left = link;
    }
    
    //Sets the value of the right BSTNode
    public void setRight(BSTNode link) {
        right = link;
    }
    
    //Returns the left BSTNode
    public BSTNode getLeft() {
        return left;
    }
    
    //Returns the right BSTNode
    public BSTNode getRight() {
        return right;
    }
    
}
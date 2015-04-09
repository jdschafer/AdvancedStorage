/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      BSTNode.java, BSTInterface.java
 *@included     N/A
 */

public class BinarySearchTree implements BSTInterface {
    
    protected BSTNode root;
    boolean found;
    int compares;
    
    protected Queue inOrderQueue;
    protected Queue preOrderQueue;
    protected Queue postOrderQueue;
    
    public BinarySearchTree() {
        root = null;
        compares = 0;
    }
    
    //Returns true if the tree is empty,  otherwise returns false
    public boolean isEmpty() {
        return (root == null);
    }
    
    //Returns the number of nodes in the tree
    public int size() {
        return recSize(root);
    }
    
    //Returns the number of nodes in the tree
    private int recSize(BSTNode tree) {
        if(tree == null) 
            return 0;
        else
            return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
    }
    
    //Returns true if the target element is in the tree
    public boolean contains(Comparable element) {
        return recContains(element, root);
    }
    
    //Returns true if the target element is in the tree
    private boolean recContains(Comparable element, BSTNode tree) {
        if (tree == null)
            return false;
        else if(element.compareTo(tree.getInfo()) < 0)
            return recContains(element, tree.getLeft());
        else if(element.compareTo(tree.getInfo()) > 0)
            return recContains(element, tree.getRight());
        else 
            return true;
    }

    //Returns true if the target element was in the list and was removed
    //Otherwise returns false
    public boolean remove(Comparable element) {
        root = recRemove(element,root);
        return found;
    }
    
    //Returns true if the target element was in the list and was removed
    //Otherwise returns false
    private BSTNode recRemove(Comparable element, BSTNode tree) {
        if (tree == null)
            found = false;
        else if(element.compareTo(tree.getInfo()) < 0)
            tree.setLeft(recRemove(element, tree.getLeft()));
        else if(element.compareTo(tree.getInfo()) > 0)
            tree.setRight(recRemove(element, tree.getRight()));
        else 
        {
            tree = removeNode(tree);
            found = true;
        }
        return tree;
    }
    
    //Returns the node to replace the removed one
    private BSTNode removeNode(BSTNode tree) {
        Comparable data;
        
        if(tree.getLeft() == null)
            return tree.getRight();
        else if(tree.getRight() == null)
            return tree.getLeft();
        else
        {
            data = getPredecessor(tree.getLeft());
            tree.setInfo(data);
            tree.setLeft(recRemove(data, tree.getLeft()));
            return tree;
        }
    }
    
    //Returns the target node's predecessor
    private Comparable getPredecessor(BSTNode tree) {
        while(tree.getRight() != null)
            tree = tree.getRight();
        return tree.getInfo();
    }

    //Returns the target element within the tree
    public Comparable get(Comparable element) {
        return recGet(element, root);
    }
    
    //Returns the target element within the tree
    private Comparable recGet(Comparable element, BSTNode tree) {
        if (tree == null)
            return null;
        else if(element.compareTo(tree.getInfo()) < 0)
            return recGet(element, tree.getLeft());
        else if(element.compareTo(tree.getInfo()) > 0)
            return recGet(element, tree.getRight());
        else 
            return tree.getInfo();
    }
    
    //Adds the target element to the Binary Search Tree
    public void add(Comparable element) {
        root = recAdd(element, root);
    }
    
    //Adds the target element to the Binary Search Tree
    private BSTNode recAdd(Comparable element, BSTNode tree) {
        if(tree == null) {
            compares++;
            tree = new BSTNode(element);
        }
        else if(element.compareTo(tree.getInfo()) <= 0) {
            compares++;
            tree.setLeft(recAdd(element, tree.getLeft()));
        }
        else {
            compares++;
            tree.setRight(recAdd(element, tree.getRight()));
        }
        return tree;
    }
    
    //Initializes current position for an iteration through this BST
    //in orderType order.  Returns current number of nodes in the BST
    public int reset(int orderType) {
        int numNodes = size();
        if(orderType == INORDER)
        {
            inOrderQueue = new Queue(numNodes);
            inOrder(root);
        }
        else
        if(orderType == PREORDER)
        {
            preOrderQueue = new Queue(numNodes);
            preOrder(root);
        }
        if(orderType == POSTORDER)
        {
            postOrderQueue = new Queue(numNodes);
            preOrder(root);
        }
        return numNodes;
    }
    
    //Initializes inOrderQueue with tree elements in inOrder order
    private void inOrder(BSTNode tree) {
        if(tree != null) 
        {
            inOrder(tree.getLeft());
            inOrderQueue.enQueue(tree.getInfo());
            inOrder(tree.getRight());
        }
    }
    
    //Initializes preOrderQueue with tree elements in preOrder order
    private void preOrder(BSTNode tree) {
        if(tree != null) 
        {
            preOrderQueue.enQueue(tree.getInfo());
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }
    
    //Initializes postOrderQueue with tree elements in postOrder order
    private void postOrder(BSTNode tree) {
        if(tree != null) 
        {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            postOrderQueue.enQueue(tree.getInfo());
        }
    }

    //Returns the element at the current position on this BST for orderType 
    //and advances the value of the current position based on the orderType
    public Comparable getNext(int orderType) {
        if(orderType == INORDER)
            return (Comparable)inOrderQueue.deQueue();
        else
        if(orderType == PREORDER)
            return (Comparable)preOrderQueue.deQueue();
        else
        if(orderType == POSTORDER)
            return (Comparable)postOrderQueue.deQueue();
        else return null;
    }

}
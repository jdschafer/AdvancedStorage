/*@author       Justin Schafer
 *@id           jdschafer
 *@course       CSIS 252
 *@assignment   Advanced Storage Lab 5
 *@related      BinarySearchTree.java,SSNGenerator.java, List.java
 *@included     N/A
 */

public class Storage {
    
    private static SSNGenerator SSNGen;
    private UnsortedList unsortedList;
    private SortedList sortedList;
    private BinarySearchTree BSTree;
    private CRefUnsortedList CRefList;
    private static Storage storage;
    
    public Storage() {
        SSNGen = new SSNGenerator();
        unsortedList = new UnsortedList();
        sortedList = new SortedList();
        BSTree = new BinarySearchTree();
        CRefList = new CRefUnsortedList();
    }
    
    public static void main(String[] args) {
        storage = new Storage();
        storage.runUnsorted();
        storage.runSorted();
        storage.runBSTree();
        storage.runCRefList();
    }

    private void runCRefList() {
        // TODO Auto-generated method stub
        
    }

    private void runBSTree() {
        // TODO Auto-generated method stub
        
    }

    private void runSorted() {
        // TODO Auto-generated method stub
        
    }

    private void runUnsorted() {
        // TODO Auto-generated method stub
        
    }
    
}

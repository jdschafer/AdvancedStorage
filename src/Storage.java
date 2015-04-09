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
        for(int i = 0; i < 20; i++) {
            handleCRef();
        }
        
        System.out.println("Compares for CRefList after 20 add's: " 
                            + CRefList.compares);
    }
    
    private void handleCRef() {
        Person person = new Person(SSNGen.getRandom(),"name", "email");
        CRefList.add(person);
    }

    private void runBSTree() {
        for(int i = 0; i < 20; i++) {
            handleBSTree();
        }
        
        System.out.println("Compares for Binary Search Tree after 20 add's: "
                            + BSTree.compares);
    }
    
    private void handleBSTree() {
        Person person = new Person(SSNGen.getRandom(),"name", "email");
        BSTree.add(person.getSSN());
    }

    private void runSorted() {
        for(int i = 0; i < 20; i++) {
            handleSorted();
        }
        
        System.out.println("Compares for Sorted List after 20 add's: "
                + sortedList.compares);
    }

    private void handleSorted() {
        Person person = new Person(SSNGen.getRandom(),"name", "email");
        sortedList.add(person);
    }

    private void runUnsorted() {
        for(int i = 0; i < 20; i++) {
            handleUnsorted();
        }
        
        System.out.println("Compares for Unsorted List after 20 add's: "
                + unsortedList.compares);
    }

    private void handleUnsorted() {
        Person person = new Person(SSNGen.getRandom(),"name", "email");
        unsortedList.add(person);
    }
    
}

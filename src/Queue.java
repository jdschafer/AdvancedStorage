/** Queue.java stores the nodes info when processing the BST for 
  * inorder, preorder, or postorder
  *
  * @author			Justin Schafer
  * @id				jdschafer
  * @course			Programming 2 CSIS 252
  * @assignment		Lab 5 Advanced Storage
  * @related		BinarySearchTree.java
  * @included		
  */

public class Queue {
    protected int head;
    protected int tail;
    protected Object[] queue;
    protected final int MAX = 1000;
    protected int origCap;
    protected int elements;
    
    public Queue() {
        queue = new Object[MAX];
        origCap = MAX;
    	head = 0;
        tail = -1;
        elements = 0;
    }
    
    public Queue(int cap) {
        queue = new Object[cap];
        origCap = cap;
        head = 0;
        tail = -1;
        elements = 0;
    }
    
    //Adds the target item to the end of the queue
    public void enQueue(Object item) {
    	if(queue.length == elements)
    		grow();
    	tail = tail + 1 % queue.length;
    	queue[tail] = item;
    	elements = elements + 1;
    }
    
    //Returns the front of the queue
    public Object deQueue() {
    	if(isEmpty()) 
    	    return null;
        Object copy = queue[head];
    	queue[head] = null;
    	head = head + 1 % queue.length;
    	elements = elements - 1;
    	return copy;
    }
    
    //Expands the queue in case the queue reaches its size limit
    public void grow() {
    	Object[] grown = new Object[queue.length + origCap];
    	int currSmaller = head;
    	for(int currLarger = 0; currLarger < elements; currLarger ++) {
    		grown[currLarger] = queue[currSmaller];
    		currSmaller = currSmaller++ % queue.length;
    	}
    	
    	queue = grown;
    	head = 0;
    	tail = elements - 1;
    }
    
    //Returns true if the queue is empty, otherwise returns false
    public boolean isEmpty() {
        if(elements == 0)
            return true;
        else return false;
    }
    
}
/*
 * Author: Author: Jake Russell & Hector U Landero
 * Date: 10/3/2024
 * This class implments a generic singly linked list extending the ListADT class.
 */
public class GenericList<E> extends ListADT<E> {
    private Node<E> head;
    private int numImages;
    
    /**
     * This constructor creats an empty GenericList, initializing the head to null and the number of elements to zero. 
     */
    public GenericList() {
        this.head = null; // The first node in the linked list.
        this.numImages = 0; // The number of elements in the list.
    }

    /**
     * This method checks if the list is empty.
     * @return - (true) If the list contains no elements, return true; false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (this.numImages == 0);
    }//End of 'isEmpty'.

    /**
     * This method returns the number of elements in the list.
     * @return - The total number of elements (images) in the list.
     */
    @Override
    public int size() {
        return this.numImages;
    }//End of 'size'.

    /**
     * This method removes all elements from the list, reseting the head to null and the size to zero.
     */
    @Override
    public void removeAll() {
        this.head = null;
        this.numImages = 0;
    }//End of 'removeAll'.

    /**
     * This method adds an element at a specified index in the list.
     * @param index - The position to add the element.
     * @param item - The element to be added.
     * @throws ListException - If the index is out of range.
     */
    @Override
    public void add(int index, E item) throws ListException {
        if(index < 0 || index > this.size()) {
            throw new ListException("Index " + index + " is out of range for a list of size " + this.size());
        }

        Node<E> newNode = new Node<E>(item);
        
        if(index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        else {
            Node<E> preImage = this.getNodeAt(index - 1);
            Node<E> nextImage = preImage.getNext();
        
            preImage.setNext(newNode);
            newNode.setNext(nextImage);
        }
        this.numImages++;
    }//End of 'add'.

    /**
     * This method gets the node at a specified index.
     * @param index - The index of the node to get.
     * @return - The node at the specified index.
     */
    private Node<E> getNodeAt(int index) {
        Node<E> imageNode = this.head;
        
        for(int i = 1; i <= index; i++) {
            imageNode = imageNode.getNext();
        }
        return imageNode;
    }//End of 'getNodeAt'.

    /**
     * This method gets an element at a specified index.
     * @param index - The index of the element to get.
     * @return - The element at the specified index.
     * @throws ListException - If the index is out of range.
     */
    @Override
    public E get(int index) throws ListException {
        if(index < 0 || index >= this.size()) {
            throw new ListException("Index " + index + " is out of range for a list of size " + this.size());
        }
        Node<E> nodeImage = this.getNodeAt(index);
        return nodeImage.getItem();
    }//End of 'get'.

    /**
     * This method removes the element at a specified index from the list.
     * @param index - The index of the element to remove.
     * @throws ListException - If the index is out of range.
     */
    @Override
    public void remove(int index) throws ListException {
        if(index < 0 || index >= this.size()) {
            throw new ListException("Index " + index + " is out of range for a list of size " + this.size());
        }
    
        if(index == 0) {
            this.head = this.head.getNext();
        }

        else {
            Node<E> previousImage = this.getNodeAt(index - 1);
            Node<E> imageNodeToRemove = previousImage.getNext();
            Node<E> futureImage = imageNodeToRemove.getNext();
        
            previousImage.setNext(futureImage);
            imageNodeToRemove.setNext(null);
        }   
        this.numImages--;
    }//End of 'remove'.

    /**
     * This method returns a string representation of the list.
     * @return - A string containing all elements in the list.
     */
    @Override
    public String toString() {
        String s = "[";
        if(!this.isEmpty()) {
            Node<E> currentImage = this.head;
            for(int i = 0; i < this.size() - 1; i++) {
                s = s + currentImage.getItem().toString() + ", "; 
                currentImage = currentImage.getNext();
            }
            s = s + currentImage.getItem().toString();
        }
        return s + "]";
    }//End of 'toString'.
}//End of 'GenericList' Class.

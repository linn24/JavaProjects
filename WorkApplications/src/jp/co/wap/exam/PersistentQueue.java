/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.wap.exam;

import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
 * @param <E>
 */
public class PersistentQueue<E> {
    //use linked list instead of array list
    // since linked list is a better choice when insertion and deletion are frequent.
    private LinkedList<E> queue;
    
    /**
     * requires default constructor
     */
    public PersistentQueue(){
        //TODO: implement if necessary
        this.queue = new LinkedList<E>();        
    }
    
    public PersistentQueue(LinkedList<E> queue){
        this.queue = new LinkedList<E>(queue);
    }
    
    /**
     * Returns the queue that adds an item into the tail of this queue without modifying this queue.
     * <pre>
     * e.g.
     *  When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue,
     *  this method returns a new queue (2,1,2,2,6,4)
     *  and this object still represents the queue (2,1,2,2,6).
     * </pre>
     * If the element e is null, throws IllegalArgumentExcepttion.
     * @parram e
     * @return
     * @throws IllegalArgumentException
     */
    public PersistentQueue<E> enqueue(E e){
        //TODO: implement this method
        if (e == null){
            throw new IllegalArgumentException();
        }
        queue.add(e);
        return new PersistentQueue<E>(queue);        
    }
    
    /**
     * Returns the queue that removes the object at the head of this queue without modifying this queue.
     * <pre>
     * e.g.
     *  When this queue represents the queue (7,1,3,3,5,1),
     *  this method returns a new queue (1,3,3,5,1)
     *  and this object still represents the queue (7,1,3,3,5,1).
     * </pre>
     * If this queue is empty, throws java.util.NoSuchElementExcepttion.
     * @return
     * @throws java.util.NoSuchElementExcepttion
     */
    public PersistentQueue<E> dequeue(){
        //TODO: implement this method
        if (queue.isEmpty()){
            throw new NoSuchElementException();
        }
        queue.removeFirst();
        return new PersistentQueue<E>(queue);
    }
    
    /**
     * Looks at the object which is the head of this queue without removing it from the queue.
     * <pre>
     * e.g.
     *  When this queue represents the queue (7,1,3,3,5,1),
     *  this method returns 7 and this object still represents the queue (7,1,3,3,5,1)
     * </pre>
     * If the queue is empty, throws java.util.NoSuchElementException.
     * @return
     * @throws java.util.NoSuchElementException
     */
    public E peek(){
        //TODO: implement this method
        if (queue.isEmpty()){
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }
    
    /**
     * Returns the number of objects in this queue.
     * @return
     */
    public int size(){
        //TODO: implement this method
        return queue.size();
    }
    
    
    public void print(){
        queue.print();
    }
}

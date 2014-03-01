/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.wap.exam;

/**
 *
 * @param <E>
 */
public class LinkedList<E> {
    private Node<E> head, tail;
    private int size = 0;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public LinkedList(LinkedList<E> lst){
        this.head = lst.head;
        this.tail = lst.tail;
        this.size = lst.size;
    }
    
    public void add(E e){
        Node<E> temp = new Node<E>();
        temp.node = e;
        if (head == null){
            head = temp;
            tail = temp;
            size = 1;
        }else if (head != null && size == 1){            
            head.next = temp;
            tail = temp;
            size++;
        }else{
            tail.next = temp;
            tail = tail.next;
            size++;
        }
    }
    
    
    public void removeFirst(){
        if (head != null){
            Node<E> temp = head.next;
            head = temp;
            size--;
        }
    }
    
    public E getFirst(){
        if (head != null){
            return head.node;
        }
        return null;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public void print(){
        Node<E> curr = new Node<E>();
        curr = head;
        System.out.print(curr.node.toString());
        for (int i = 1; i < size; i++){
            curr = curr.next;
            System.out.print(", " + curr.node.toString());            
        }
        System.out.println("");
    }
    
}

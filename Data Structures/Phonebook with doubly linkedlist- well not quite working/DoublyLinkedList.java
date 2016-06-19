/*
 * Phone Book
 * Data Structures SOFE 2715U
 * Assignment 2: 
 * Group members : Mahesh, Ranaweera
 * Date	  : February 11, 2016
 * Code Description : This code is developed to create a phonebook
 * 					  using doubly linked lists. Program allows user 
 * 					  to add, remove, view contacts from a text file.
 */

package DoubleLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
 
    private Node header;
    private Node trailer;
    private int size=0;
     
    private class Node {
        E e; //element
        Node next;
        Node prev;
 
        public Node(E element, Node next, Node prev) 
        {
            this.e = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() 
    { 
    	return size; 
    }
     
    public boolean isEmpty() 
    { 
    	return size == 0; 
    }
     
    public void addFirst(E e) 
    {
        Node temp = new Node(e, header, null);
        if(header != null ) 
        {
        	header.prev = temp;
        }
        header = temp;
        if(trailer == null) 
        { 
        	trailer = temp;
        }
        size++;
        //System.out.println("adding: "+e);
    }
     
    public void addLast(E e) {
         
        Node temp = new Node(e, null, trailer);
        if(trailer != null) 
        {
        	trailer.next = temp;
        }
        trailer = temp;
        if(header == null) 
        { 
        	header = temp;
        }
        size++;
        //System.out.println("adding: "+e);
    }
     
    public void displayList(){
         
        //System.out.println("Displaying contacts");
        Node temp = header;
        while(temp != null){
            System.out.println(temp.e);
            temp = temp.next;
        }
    }
     
    /*
    public void iterateBackward(){
         
        System.out.println("iterating backword..");
        Node temp = trailer;
        while(temp != null){
            System.out.println(temp.e);
            temp = temp.prev;
        }
    }
    */
     
    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node temp = header;
        header = header.next;
        header.prev = null;
        size--;
        System.out.println("deleted: "+temp.e);
        return temp.e;
    }
     

    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node temp = trailer;
        trailer = trailer.prev;
        trailer.next = null;
        size--;
        System.out.println("deleted: "+temp.e);
        return temp.e;
    }
}


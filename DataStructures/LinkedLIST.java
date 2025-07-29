import java.util.LinkedList;

public class LinkedLIST {
    public static void main(String[] args) {
        //BASIC USE CASES AND HOW TO USE A LINKED LIST :3

        LinkedList<String> list = new LinkedList<>();

        //ADD ELEMENTS
        list.add("apple");                  //adds to end
        list.addFirst("banana");            //adds to beginning
        list.addLast("orange");             //adds to end
        
        //ACCESS ELEMENTS
        System.out.println(list.getFirst());              //prints the first element banana
        System.out.println(list.getLast());               //prints the LAST element (orange)
        System.out.println(list.get(1));            //prints the first(1) index (apple)
        

        //REMOVING ELEMENTS
        list.removeFirst();             //removes banana
        list.removeLast();              //removes orange
        list.remove("apple");         //finds the element specified and removes it from the list 

        //SIZE AND CHECKS
        System.out.println(list.size());                        //returns the size of list (should be 0 as we removed everything)
        System.out.println(list.contains("apple"));           //returns boolean if the list has a specified element
    }

    class Node<T>{
        T data;
        Node<T> next;

        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    class myLinkedList<T> {
        Node<T> head;

        //add to front
        public void addFirst(T data)
        {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
        }

        //adds to end
        public void addLast(T data)
        {
            Node<T> newNode = new Node<>(data);
            if(head == null)
            {
                head = newNode;
                return;
            }

            Node<T> current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }

        //print list 
        public void printList()
        {
            Node<T> current = head;
            while(current != null)
            {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

    }
}


/**
 * NODE SYSTEM NOTES (CORE OF LINKED LIST)
 * EACH NODE HOLDS: data and a reference
 * DATA: literally a value of type T 
 * REFERENCE: reference or pointer to next node in the list
 * Lists start with a "head" node where it is literally pointing to the next node (first actual value of the list)
 * EACH NODE STRUCTURE --> [data | a reference next node] --> [data | a reference next node]
 * 
 */
package lab5.events;

/**
 * Representing the storing and sorting of events using a LinkedList.
 * Use: storing and sorting events based on time of execution time.
 */

public class EventQueue {
    LinkedList<Event> linkedList = new LinkedList<Event>();
    Node head;

    /**
     * Representing the Node class used within the LinkedList to contain events.
     * Use: store and keep track of events within the LinkedList.
     */
    private class Node{
        Node next;
        Object Event;

        /**
         * The Constructor
         * @param Event used to store specific events within nodes.
         */
        public Node (Object Event){
            this.Event = Event;
        }

    }

    /**
     * Creates a node last in the LinkedList, assigned with given event.
     * @param Event used to store specific events within nodes.
     */
    public void addLast(Object Event){
       if(head == null){
           head = new Node(Event);
           return;
       }
       Node current = head;
       while(current.next != null){
            current = current.next;
       }
       current.next = new Node(Event);
    }

    /**
     * Creates a node first in the LinkedList, assigned with given event.
     * @param Event used to store specific events within nodes.
     */
    public void addFirst(Object Event){
        Node newHead = new Node(Event);
        newHead.next = head;
        head = newHead;
    }

    /**
     * Removes first node in the LinkedList.
     */
    public void removeFirst(){
        head = head.next;
        return;
    }
    
    /**
     * Removes first node in the LinkedList.
     */
    public void removeFirst(){
        head = head.next;
        return;
    }

    /**
     * Gets next event in linkedList
     */
    public Event getFirstEvent(){ 
        return linkedList.getFirst();
    }

    public boolean hasEvent(){
        return false;
        //TODO: Checks if the linked list has a next event. 
    }

}




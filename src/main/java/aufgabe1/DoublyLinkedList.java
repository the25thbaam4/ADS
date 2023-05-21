package aufgabe1;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtEnd(VideoGame gameInput) {
        Node newCreatedNode = new Node(gameInput);
        if (isEmpty()) {
            head = newCreatedNode;
            tail = newCreatedNode;
        } else {
            newCreatedNode.prev = tail;
            tail.next = newCreatedNode;
            tail = newCreatedNode;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.game + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    public void sortByPriority() {
    }

}

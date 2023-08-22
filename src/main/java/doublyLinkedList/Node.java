package doublyLinkedList;

public class Node {
    public Node prev;
    public Node next;

    public VideoGame game;

    public Node(VideoGame someGame){
        this.game = someGame;
        this.next = null;
        this.prev = null;
    }
}

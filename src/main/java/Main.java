import aufgabe1.DoublyLinkedList;
import aufgabe1.VideoGame;

public class Main{
    public static void main(String[]args){

        VideoGame ne = new VideoGame("god",9.5,2015);
        VideoGame me = new VideoGame("some", 7.1,2016);
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(ne);
        list.display();
        System.out.println(ne.getGamesName());
        list.insertAtEnd(me);
        System.out.println();
        list.display();

    }
}
import aufgabe1.DoublyLinkedList;
import aufgabe1.VideoGame;

public class Main{
    public static void main(String[]args){

        VideoGame ne = new VideoGame("god",23,2015,10);
        VideoGame me = new VideoGame("some", 29.00, 2016,9.1);
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(ne);
       // list.display();

        list.insertAtEnd(me);


        //list.display();
        VideoGame de = new VideoGame("second one after ome",24.919,2020,10.1);
        list.insertAtEnd(de);
      //  list.display();
       // System.out.println(me);
      //System.out.println(ne);
      //  System.out.println(de);

     //   list.addGame();

      //
        VideoGame gamess = new VideoGame("h3ello",29.99, 2022, 9.9);

        list.insertAtEnd(gamess);

        list.display();

        list.editGameAttribute(de);
        list.display();



    }
}
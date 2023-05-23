package aufgabe1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int counter;
    Scanner sc = new Scanner(System.in);

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.counter = 1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtEnd(VideoGame gameInput) {
        Node newCreatedNode = new Node(gameInput);
        newCreatedNode.game.setId(counter++);
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
            System.out.println("The list is empty!");

        }
        System.out.println(String.format("%-4s | %-35s\t\t\t | %9s\t | %17s\t | %2s","ID", "Game's Name  ", "Price ", "Year of release", "Rating"));
        System.out.println("_____________________________________________________________________________________________________");

        Node currentNode = head;
        while (currentNode != null) {
            VideoGame game = currentNode.game;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.printf("%-4s | %-35s\t\t\t | %9s\t | %17d\t | %6.1f%n",
                    game.getId(),
                    game.getGamesName(),
                     df.format(game.getPrice()) +" €" ,
                    game.getYearOfRelease(),
                    game.getRating()
            );
            currentNode = currentNode.next;


        }

    }

    public void addGame(){
        System.out.println("Please Enter Name of the game, its Price, year of release and rating");
      String  gameName = sc.nextLine();
        DecimalFormat df = new DecimalFormat("#.00");
        double price = (sc.nextDouble());
      // price = Double.parseDouble(df.format(price));
        int releaseYear = sc.nextInt();
         double rating = sc.nextDouble();

        VideoGame newGame = new VideoGame(gameName, price, releaseYear , rating);
        insertAtEnd(newGame);

    }



}

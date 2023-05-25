package aufgabe1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
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
        System.out.printf("%-4s | %-35s\t\t\t | %9s\t | %17s\t | %2s%n", "ID", "Game's Name  ", "Price ", "Year of release", "Rating");
        System.out.println("_____________________________________________________________________________________________________");

        Node currentNode = head;
        while (currentNode != null) {
            VideoGame game = currentNode.game;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.printf("%-4s | %-35s\t\t\t | %9s\t | %17d\t | %6.1f%n",
                    game.getId(),
                    game.getGamesName(),
                    df.format(game.getPrice()) + " €",
                    game.getYearOfRelease(),
                    game.getRating()
            );
            currentNode = currentNode.next;


        }

    }

    public void addGame() {
        System.out.println("Please Enter Name of the game, its Price, year of release and rating");
        String gameName = sc.nextLine();
        DecimalFormat df = new DecimalFormat("#.00");
        double price = (sc.nextDouble());
        // price = Double.parseDouble(df.format(price));
        int releaseYear = sc.nextInt();
        double rating = sc.nextDouble();

        VideoGame newGame = new VideoGame(gameName, price, releaseYear, rating);
        insertAtEnd(newGame);

    }

    public void editGame(int gameId) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.game.getId() == gameId) {
                editGameAttribute(currentNode.game);
                return;
            }
            currentNode = currentNode.next;
        }
        System.out.println("The game does not exist!");
    }

    public void editGameAttribute(VideoGame gameToEdit) {


        int userChoice = -1;
        while (userChoice != 0) {
            System.out.println("Welcome to the edit menu:" + System.lineSeparator() +
                    "1. Edit Name" + System.lineSeparator() +
                    "2. Edit Price" + System.lineSeparator() +
                    "3. Edit Year of release" + System.lineSeparator() +
                    "4. Edit Rating" + System.lineSeparator() + System.lineSeparator() +
                    "0. Quit Edit Menu");
            try {
                userChoice = sc.nextInt();

                switch (userChoice) {

                    case 0:
                        System.out.println("Exiting");
                        break;

                    case 1:
                        System.out.print("Enter the new Game Name: ");
                        sc.nextLine();
                        String newGameName = sc.nextLine();
                        gameToEdit.setGamesName(newGameName);
                        break;
                    case 2:
                        System.out.print("Enter the new Price: ");
                        // DecimalFormat df = new DecimalFormat("#.00");

                        double newPrice = sc.nextDouble();
                        sc.nextLine();
                        gameToEdit.setPrice(newPrice);
                        break;
                    case 3:
                        System.out.print("Enter the new year of release: ");
                        int newReleaseYear = sc.nextInt();
                        gameToEdit.setYearOfRelease(newReleaseYear);
                        break;
                    case 4:
                        System.out.print("Enter the new Rating: ");
                        double newRating = sc.nextDouble();
                        sc.nextLine();
                        gameToEdit.setRating(newRating);

                        break;
                    default:
                        System.out.println("try again");
                        break;
                }


            } catch (InputMismatchException e) {
                System.out.println("Not a valid choice. Try again!");
                sc.nextLine();

            }
        }
    }
}






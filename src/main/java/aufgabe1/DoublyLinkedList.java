package aufgabe1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int counter;
    public static final String NEWLINE = System.getProperty("line.separator");

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
        System.out.printf("\n%-4s | %-35s\t\t\t | %9s\t | %17s\t | %2s%n", "ID", "Game's Name  ", "Price ", "Year of release", "Rating");
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

        String gameName = "";
        double price;
        int releaseYear;
        double rating;
        try {
            System.out.print("Enter the game's name: ");
            while (gameName.trim().isEmpty()) {
                gameName = sc.nextLine();
            }


            System.out.print("Enter the price: ");
            price = sc.nextDouble();


            System.out.print("Enter year of release: ");
            releaseYear = sc.nextInt();

            System.out.print("Enter rating: ");
            rating = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice try again");
            return;
        }

        VideoGame newGame = new VideoGame(gameName, price, releaseYear, rating);
        insertAtEnd(newGame);

    }

    public void editGame() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("Enter the ID of the game you want to edit: ");
        int gameId = sc.nextInt();
        sc.nextLine();
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
            System.out.println("Welcome to the edit menu:" + NEWLINE +
                    "1. Edit Name" + NEWLINE +
                    "2. Edit Price" + NEWLINE +
                    "3. Edit Year of release" + NEWLINE +
                    "4. Edit Rating" + NEWLINE + NEWLINE + Color.RED_BOLD +
                    "0. Quit Edit Menu" + Color.RESET);
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
                        System.out.print("Enter the new Price: " + NEWLINE + "Use comma, please: ");
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
                        System.out.print("Enter the new Rating: " + NEWLINE + "Use comma, please: ");
                        double newRating = sc.nextDouble();
                        sc.nextLine();
                        gameToEdit.setRating(newRating);

                        break;
                    default:
                        System.out.println("Try again");
                        break;
                }


            } catch (InputMismatchException e) {
                System.out.println("Not a valid choice. Try again!");
                sc.nextLine();

            }
        }
    }


    public void removeGame() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Enter the ID of the game you want to delete: ");
        int gameId = sc.nextInt();
        sc.nextLine();
        Node temp = head;
        while (temp != null) {
            if (temp.game.getId() == gameId) {

                if (temp == head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }
                if (temp == tail) {
                    tail = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }


        System.out.println("Game not found!");


    }

    //TODO implement Quicksort method

    public void sortList() {

        if (isEmpty()) {
            System.out.println("List is Empty.");
            return;
        } else if (head == tail) {
            System.out.println("List has only one element");
            return;
        }
        System.out.println("sorting");
        sortByPrice(head,tail);
        System.out.println("sorted");
        display();
        }


    private void sortByPrice(Node start, Node end){
        if (start != null && end != null && start != end){
            Node partitionNode = partitionByPrice(start,end);
           if (partitionNode != null) {
               sortByPrice(start, partitionNode.prev);
               sortByPrice(partitionNode.next, end);
           }
           }
    }

    private Node partitionByPrice(Node start, Node end){
        double pivot = end.game.getPrice();
        Node temp = start.prev;
        for (Node tempNext = start; tempNext != null && tempNext != end; tempNext = tempNext.next){
            if(tempNext.game.getPrice() <= pivot){
                if (temp == null ){
                    temp = start;
                }
                else {
                    temp = temp.next;
                }
                swapGames(temp, tempNext);
            }
        }
        if (temp == null){
            temp = start;
        }
        else {
            temp = temp.next;
        }
        swapGames(temp, end);
        return temp;
    }

    private void swapGames(Node node1, Node node2){
       if (node1 != null && node2 != null){


        VideoGame temp = node1.game;
        node1.game = node2.game;
        node2.game = temp;
    }}


    private void sortByName(){

    }

    public void startOperations() {

        int userInput = -1;
        while (userInput != 0) {
            System.out.println("\nWelcome to the operations menu:" + NEWLINE +
                    "1. Display the list" + NEWLINE +
                    "2. Add an element to the list" + NEWLINE +
                    "3. Edit an element in the list" + NEWLINE +
                    "4. Remove an element from the list" + NEWLINE +
                    "5. Sort list" + NEWLINE + NEWLINE + Color.RED_BOLD +
                    "0. Quit" + Color.RESET);

            try {
                userInput = sc.nextInt();

                switch (userInput) {
                    case 0 -> System.out.println("Ending the program!");
                    case 1 -> display();
                    case 2 -> addGame();
                    case 3 -> editGame();
                    case 4 -> removeGame();
                    case 5 -> sortList();
                    default -> System.out.println("Input not valid");
                }


            } catch (InputMismatchException e) {
                System.out.println("Input not valid try again!");
                sc.nextLine();
            }


        }
    }

}






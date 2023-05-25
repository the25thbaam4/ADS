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
            while(gameName.trim().isEmpty()){
                gameName = sc.nextLine();
            }


            System.out.print("Enter the price: ");
            price = sc.nextDouble();


            System.out.print("Enter year of release: ");
            releaseYear = sc.nextInt();

            System.out.print("Enter rating: ");
            rating = sc.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid choice try again");
            return;
        }

        VideoGame newGame = new VideoGame(gameName, price, releaseYear, rating);
        insertAtEnd(newGame);

    }

    public void editGame() {
        if (isEmpty()){
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
                        System.out.print("Enter the new Price: " + System.lineSeparator()+"Use comma, please: ");
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
                        System.out.print("Enter the new Rating: " + System.lineSeparator()+"Use comma, please: ");
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



    public void removeGame(){
        if (isEmpty()){
            System.out.println("List is empty");
            return;
        }

        System.out.println("Enter the ID of the game you want to delete: ");
        int gameId = sc.nextInt();
        sc.nextLine();
        Node temp = head;
        while( temp != null ){
                if(temp.game.getId() == gameId){

                    if (temp == head){
                        head = temp.next;
                        if(head != null){
                            head.prev = null;
                        }
                    }
                    else {
                        temp.prev.next = temp.next;
                        if (temp.next != null){
                            temp.next.prev = temp.prev;
                        }
                    }
                    if (temp == tail){
                        tail = temp.prev;
                    }
                    return;
                }
                temp = temp.next;
        }


        System.out.println("Game not found!");





    }

        //TODO implement sort method
    public void sortList(){
        if (isEmpty()){
            System.out.println("List is Empty;");
            return;
        }

        if (head == tail){
            System.out.println("List has only one element");
        }

    }
    public void startOperations(){

        int userInput = -1;
        while(userInput != 0){
            System.out.println("\nWelcome to the operations menu:" + System.lineSeparator() +
                    "1. Display the list" + System.lineSeparator() +
                    "2. Add an element to the list" + System.lineSeparator() +
                    "3. Edit an element in the list" + System.lineSeparator() +
                    "4. Remove an element from the list" + System.lineSeparator() + System.lineSeparator() +
                    "0. Quit");

            try {
                userInput = sc.nextInt();

                switch (userInput){

                    case 0:
                        System.out.println("Ending the program!");
                        break;
                    case 1:
                        display();
                        break;
                    case 2:
                        addGame();
                        break;
                    case 3:
                        editGame();
                        break;
                    case 4:
                        removeGame();
                    case 5:
                        sortList();

                    default:
                        System.out.println("Input not valid");
                        break;

                }




            } catch (InputMismatchException e) {
                System.out.println("Input not valid try again!");
                sc.nextLine();
            }


        }
    }

}






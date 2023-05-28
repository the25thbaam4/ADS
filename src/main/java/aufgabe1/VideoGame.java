package aufgabe1;

import java.text.DecimalFormat;

public class VideoGame implements Comparable <VideoGame> {

    private int id;
    private double price ;
    private String gamesName;
    private double rating;
    private int yearOfRelease;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price =price;
    }

    public String getGamesName() {
        return gamesName;
    }

    public void setGamesName(String gamesName) {
        this.gamesName = gamesName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getId() {
        return id;
    }

   public void setId(int id){
        this.id = id;
    }



    public VideoGame(String gamesName, double price, int yearOfRelease, double rating) {
        ++id;
        this.gamesName = gamesName;
        this.price = price;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.printf("%-4s |%-35s\t\t\t | %9s\t | %17s\t | %2s%n", "ID", " Game's Name  ", "Price ", "Year of release", "Rating");
        System.out.println("_____________________________________________________________________________________________________");

        return String.format("%-4s | %-35s\t\t\t | %9s\t | %17d\t | %6.1f",id, gamesName, df.format(price) +" €", yearOfRelease, rating) + System.lineSeparator();
    }


    @Override
    public int compareTo(VideoGame otherGame) {
        return this.gamesName.compareTo(otherGame.gamesName);
    }
}

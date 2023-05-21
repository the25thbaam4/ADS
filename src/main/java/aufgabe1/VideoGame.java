package aufgabe1;

public class VideoGame {

    private int id;
    private String gamesName;
    private double rating;
    private int yearOfRelease;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



    public VideoGame(String gamesName, double rating, int yearOfRelease) {
       // this.numberInTheList = numberInTheList;
        this.id++;
        this.gamesName = gamesName;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString(){
        return getId()+ ": Name:(" + getGamesName() +") Rating:("+ getRating() +") Year of release: ("+ getYearOfRelease() +")";
    }
}

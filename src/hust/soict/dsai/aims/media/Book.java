package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;
    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost, id);
        this.setId(id);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println(authorName + " was added to the author list");
        }
        else{
            System.out.println(authorName + " was already in the author list");
        }
    }
    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println(authorName + " was removed from the author list");
        }
        else{
            System.out.println(authorName + "doesn't exist in the author list");
        }
    }
    public String toString() {
        return ("Book" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + ": " + this.getCost() + " $");
    }
}
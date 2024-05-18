package hust.soict.dsai.aims.media;
public abstract class Disc extends Media {
    private int length;
    private String director;
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    public Disc(){}
    public Disc(String title, String category, float cost, int id) {
        super(title, category, cost, id);
    }
    public Disc(int id, String title) {
        super(id, title);
    }
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
}

package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        super(nbDigitalVideoDiscs, title);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, nbDigitalVideoDiscs);
        this.director = director;
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, nbDigitalVideoDiscs);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(title, category, cost, id);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalVideoDisc disc = (DigitalVideoDisc) o;
        return getLength() == disc.getLength() && Float.compare(getCost(),
                disc.getCost()) == 0 && getTitle().equals(disc.getTitle())
                && getCategory().equals(disc.getCategory()) && getDirector().equals(disc.getDirector());
    }
    public String toString() {
        return ("DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director
                + " - " + this.length + ": " + this.getCost() + " $");
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

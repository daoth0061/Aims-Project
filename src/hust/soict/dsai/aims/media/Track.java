package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public Track() {}

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }
    @Override
    public void play() {
        if (this.getLength() == 0) {
            System.out.println("The Track " + this.getTitle() + " has no track. Unable to play.");

        } else {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track track)) return false;
        return getLength() == track.getLength() && Objects.equals(getTitle(), track.getTitle());
    }
}

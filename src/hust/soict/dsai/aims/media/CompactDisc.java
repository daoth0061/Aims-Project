package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public String getArtist() {
        return artist;
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, float cost, int id, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, id);
        this.artist = artist;
        this.tracks = tracks;
    }
    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            System.out.println(track.getTitle() + " was added to the track list");
        }
        else{
            System.out.println(track.getTitle() + " was already in the track list");
        }
    }
    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println(track.getTitle() + " was removed from the track list");
        }
        else{
            System.out.println(track.getTitle() + "doesn't exist in the track list");
        }
    }

    @Override
    public int getLength() {
        int sum = 0;
        for (Track track: this.tracks) {
            sum += track.getLength();
        }
        return sum;
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("Artist: " + this.getArtist());
        if (this.tracks.size() > 0) {
            for (Track track: this.tracks) {
                track.play();
            }
        } else {
            System.out.println("The CD " + this.getTitle() + " has no track. Unable to play.");
        }
    }
    public String toString() {
        return ("CD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist()
                + ": " + this.getCost() + " $");
    }
}

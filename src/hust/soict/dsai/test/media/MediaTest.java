package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();
        CompactDisc cd = new CompactDisc("Best Hits", "Various Artists", 15);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Movie Title", "Director", 120);
        Book book = new Book("Java Programming", "Author", 500);
        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }

    }
}

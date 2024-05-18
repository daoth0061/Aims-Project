package hust.soict.dsai.aims.media.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int comp = title1.compareTo(title2);
        if (comp != 0) {
            return comp;
        } else {
            Double cost1 = (double) o1.getCost();
            Double cost2 = (double) o2.getCost();
            return cost1.compareTo(cost2);
        }
    }
}

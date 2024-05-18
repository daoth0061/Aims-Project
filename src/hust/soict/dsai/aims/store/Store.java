package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;
    private int itemCount = 0;
    public Store() {
        itemsInStore = new ArrayList<>();
    }
    public void addMedia(Media media) {
        itemsInStore.add(media);
        itemCount += 1;
        System.out.println("The media has been added.");

    }
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            itemCount -= 1;
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The item is not in the cart. Cannot be removed.");
        }
    }
    public void removeMedia(String title) {
        for (Media m: itemsInStore) {
            if (m.isMatch(title)) {
                itemsInStore.remove(m);
                itemCount -= 1;
                System.out.println("The media has been removed.");
                break;
            }
        }
        System.out.println("The item is not in the cart. Cannot be removed.");
    }
    public Media searchInStore(String title) {
        if (itemCount > 0) {
            for (Media item: this.itemsInStore) {
                if (item.isMatch(title)) {
                    return item;
                }
            }
        }
        return null;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemCount > 0) {
            for (int i = 0; i < itemCount; i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("***************************************************");
    }
}

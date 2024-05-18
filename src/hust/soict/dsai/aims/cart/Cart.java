package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int qtyOrdered;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Cart() {
        this.qtyOrdered = 0;
    }

    public void addMedia(Media... mediaList) {
        int i = 1;
        for (Media item: mediaList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.printf("The item number %d cannot be added. The cart is full.%n", i);
                break;
            }
            else {
                itemsOrdered.add(item);
                qtyOrdered += 1;
                System.out.printf("The item number %d has been added.%n", i);
            }
            i += 1;
        }
    }
    public void removeMedia(Media... mediaList) {
        int i = 1;
        for (Media item: mediaList) {
            if (itemsOrdered.contains(item)) {
                itemsOrdered.remove(item);
                qtyOrdered -= 1;
                System.out.printf("The item number %d has been removed.%n", i);
            } else {
                System.out.printf("The item number %d is not in the cart. Cannot be removed.%n", i);
                break;
            }
            i += 1;
        }
    }
    public void removeMedia(String title) {
        for (Media m: itemsOrdered) {
            if (m.isMatch(title)) {
                itemsOrdered.remove(m);
                qtyOrdered -= 1;
                System.out.println("The media has been removed.");
                break;
            }
        }
        System.out.println("The item is not in the cart. Cannot be removed.");
    }
    public int numberDVDsInCart() {
        int cnt = 0;
        for (Media item: itemsOrdered) {
            if (item instanceof DigitalVideoDisc) {
                cnt += 1;
            }
        }
        return cnt;
    }
    public String totalCost() {
        float totalCost = 0;
        for (Media item: this.itemsOrdered) {
            totalCost += item.getCost();
        }
        return String.format("%.2f", totalCost);
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (qtyOrdered > 0) {
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.println((i + 1) + ". " + this.itemsOrdered.get(i).toString());
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    public void searchMediaByID(int id) {
        boolean found = false;
        if (qtyOrdered > 0) {
            for (Media item: this.itemsOrdered) {
                if (item.getId() == id) {
                    System.out.println(item.toString());
                    found = true;
                }
            }
        }
        if (found == false) {
            System.out.println("No match is found for ID: " + id);
        }
    }

    public void searchMediaByTitle(String title) {
        boolean found = false;
        if (qtyOrdered > 0) {
            for (Media item: this.itemsOrdered) {
                if (item.getTitle() == title) {
                    System.out.println(item.toString());
                    found = true;
                }
            }
        }
        if (found == false) {
            System.out.println("No match is found for title: " + title);
        }
    }
    public Media searchInCart(String title) {
        if (qtyOrdered > 0) {
            for (Media m : this.itemsOrdered) {
                if (m.isMatch(title)) {
                    return m;
                }
            }
        }
        return null;
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}

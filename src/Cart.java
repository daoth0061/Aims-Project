public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) System.out.println("The disc cannot be added. The cart is full.");
        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
    }
//    add a list of DVDs to the current cart.
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        int i = 1;
//        for (DigitalVideoDisc disc: dvdList) {
//            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
//                System.out.printf("The disc number %d cannot be added. The cart is full.%n", i);
//                break;
//            }
//            else {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered += 1;
//                System.out.printf("The disc number %d has been added.%n", i);
//            }
//            i += 1;
//        }
//    }
//  passing an arbitrary number of arguments for dvd
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        int i = 1;
        for (DigitalVideoDisc disc: dvdList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.printf("The disc number %d cannot be added. The cart is full.%n", i);
                break;
            }
            else {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered += 1;
                System.out.printf("The disc number %d has been added.%n", i);
            }
            i += 1;
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) System.out.println("Dvd 1 cannot be added. The cart is full.");
        else {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered += 1;
            System.out.println("The dvd 1 has been added");
        }
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) System.out.println("Dvd 2 cannot be added. The cart is full.");
        else {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered += 1;
            System.out.println("The dvd 2 has been added");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (dvd.equals(itemsOrdered[i])) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered -= 1;
                break;
            }
        }
    }
    public String totalCost() {
        int i = 0;
        float totalCost = 0;
        while (itemsOrdered[i] != null) {
            totalCost += itemsOrdered[i].getCost();
            i ++;
        }
        return String.format("%.2f", totalCost);
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (qtyOrdered > 0) {
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    public void searchDVDByID(int id) {
        boolean found = false;
        if (qtyOrdered > 0) {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].getId() == id) {
                    System.out.println(itemsOrdered[i].toString());
                    found = true;
                }
            }
        }
        if (found == false) {
            System.out.println("No match is found for ID: " + id);
        }
    }

    public void searchDVDByTitle(String title) {
        boolean found = false;
        if (qtyOrdered > 0) {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].getTitle().equals(title)) {
                    System.out.println(itemsOrdered[i].toString());
                    found = true;
                }
            }
        }
        if (found == false) {
            System.out.println("No match is found for title: " + title);
        }
    }
}

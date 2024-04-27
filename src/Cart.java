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
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
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
    // passing an arbitrary number of arguments for dvd
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
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

}

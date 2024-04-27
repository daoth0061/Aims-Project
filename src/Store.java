public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int itemCount = 0;
    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
    }
    public void addDVD(DigitalVideoDisc dvd) {
        if (itemCount >= itemsInStore.length) System.out.println("The dvd cannot be added. The store is full.");
        else {
            itemsInStore[itemCount] = dvd;
            itemCount += 1;
            System.out.println("The dvd has been added");
        }
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (dvd.equals(itemsInStore[i])) {
                found = true;
                System.out.println("The dvd has been removed");
                for (int j = i; j < itemCount - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[itemCount - 1] = null;
                itemCount -= 1;
                break;
            }
        }
        if (found == false) {
            System.out.println("Dvd not found in the store");
        }
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemCount > 0) {
            for (int i = 0; i < itemCount; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("***************************************************");
    }
}

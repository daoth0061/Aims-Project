package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

import java.util.*;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-----------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-----------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("-----------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static String generateRandomId() {
        Random random = new Random();
        int length = 3; // Desired length of the ID
        StringBuilder idBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char digit = (char) (random.nextInt(10) + '0'); // Generate a random digit character
            idBuilder.append(digit);
        }
        return idBuilder.toString();
    }
    public static void defaultList(Store store) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation",
                19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction",
                24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.89f);

        ArrayList<String> authors1 = new ArrayList<String>();
        authors1.add("aaaaaaaa");
        Book book1 = new Book(4, "Hello World", "Action and adventure",
                25.5f, authors1);
        ArrayList<String> authors2 = new ArrayList<>();
        authors2.add("Hello it's me");
        authors2.add("Dao");
        Book book2 = new Book(5, "Hello it's me", "Young Adult",
                15.8f, authors2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
    }
    public static boolean isValidTitle(String title) {
        // Define your validation rules here
        // Example: Title must start with an uppercase letter
        return title.matches("[A-Z][a-zA-Z0-9\\s]*");
    }
    public static void main(String[] args) {
        Store store = new Store();
        defaultList(store); // add default list
        Cart cart = new Cart();

        int opt, storeOpt, mediaOpt, cartOpt, filterOpt, sortOpt;
        String title;
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        Scanner user = new Scanner(System.in);
        Media mediaStore, mediaCart;

        do {
            showMenu();
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    store.print();
                    do {
                        storeMenu();
                        storeOpt = sc.nextInt();
                        switch (storeOpt) {
                            case 1: //1. See a media’s details
                                do {
                                    System.out.print("Enter title of media: ");
                                    title = scString.nextLine(); //enter title of media want to view
                                    if (!isValidTitle(title)) System.out.println("Invalid title. Please enter a valid title.");
                                } while (!isValidTitle(title));
                                mediaStore = store.searchInStore(title); //search media
                                if (mediaStore != null) {
                                    mediaStore.toString(); //display that media detail
                                    do {
                                        mediaDetailsMenu();
                                        mediaOpt = sc.nextInt();
                                        switch (mediaOpt) {
                                            case 1: cart.addMedia(mediaStore); break;
                                            case 2:
                                                if (mediaStore instanceof DigitalVideoDisc) {
                                                    ((DigitalVideoDisc) mediaStore).play();
                                                } else if (mediaStore instanceof CompactDisc) {
                                                    ((CompactDisc) mediaStore).play();
                                                } else {
                                                    System.out.println("This media can not play !");
                                                }
                                                break;
                                            case 0: break;
                                            default: System.out.println("Option invalid !"); break;
                                        }
                                    } while (mediaOpt != 0);
                                } else {
                                    System.out.println("Media does not exits in store !");
                                }
                                break;
                            case 2: //2. Add media to cart
                                do {
                                    System.out.print("Enter title of media: ");
                                    title = scString.nextLine(); //enter title of media want to view
                                    if (!isValidTitle(title)) System.out.println("Invalid title. Please enter a valid title.");
                                } while (!isValidTitle(title));
                                mediaStore = store.searchInStore(title); //search media
                                if (mediaStore != null) {
                                    cart.addMedia(mediaStore);
                                    if(mediaStore instanceof Disc){
                                        System.out.println("Current cart has " + cart.numberDVDsInCart() + " DVDs");
                                    }
                                } else {
                                    System.out.println("Media does not exits in store");
                                }
                                break;
                            case 3: // 3. Play a media
                                do {
                                    System.out.print("Enter title of media: ");
                                    title = scString.nextLine(); //enter title of media want to view
                                    if (!isValidTitle(title)) System.out.println("Invalid title. Please enter a valid title.");
                                } while (!isValidTitle(title));
                                mediaStore = store.searchInStore(title); //search media
                                if (mediaStore != null) {
                                    if (mediaStore instanceof DigitalVideoDisc) {
                                        ((DigitalVideoDisc) mediaStore).play();
                                    } else if (mediaStore instanceof CompactDisc) {
                                        ((CompactDisc) mediaStore).play();
                                    } else {
                                        System.out.println("This media cannot be played.");
                                    }
                                } else {
                                    System.out.println("Media does not exits in store");
                                }
                                break;
                            case 4:
                                System.out.println("Current cart: ");
                                cart.print();
                                break;
                            case 0: break;
                            default: System.out.println("Option invalid"); break;
                        }
                    } while (storeOpt != 0);
                    break;

                case 2:
                    updateStoreMenu();
                    int updateOpt = user.nextInt();
                    do{
                        switch (updateOpt) {
                            case 1: // add DVD
                                System.out.println("Please insert the details of the DVD: ");
                                System.out.println("--------------------------------");
                                System.out.println("Title: ");
                                title = user.nextLine();
                                System.out.println("Category: ");
                                String category = user.nextLine();
                                System.out.println("Cost: ");
                                float cost = user.nextFloat();
                                String id = generateRandomId();
                                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost);
                                store.addMedia(dvd);
                                break;
                            case 2: //remove DVD
                                do {
                                    System.out.print("Enter title of media: ");
                                    title = scString.nextLine(); //enter title of media want to view
                                    if (!isValidTitle(title)) System.out.println("Invalid title. Please enter a valid title.");
                                } while (!isValidTitle(title));
                                store.removeMedia(title);
                                break;
                            case 0: break;
                            default: System.out.println("Invalid option!");
                        }
                        updateStoreMenu();
                        updateOpt = user.nextInt();
                    } while (updateOpt != 0);
                case 3: // 3. See current cart
                    System.out.println("Current cart");
                    cart.print();
                    do {
                        cartMenu();
                        cartOpt = sc.nextInt();
                        switch (cartOpt) {
                            case 1: // 1. Filter medias in cart
                                System.out.println("Enter 1 to filter by id or 2 to filter by title");
                                filterOpt = sc.nextInt();
                                if (filterOpt == 1) {
                                    System.out.println("Enter the id to filter");
                                    int idToFilter = sc.nextInt();
                                    cart.searchMediaByID(idToFilter);
                                } else {
                                    System.out.println("Enter the title to filter");
                                    String titleToFilter = sc.nextLine();
                                    cart.searchMediaByTitle(titleToFilter);
                                }
                                break;
                            case 2: // 2. Sort medias in cart
                                System.out.println("Enter 1 to sort by title or 2 to sort by cost");
                                sortOpt = sc.nextInt();
                                System.out.println("Current cart after sort: ");
                                if (sortOpt == 1) {
                                    cart.sortByTitle();
                                } else {
                                    cart.sortByCost();
                                }
                                cart.print();
                                break;
                            case 3:
                                do {
                                    System.out.print("Enter title of media to be removed: ");
                                    title = scString.nextLine(); //enter title of media want to remove
                                    if (!isValidTitle(title)) System.out.println("Invalid title. Please enter a valid title.");
                                } while (!isValidTitle(title));
                                store.removeMedia(title);
                                break;
                            case 4:
                                do {
                                    System.out.print("Enter title of media to be played: ");
                                    title = scString.nextLine(); //enter title of media want to play
                                    if (!isValidTitle(title)) System.out.println("Invalid title. Please enter a valid title.");
                                } while (!isValidTitle(title));
                                mediaCart = cart.searchInCart(title); //search media
                                if (mediaCart != null) {
                                    if (mediaCart instanceof DigitalVideoDisc) {
                                        ((DigitalVideoDisc) mediaCart).play();
                                    } else if (mediaCart instanceof CompactDisc) {
                                        ((CompactDisc) mediaCart).play();
                                    } else {
                                        System.out.println("This media cannot be played.");
                                    }
                                } else {
                                    System.out.println("Media does not exits in store");
                                }
                                break;
                            case 5:
                                System.out.println("An order is created!");
                                cart = new Cart(); break;
                            case 0: break;
                            default: System.out.println("Invalid option!"); break;
                        }
                    } while (cartOpt != 0);
                    break;
                case 0: break;
                default: System.out.println("Invalid option!");
            }
        } while (opt != 0);
    }
}
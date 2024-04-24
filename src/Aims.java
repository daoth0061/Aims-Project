public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        //code to test the method removeDigitalVideoDisc(DigitalVideoDisc disc)

        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.print("Total Cost after removing disc 2 is: ");
        System.out.print(anOrder.totalCost());
    }
}

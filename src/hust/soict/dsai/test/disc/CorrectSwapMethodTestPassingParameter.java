package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CorrectSwapMethodTestPassingParameter {
    public static void swap(ObjectWrapper a, ObjectWrapper b) {
        Object tmp = a.obj;
        a.obj = b.obj;
        b.obj = tmp;
    }
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        ObjectWrapper ow1 = new ObjectWrapper(jungleDVD);
        ObjectWrapper ow2 = new ObjectWrapper(cinderellaDVD);
        swap(ow1, ow2);
        // Now ow1.obj holds cinderellaDVD and ow2.obj holds jungleDVD
        jungleDVD = (DigitalVideoDisc) ow1.obj;
        cinderellaDVD = (DigitalVideoDisc) ow2.obj;

        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

    }
}

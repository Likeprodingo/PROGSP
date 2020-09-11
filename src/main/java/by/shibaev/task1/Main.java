package by.shibaev.task1;

public class Main {
    public static void main(String[] args) {
        String name = "kapriz";
        float richness = 80.0f;
        boolean chocolate = true;
        WriterInfo.printInfo(new IceCream(chocolate, name, richness));
    }
}

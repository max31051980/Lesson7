package by.itacademy.Furniture;

public abstract class Furniture {
    private String name;
    private int square;

    public Furniture(String name, int square) {
        this.name = name;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public int getSquare() {
        return square;
    }
}
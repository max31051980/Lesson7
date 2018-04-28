package by.itacademy;

import by.itacademy.Exceptions.IlluminationLimitException;
import by.itacademy.Exceptions.SpaceLimitException;
import by.itacademy.Furniture.Furniture;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String name;
    private List <Room> rooms = new ArrayList <Room>();

    public Building(String name) {
        this.name = name;
    }

    public Building() {
    }

    public String getName() {
        return name;
    }

    public void addRoom(String name, int square, int windows) throws IlluminationLimitException {
        Room room = new Room( name, square, windows );
        rooms.add( room );
    }

    public void add(int roomIndex, LightBulb lightBulb) throws IlluminationLimitException {
        Room room = rooms.get( roomIndex );
        room.addLightBulb( lightBulb );
    }

    public void add(int roomIndex, Furniture furniture) throws SpaceLimitException {
        Room room = rooms.get( roomIndex );
        room.addFurniture( furniture );
    }

    public void buildingInformation() throws IlluminationLimitException, SpaceLimitException {
        System.out.println(name);
        for (Room room : rooms) {
            System.out.println("\n" + room.getName());
            System.out.print("Illumination = " + ((room.getWindowsIllumination()) + room.getSumOfLumen())
                    + " ( " + room.getWindows() + " windows of 700 lm, lightBulbs ");
            for (LightBulb lightBulb : room.getLightBulbList()) {
                System.out.print(lightBulb.getLumen() + " of lm, ");
            }
            System.out.println(")");
            System.out.println("Square = " + room.getSquare() + " m^ " + "( Occupied " + room.getSquareOccupied()
                    + " m^, " + "free space " + (room.getSquare() - room.getSquareOccupied()) + " m^ )");
            if (!room.getFurnitureList().isEmpty()) {
                System.out.println("Furniture: ");
                for (Furniture furniture : room.getFurnitureList()) {
                    System.out.print( furniture.getName() + " square = " + furniture.getSquare() + ", " );
                    System.out.println();
                }
            } else System.out.println("No furniture");
        }
    }
}
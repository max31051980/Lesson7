package by.itacademy;

import by.itacademy.Exceptions.IlluminationLimitException;
import by.itacademy.Exceptions.SpaceLimitException;
import by.itacademy.Furniture.Furniture;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private int square;
    private int windows;
    private List<LightBulb> lightBulbList = new ArrayList <>();
    private List<Furniture> furnitureList = new ArrayList <>();

    public List <Furniture> getFurnitureList() {
        return furnitureList;
    }

    public Room (String name, int square, int windows) throws IlluminationLimitException {
        this.name = name;
        this.square = square;
        this.windows = windows;
        CheckIllumination();
    }

    public String getName() {
        return name;
    }

    public int getWindows() {
        return windows;
    }

    public int getWindowsIllumination(){
        return windows * 700;
    }

    public int getSumOfLumen(){
        int sumOfLumen = 0;
        for (LightBulb lightBulb: lightBulbList) {
            sumOfLumen += lightBulb.getLumen();
        }return sumOfLumen;
    }

    public int getSquareOccupied(){
        int sumSquare = 0;
        for (Furniture furniture: furnitureList) {
            sumSquare += furniture.getSquare();
        }return sumSquare;
    }

    public List <LightBulb> getLightBulbList() {
        return lightBulbList;
    }

    public int getSquare() {
         return square;
    }

    public void addLightBulb (LightBulb lightBulb) throws IlluminationLimitException {
        CheckIllumination();
        lightBulbList.add(lightBulb);
    }

    public void addFurniture (Furniture furniture) throws SpaceLimitException {
        CheckSpace();
        furnitureList.add(furniture);
    }

    public void CheckSpace() throws SpaceLimitException {
        int sumOfSquare = 0;
        for (Furniture furniture: furnitureList){
            sumOfSquare += furniture.getSquare();
        }
        if (sumOfSquare > getSquare() * 0.7)
            throw new SpaceLimitException("Its impossible to add new furniture. :-) You are standing room only!");
    }

    public void CheckIllumination() throws IlluminationLimitException {
        int sumOfLumen = 0;
        for (LightBulb lightBulb: lightBulbList){
            sumOfLumen += lightBulb.getLumen();
        }
        sumOfLumen += windows * 700;
        if (sumOfLumen < 300 || sumOfLumen > 4000)
            throw new IlluminationLimitException("Limit illumination at " + getName());
    }
}
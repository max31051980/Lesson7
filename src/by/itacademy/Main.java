package by.itacademy;

import by.itacademy.Exceptions.IlluminationLimitException;
import by.itacademy.Exceptions.SpaceLimitException;
import by.itacademy.Furniture.ArmChair;
import by.itacademy.Furniture.Furniture;
import by.itacademy.Furniture.Table;

public class Main {
    public static void main(String[] args) throws SpaceLimitException, IlluminationLimitException {
        IlluminationLimitException illuminationLimitException = new IlluminationLimitException("");
        SpaceLimitException spaceLimitException = new SpaceLimitException("");
        Building building = new Building ("IT Academy");
        try{
            building.addRoom("Room #57",  30,  5);
            building.addRoom( "Room #55", 25, 2 );
            building.add( 0, new LightBulb( 150 ));
            building.add( 0, new LightBulb( 250 ));
            building.add( 0, new LightBulb( 250 ));
            building.add( 1, new LightBulb( 200 ));
        }catch (IlluminationLimitException e){
            e.printStackTrace();
        }
        try {
            building.add( 0, new Table( "Desk", 3 ) );
//            building.add( 0, new Table( "Desk", 5 ) );
//            building.add( 0, new Table( "Desk", 3 ) );
            building.add( 0, new ArmChair( "Armchair", 2 ) );
            building.add( 0, new ArmChair( "Lounge", 7 ) );
//            building.add( 1, new ArmChair( "Black leather armchair", 2 ) );
        }catch (SpaceLimitException e){
            e.printStackTrace();
        }
       building.buildingInformation();
    }
}
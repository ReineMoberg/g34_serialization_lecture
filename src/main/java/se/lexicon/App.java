package se.lexicon;


import se.lexicon.model.AppUser;
import se.lexicon.model.Car;
import se.lexicon.util.JsonIOUtil;
import se.lexicon.util.SerializationUtil;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        /*
        AppUser appUser = new AppUser(1, "test@test.se", "Test Name", "abcdef");
        //SerializationUtil.serializeAppUser(appUser);
        SerializationUtil.serialize(appUser);
        System.out.println("------------------------------------------");
        AppUser result = SerializationUtil.deserializeAppUser("se.lexicon.model.AppUser.ser");
        System.out.println("userId: " + result.getUserId());
        System.out.println("Name: " + result.getName());
        System.out.println("Email: " + result.getEmail());
        System.out.println("------------------------------------------");

         */

        JsonIOUtil util= new JsonIOUtil();
        ArrayList<Car> cars= new ArrayList<>();
        Car volvo = new Car("ABC123","VOLVO","XC40", LocalDate.parse("2020-02-27"));
        Car bmw = new Car("TTB666","BMW","x6", LocalDate.parse("2020-01-21"));
        cars.add(volvo);
        cars.add(bmw);

        File myCarFile= new File("cars.json");
        //util.serializeCarListToJson(cars,myCarFile);

      List<Car> result =  util.deserializeJsonListToCar(myCarFile);
        //System.out.println(result.toString());
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println("-----------------------------------------");
        System.out.println(util.deserializeJsonToCar(new File("car.json")));

    }
}

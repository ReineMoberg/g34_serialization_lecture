package se.lexicon.util;

import se.lexicon.model.AppUser;

import java.io.*;
import java.util.List;

public class SerializationUtil {

    public static void serializeAppUser(AppUser appUser){
        String fileName = "appUser.ser";
        try(
                FileOutputStream stream= new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(stream);
                ){
            out.writeObject(appUser);
            System.out.println("Operation is done. FileName :" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppUser deserializeAppUser(String fileName){
        AppUser result = null;
        try(
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
                ){
           result =  (AppUser) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;

    }

    // Generics Methods
    public static <T> void serialize(T t){
        String fileName = t.getClass().getName()+".ser";
        try(
            FileOutputStream stream= new FileOutputStream(fileName);
            ObjectOutputStream out= new ObjectOutputStream(stream);
                ){
            out.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static <T> T deserialize(String fileName){
        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
                ){
           return  (T)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    //##########################################

    public static void serializeAppUserList(List<AppUser> source, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
            out.writeObject(source);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static <T> void serializeList(List<T> source, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
            out.writeObject(source);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // implement deserialize....
    //....


}

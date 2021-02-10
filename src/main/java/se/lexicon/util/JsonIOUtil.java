package se.lexicon.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.model.Car;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonIOUtil {

    private ObjectMapper objectMapper;

    // object mapper configuration
    public JsonIOUtil() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void serializeCarListToJson(List<Car> cars, File file){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file,cars);
            System.out.println("Operation is Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<Car> deserializeJsonListToCar(File file){
        List<Car> result= new ArrayList<>();
        try{
            result = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Car deserializeJsonToCar(File file){
        Car result= new Car();
        try{
            result = objectMapper.readValue(file, new TypeReference<Car>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

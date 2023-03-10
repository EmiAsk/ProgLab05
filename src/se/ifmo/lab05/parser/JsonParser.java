package se.ifmo.lab05.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import se.ifmo.lab05.model.Flat;
import se.ifmo.lab05.util.ZonedDateTimeDeserializer;

import java.io.FileReader;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class JsonParser {
    public static Flat[] parseFile(FileReader file) throws JsonParseException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        Gson gson = builder.create();
        StringBuilder inputData = new StringBuilder();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            inputData.append(scanner.nextLine());
        }
        return gson.fromJson(inputData.toString(), Flat[].class);
    }
}

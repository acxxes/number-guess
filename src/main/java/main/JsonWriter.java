package main;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JsonWriter {
    File file = new File("highscore.json");

    public void createJsonFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("New " + file + " file was created.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void writeJsonFile(List<HighScore> highScores) {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            buildGson().toJson(highScores, fileWriter);
            System.out.println("Data written to file");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file");
            e.printStackTrace();
        }
    }

    public List<HighScore> readJsonFile() {
        // gson.fromJson reads .json and converts it into an object type
        // new TypeToken<List<HighScore>>(){}.getType() tells gson what type of object to build, it builds a list
        try (FileReader fileReader = new FileReader(file)) {
            // {} creates an anonymous subclass of TypeToken<List<HighScore>> instead of instantiating TypeToken directly
            // without this subclass, gson had nothing to inspect, and it would only see an erased raw type
            // it is necessary so the information about <List<HighScore>> survives in the runtime and gson can read from it
            List<HighScore> highScores = buildGson().fromJson(fileReader, new TypeToken<List<HighScore>>() {
            }.getType());
            Collections.sort(highScores, new Comparator<HighScore>() {
                @Override
                public int compare(HighScore o1, HighScore o2) {
                    return o2.getScore() - o1.getScore();
                }
            });
            // ternary operator
            return highScores != null ? highScores : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHighScore(HighScore newScore) {
        List<HighScore> highScores = readJsonFile();

        boolean exists = highScores.stream()
                .anyMatch(hs -> hs.getScore() == newScore.getScore());

        if (!exists) {
            highScores.add(newScore);
            writeJsonFile(highScores);
        } else {
            System.out.println("Score already exists, not adding.");
        }
    }

    public Gson buildGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }

}

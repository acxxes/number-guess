package main;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    /**
     * Writes one JSON localDate (an array, object, string, number, boolean or null) for {@code localDate}.
     *
     * @param jsonWriter
     * @param localDate the Java object to write. May be null.
     */
    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
        if (localDate == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(localDate.format(FORMATTER));
        }
    }

    /**
     * Reads one JSON value (an array, object, string, number, boolean or null) and converts it to a
     * Java object. Returns the converted object.
     *
     * @param jsonReader
     * @return the converted Java object. May be {@code null}.
     */
    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
        String dateString = jsonReader.nextString();
        return LocalDate.parse(dateString, FORMATTER);
    }
}

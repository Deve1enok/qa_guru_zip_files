package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.JsonData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonReaderTest extends JsonData {

    private final ClassLoader cl = JsonReaderTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void checkJsonOptions() throws Exception {
        try (InputStream is = cl.getResourceAsStream("jsonFiles/exampleJson.json")) {
              assert is != null;
              try (InputStreamReader isr = new InputStreamReader(is)) {
            JsonReaderTest data = objectMapper.readValue(isr, JsonReaderTest.class);
            Assertions.assertEquals("Лето", data.userName);
            Assertions.assertEquals("https://avatarko.ru/img/KO", data.avatar);
            Assertions.assertEquals(123, data.id);
            Assertions.assertEquals(7, data.rating);
            Assertions.assertEquals(List.of(
                    "love food",
                    "trainer",
                    "java",
                    "postman"), data.skills);
            }
    }
    }
}
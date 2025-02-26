import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"Rahul\",\"age\":25}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(json);
            if (node.has("name") && node.has("age")) {
                System.out.println("Valid JSON structure");
            } else {
                System.out.println("Invalid JSON structure");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}

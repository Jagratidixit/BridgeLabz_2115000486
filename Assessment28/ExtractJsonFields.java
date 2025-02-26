import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractJsonFields {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("data.json"));

        for (JsonNode node : rootNode) {
            String name = node.get("name").asText();
            String email = node.get("email").asText();
            System.out.println("Name: " + name + ", Email: " + email);
        }
    }
}

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class ValidateJsonSchema {
    public static void main(String[] args) {
        String schemaStr = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String jsonStr = "{ \"email\": \"test@example.com\" }";

        Schema schema = SchemaLoader.load(new JSONObject(schemaStr));
        schema.validate(new JSONObject(jsonStr));

        System.out.println("Valid JSON!");
    }
}

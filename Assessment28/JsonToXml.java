import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        JsonNode jsonNode = objectMapper.readTree("{\"name\":\"Rahul\",\"age\":25}");
        String xml = xmlMapper.writeValueAsString(jsonNode);
        System.out.println(xml);
    }
}

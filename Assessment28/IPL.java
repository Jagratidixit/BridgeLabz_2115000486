import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.Iterator;

public class IplCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CsvMapper csvMapper = new CsvMapper();

        // Process JSON File
        ArrayNode jsonData = (ArrayNode) objectMapper.readTree(new File("ipl.json"));
        for (JsonNode match : jsonData) {
            ((ObjectNode) match).put("team1", censorTeam(match.get("team1").asText()));
            ((ObjectNode) match).put("team2", censorTeam(match.get("team2").asText()));
            ((ObjectNode) match).put("player_of_match", "REDACTED");
        }
        objectMapper.writeValue(new File("ipl_censored.json"), jsonData);

        // Process CSV File
        File csvFile = new File("ipl.csv");
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<ObjectNode> it = csvMapper.readerFor(ObjectNode.class).with(schema).readValues(csvFile);
        
        ArrayNode csvData = objectMapper.createArrayNode();
        while (it.hasNext()) {
            ObjectNode match = it.next();
            match.put("team1", censorTeam(match.get("team1").asText()));
            match.put("team2", censorTeam(match.get("team2").asText()));
            match.put("player_of_match", "REDACTED");
            csvData.add(match);
        }
        csvMapper.writer(schema.withHeader()).writeValue(new File("ipl_censored.csv"), csvData);
        
        System.out.println("Censored IPL data saved!");
    }

    static String censorTeam(String team) {
        return team.split(" ")[0] + " ***";
    }
}

//OUTPUT
 {
    "match_id": 101,
    "team1": "Mumbai ***",
    "team2": "Chennai ***",
    "player_of_match": "REDACTED"
  }


//Output CSV Example

match_id,team1,team2,player_of_match
101,Mumbai ***,Chennai ***,REDACTED

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("data.csv");
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Object> it = csvMapper.readerFor(Object.class).with(schema).readValues(csvFile);

        List<Object> list = it.readAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
    }
}

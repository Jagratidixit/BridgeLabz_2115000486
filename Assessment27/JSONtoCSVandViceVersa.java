import java.io.*;
import org.json.*;
public class JSONToCSV {
    public static void main(String[] args) throws Exception {
        String jsonText = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("students.json")));
        JSONArray jsonArray = new JSONArray(jsonText);
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"));
        bw.write("ID,Name,Age,Marks\n");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            bw.write(obj.getInt("ID") + "," + obj.getString("Name") + "," + obj.getInt("Age") + "," + obj.getInt("Marks") + "\n");
        }
        bw.close();
    }
}
import java.io.*;
import org.json.*;
public class CSVToJSON {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        JSONArray jsonArray = new JSONArray();
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            JSONObject obj = new JSONObject();
            obj.put("ID", Integer.parseInt(data[0]));
            obj.put("Name", data[1]);
            obj.put("Age", Integer.parseInt(data[2]));
            obj.put("Marks", Integer.parseInt(data[3]));
            jsonArray.put(obj);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.json"));
        bw.write(jsonArray.toString(4));
        bw.close();
    }
}

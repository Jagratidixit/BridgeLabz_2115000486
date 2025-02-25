import java.io.*;
import java.util.*;
public class MergeCSV {
    public static void main(String[] args) throws IOException {
        Map<String, String[]> students1 = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        br1.readLine();
        String line;
        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            students1.put(data[0], data);
        }
        br1.close();
        
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        br2.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter("merged_students.csv"));
        bw.write("ID,Name,Age,Marks,Grade\n");
        while ((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            if (students1.containsKey(data[0])) {
                String[] student = students1.get(data[0]);
                bw.write(String.join(",", student) + "," + data[1] + "," + data[2] + "\n");
            }
        }
        br2.close();
        bw.close();
    }
}

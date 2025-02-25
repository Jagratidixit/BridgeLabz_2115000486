import java.io.*;
import java.util.*;
public class DetectDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];
            if (!seen.add(id)) duplicates.add(line);
        }
        br.close();
        for (String dup : duplicates) System.out.println("Duplicate: " + dup);
    }
}

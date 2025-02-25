import java.io.*;
import java.util.*;
public class ModifyCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<String> lines = new ArrayList<>();
        String line = br.readLine();
        lines.add(line);
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[2].equalsIgnoreCase("IT")) data[3] = String.valueOf((int) (Integer.parseInt(data[3]) * 1.1));
            lines.add(String.join(",", data));
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("updated_employees.csv"));
        for (String l : lines) bw.write(l + "\n");
        bw.close();
    }
}

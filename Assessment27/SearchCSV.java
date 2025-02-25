import java.io.*;
public class SearchCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String name = "Alice", line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(name)) {
                System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
                break;
            }
        }
        br.close();
    }
}

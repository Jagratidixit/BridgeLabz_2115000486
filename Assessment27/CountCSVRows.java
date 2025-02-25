import java.io.*;
public class CountCSVRows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        int count = 0;
        br.readLine();
        while (br.readLine() != null) count++;
        br.close();
        System.out.println("Total records: " + count);
    }
}

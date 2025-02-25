import java.io.*;
public class ReadLargeCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("large.csv"));
        String line;
        int count = 0;
        br.readLine();
        while ((line = br.readLine()) != null) {
            count++;
            if (count % 100 == 0) System.out.println("Processed: " + count + " records");
        }
        br.close();
        System.out.println("Total records processed: " + count);
    }
}

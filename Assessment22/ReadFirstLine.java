import java.io.*;

public class ReadFirstLine {
    public static void main(String[] args) {
        String fileName = "info.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("First line: " + reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}

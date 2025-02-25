import java.io.*;
import java.util.regex.*;
public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (!emailPattern.matcher(data[4]).matches() || !phonePattern.matcher(data[5]).matches())
                System.out.println("Invalid row: " + line);
        }
        br.close();
    }
}

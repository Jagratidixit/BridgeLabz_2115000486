import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));
        bw.write("ID,Name,Department,Salary\n");
        String[] records = {
            "1,John,HR,50000", "2,Alice,IT,60000", "3,Bob,Finance,55000", 
            "4,Eve,IT,70000", "5,Charlie,Marketing,45000"
        };
        for (String record : records) {
            bw.write(record + "\n");
        }
        bw.close();
    }
}

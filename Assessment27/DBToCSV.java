import java.sql.*;
import java.io.*;
public class DBToCSV {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "password");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees_report.csv"));
        bw.write("Employee ID,Name,Department,Salary\n");
        while (rs.next()) {
            bw.write(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getInt(4) + "\n");
        }
        bw.close();
        con.close();
    }
}

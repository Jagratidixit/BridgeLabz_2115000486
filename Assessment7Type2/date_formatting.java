import java.time.*;
import java.time.format.DateTimeFormatter;

public class main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        System.out.println("Current date in dd/MM/yyyy: " + currentDate.format(formatter1));
        System.out.println("Current date in yyyy-MM-dd: " + currentDate.format(formatter2));
        System.out.println("Current date in EEE, MMM dd, yyyy: " + currentDate.format(formatter3));
    }
}

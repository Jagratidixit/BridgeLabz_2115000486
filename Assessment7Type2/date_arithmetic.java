import java.time.*;
import java.time.format.DateTimeFormatter;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();
        
        LocalDate date = LocalDate.parse(inputDate);
        
        date = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        
        System.out.println("Resulting date: " + date);
    }
}

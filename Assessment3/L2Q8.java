import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String name = scanner.nextLine();
        String fromCity = scanner.nextLine();
        String viaCity = scanner.nextLine();
        String toCity = scanner.nextLine();
        
        double fromToVia = scanner.nextDouble();
        double viaToFinalCity = scanner.nextDouble();
        double timeTaken = scanner.nextDouble();
        
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;
        
        System.out.println("Name: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time Taken: " + timeTaken + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles/hour");
    }
}

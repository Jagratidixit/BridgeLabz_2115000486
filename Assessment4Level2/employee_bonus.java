import java.util.Scanner;

public class Level2Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int EMP_COUNT = 10;
        double[] salaries = new double[EMP_COUNT];
        double[] yearsOfService = new double[EMP_COUNT];
        double[] bonuses = new double[EMP_COUNT];
        double[] newSalaries = new double[EMP_COUNT];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < EMP_COUNT; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salaries[i] = sc.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            yearsOfService[i] = sc.nextDouble();

            if (salaries[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input. Please re-enter.");
                i--;
                continue;
            }

            double bonusRate = yearsOfService[i] > 5 ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}

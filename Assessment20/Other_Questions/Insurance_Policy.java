import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Policyholder='" + policyholderName + '\'' +
                ", Expiry Date=" + expiryDate +
                ", Coverage Type='" + coverageType + '\'' +
                ", Premium Amount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        for (Policy p : hashSetPolicies) System.out.println(p);
    }

    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thirtyDaysLater = calendar.getTime();

        for (Policy p : treeSetPolicies) {
            if (p.getExpiryDate().before(thirtyDaysLater)) {
                System.out.println(p);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (Policy p : hashSetPolicies) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void findDuplicatePolicies() {
        System.out.println("\nDuplicate Policies:");
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy p : hashSetPolicies) {
            policyCount.put(p.getPolicyNumber(), policyCount.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " - Duplicates: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        Calendar calendar = Calendar.getInstance();

        calendar.set(2025, Calendar.MARCH, 10);
        system.addPolicy(new Policy("P1001", "Alice", calendar.getTime(), "Health", 1200.50));

        calendar.set(2025, Calendar.JANUARY, 5);
        system.addPolicy(new Policy("P1002", "Bob", calendar.getTime(), "Auto", 800.75));

        calendar.set(2024, Calendar.FEBRUARY, 25);
        system.addPolicy(new Policy("P1003", "Charlie", calendar.getTime(), "Home", 950.00));

        calendar.set(2024, Calendar.FEBRUARY, 20);
        system.addPolicy(new Policy("P1004", "David", calendar.getTime(), "Health", 1050.25));

        calendar.set(2025, Calendar.MAY, 15);
        system.addPolicy(new Policy("P1005", "Eve", calendar.getTime(), "Auto", 700.00));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.findDuplicatePolicies();
    }
}

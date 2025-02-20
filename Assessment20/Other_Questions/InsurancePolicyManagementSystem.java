import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + coverageType + " - " + expiryDate + " - $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    TreeMap<Date, Policy> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = cal.getTime();

        for (Map.Entry<Date, Policy> entry : sortedPolicyMap.entrySet()) {
            if (entry.getKey().after(currentDate) && entry.getKey().before(thresholdDate)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equals(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        sortedPolicyMap.entrySet().removeIf(entry -> entry.getKey().before(currentDate));
        policyMap.entrySet().removeIf(entry -> entry.getValue().expiryDate.before(currentDate));
        orderedPolicyMap.entrySet().removeIf(entry -> entry.getValue().expiryDate.before(currentDate));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 15);
        Date expiry1 = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 40);
        Date expiry2 = cal.getTime();

        system.addPolicy(new Policy("P001", "Alice", expiry1, "Health", 5000));
        system.addPolicy(new Policy("P002", "Bob", expiry2, "Auto", 3000));

        System.out.println(system.getPolicy("P001"));
        System.out.println(system.getExpiringPolicies());
        System.out.println(system.getPoliciesByHolder("Alice"));
        system.removeExpiredPolicies();
    }
}

import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteMap = new HashMap<>();
    Map<String, Integer> orderedVoteMap = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedVoteMap = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        System.out.println("Votes in HashMap (Unordered): " + voteMap);
        System.out.println("Votes in LinkedHashMap (Insertion Order): " + orderedVoteMap);
        System.out.println("Votes in TreeMap (Sorted Order): " + sortedVoteMap);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Jagrati");
        system.castVote("Aditi");
        system.castVote("Vishesh");
        system.castVote("Prasoon");

        system.displayResults();
    }
}

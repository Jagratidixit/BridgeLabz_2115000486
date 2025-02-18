import java.util.*;
public class SearchComparisonDataStructure{
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};

        Scanner scanner = new Scanner(System.in);

        Random rand=new Random();
        int elementToSearch =rand.nextInt();

        for (int N : datasetSizes) {
            System.out.println("Dataset Size: " + N);

            // array ki jagah list leli coz array ko comparison mein use karna h
            List<Integer> data = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                data.add(i); 
            }

            //array
            long startTime = System.nanoTime();
            searchInArray(data, elementToSearch);
            long endTime = System.nanoTime();
            System.out.println("Array Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // HashSet
            Set<Integer> hashSet = new HashSet<>(data);
            startTime = System.nanoTime();
            searchInHashSet(hashSet, elementToSearch);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            //TreeSet
            Set<Integer> treeSet = new TreeSet<>(data);
            startTime = System.nanoTime();
            searchInTreeSet(treeSet, elementToSearch);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            System.out.println();
        }

    
    }

    // Linear search in Array
    public static void searchInArray(List<Integer> data, int element) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == element) {
                break;
            }
        }
    }

    // Search in HashSet
    private static void searchInHashSet(Set<Integer> data, int element) {
        data.contains(element);
    }

    // Search in TreeSet
    private static void searchInTreeSet(Set<Integer> data, int element) {
        data.contains(element);
    }
}

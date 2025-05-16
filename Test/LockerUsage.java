import java.util.*;

class Locker {
    int position;
    int size;
    int usageCount;

    public Locker(int position, int size, int usageCount) {
        this.position = position;
        this.size = size;
        this.usageCount = usageCount;
    }
}

public class LockerUsage {

    public static int findMostPopularLockerSize(List<Locker> lockers) {
        // TreeMap to store usage count as key and a list of sizes as values
        Map<Integer, List<Integer>> usageMap = new TreeMap<>(Collections.reverseOrder()); // Reverse to get max usage first

        // Step 1: Process each locker and update the usage map
        for (Locker locker : lockers) {
            int usage = locker.usageCount;
            usageMap.putIfAbsent(usage, new ArrayList<>());
            usageMap.get(usage).add(locker.size);
        }

        // Step 2: Get the entry with the highest usage count
        int mostPopularSize = -1;

        // Iterate over the sorted map (from max usage to min usage)
        for (Map.Entry<Integer, List<Integer>> entry : usageMap.entrySet()) {
            // If we find the first entry (max usage count), pick the smallest size
            if (mostPopularSize == -1) {
                mostPopularSize = entry.getValue().stream()
                        .min(Integer::compareTo) // Get the smallest size
                        .orElseThrow(() -> new IllegalStateException("No sizes available"));
            } else {
                break;
            }
        }

        return mostPopularSize;
    }

    public static void main(String[] args) {
        // Example list of lockers
        List<Locker> lockers = Arrays.asList(
            new Locker(1, 10, 5),  // Locker with size 10, used 5 times
            new Locker(2, 20, 8),  // Locker with size 20, used 8 times
            new Locker(3, 10, 3),  // Locker with size 10, used 3 times
            new Locker(4, 30, 2),  // Locker with size 30, used 2 times
            new Locker(5, 20, 4)   // Locker with size 20, used 4 times
        );

        int mostPopularSize = findMostPopularLockerSize(lockers);
        System.out.println("The most popular locker size is: " + mostPopularSize);
    }
}

import java.util.Arrays;

public class TransactionLogs{

    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        System.out.println("Linear first " + target + ": not found (" + comparisons + " comparisons)");
        return -1;
    }

    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid].equals(target)) {
                System.out.println("Binary " + target + ": index " + mid + " (" + comparisons + " comparisons)");
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary " + target + ": not found (" + comparisons + " comparisons)");
        return -1;
    }

    public static int findFirst(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // search left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // search right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }


    public static int countOccurrences(String[] arr, String target) {
        int first = findFirst(arr, target);
        if (first == -1) return 0;
        int last = findLast(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Sorted logs: " + Arrays.toString(logs));


        linearFirst(logs, "accB");

        Arrays.sort(logs);


        int indexBinary = binarySearch(logs, "accB");
        int countBinary = countOccurrences(logs, "accB");
        if (indexBinary != -1) {
            System.out.println("Binary accB: index " + indexBinary + " (3 comparisons), count=" + countBinary);
        }
    }
}




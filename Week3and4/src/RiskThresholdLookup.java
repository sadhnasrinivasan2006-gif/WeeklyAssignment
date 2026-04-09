import java.util.Arrays;

public class RiskThresholdLookup {

    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: threshold=" + target + " → index " + i + " (" + comparisons + " comps)");
                return i;
            }
        }
        System.out.println("Linear: threshold=" + target + " → not found (" + comparisons + " comps)");
        return -1;
    }

    public static void binaryFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int floor = -1, ceiling = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.print("Binary floor(" + target + "): ");
        System.out.print(floor == -1 ? "none" : floor);
        System.out.print(", ceiling: ");
        System.out.print(ceiling == -1 ? "none" : ceiling);
        System.out.println(" (" + comparisons + " comps)");
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};


        System.out.println("Sorted risks: " + Arrays.toString(risks));


        linearSearch(risks, 30);


        binaryFloorCeiling(risks, 30);
    }
}




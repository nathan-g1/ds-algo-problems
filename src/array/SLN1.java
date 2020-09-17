package array;
import java.util.Arrays;

public class SLN1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(slidingWindowAvg(new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}, 5)));
    }

    public static double[] slidingWindowAvg(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1]; // O(1)
        int start = 0, end = k - 1, winSum = 0;           // O(1)
        while (end < arr.length) {                        // O(N - K - 1)
            for (int i = start; i < end; i++) {           // O(K)
                winSum += arr[i];                         // O(1)
            }                                             // O(K)
            result[start] = (double) winSum / k;          // O(1)
            winSum = 0;                                   // O(1)
            ++end;                                        // O(1)
            ++start;                                      // O(1)
        }
        return result;
    }
    // O(N - k) * K
 }

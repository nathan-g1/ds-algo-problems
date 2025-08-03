
public class ContinuousSubArrayAverage {
    public static double[] slidingWindowAvg(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1]; // O(1)
        int start = 0, end = k - 1, winSum = 0;           // O(1)
        while (end < arr.length) {                        // O(N - K - 1)
            for (int i = start; i <= end; i++) {           // O(K)
                winSum += arr[i];                         // O(1)
            }                                             // O(K)
            result[start] = (double) winSum / k;          // O(1)
            winSum = 0;                                   // O(1)
            ++end;                                        // O(1)
            ++start;                                      // O(1)
        }
        return result;
    }

    public static double[] slidingWindowAvg2(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1]; // O(1)
        int start = 0, end = 0, winSum = 0;           // O(1)
        while (end < arr.length) {                        // O(N - K)
            winSum += arr[end];
            if (end >= (k - 1)) {
                result[start] = (double) winSum / k;
                winSum -= arr[start];
                ++start;
            }
            ++end;
        }
        return result;
    }
}

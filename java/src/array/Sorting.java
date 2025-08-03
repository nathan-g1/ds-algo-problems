import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 31, 3, 31, 2, 9, 5};
        try {
            System.out.println(Arrays.toString(countingSort(arr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] countingSort(int[] arr) throws Exception {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i < 0) {
                throw new Exception("No negative integers allowed");
            }
            max = Math.max(max, i);
        }

        int[] counts = new int[max + 1];
        for (int i : arr) {
            counts[i] = counts[i] + 1;
        }

        int j = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[j] = i;
                j++;
                counts[i]--;
            }
        }

        return arr;
    }
}

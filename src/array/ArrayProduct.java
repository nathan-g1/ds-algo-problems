
import java.util.Arrays;

class ArrayProduct {
    public static void main(String[] args) {
        // NOTE: You can use the following input values to test this function.
        // int[] a1 = {-1, 3, 8, 2, 9, 5};
//        var val = productExceptSelf(a1);
//        System.out.println(Arrays.toString(val));
    }

    public static int[] productExceptSelf(int[] arr) {
        var size = arr.length;
        int[] prefix = new int[size];
        // int[] suffix = new int[size];
        for (int i = 1; i < size; i++) {
            prefix[i] *= prefix[i - 1];
        }

        System.out.println(Arrays.toString(prefix));
//        for (int i =)
        return new int[] {};
    }
}
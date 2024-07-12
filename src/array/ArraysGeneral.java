import java.util.ArrayList;
import java.util.List;

public class ArraysGeneral {
    public static void main(String[] args) {
        String s = "HeyThere this is na3";
        String d = "is na3";
        System.out.println(isUnique2(s));
        System.out.println(isUnique2(d));
    }

    static boolean isUnique(String s) {
        if (s.length() > 128) return false;
        int[] check = new int[128];

        for (char c : s.toCharArray()) {
            int idx = c;
            if (check[idx] > 0) return false;
            check[idx]++;
        }
        return true;
    }

    static boolean isUnique2(String s) {
        int checker = 0;
        for (char c : s.toCharArray()) {
            int val = c - 'a';
            
            if ((checker &  (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    /**
     * 
     * LC # 1909
     * Given a sequence of integers as an array, determine whether it is 
     * possible to obtain a strictly increasing sequence by removing no 
     * more than one element from the array.
     *  Note: sequence a0, a1, ..., an is considered to be a strictly increasing 
     *  if a0 < a1 < ... < an. Sequence containing only one element is also considered 
     * to be strictly increasing.
     * 
     * Example

     *      For sequence = [1, 3, 2, 1], the output should be solution(sequence) = false.
     *      There is no one element in this array that can be removed in order to get a 
     *      strictly increasing sequence.
     *      
     *      For sequence = [1, 3, 2], the output should be
     *      solution(sequence) = true.
     *      You can remove 3 from the array to get the strictly increasing sequence [1, 2]. 
     *      Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
    *
    */
    public boolean canBeIncreasing(int[] ar) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int min = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] < ar[i + 1]) {
                min = ar[i];
            }
            
            if (ar[i] >= ar[i + 1]) {
                // we run two loops from here
                // 1. check if it's increasing by starting from min without element current
                // 2. check if it's increasing by starting from current without element next
                if (min != 0) l1.add(min);
                for (int j = i + 1; j <= ar.length - 1; j++) {
                    l1.add(ar[j]);
                }

                for (int j = i; j < ar.length; j++) {
                    if (j != i + 1) {
                        l2.add(ar[j]);
                    }
                }

                return isStrictlyIncreasing(l1) || isStrictlyIncreasing(l2);
            }
        }

        return true;
    }

    boolean isStrictlyIncreasing(List<Integer> li) {
        for (int i = 0; i < li.size() - 1; i++) {
            if (li.get(i) >= li.get(i + 1)) return false;
        }
        return true;
    }
}

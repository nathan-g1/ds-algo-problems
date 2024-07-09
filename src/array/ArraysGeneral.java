
public class ArraysGeneral {
    public static void main(String[] args) {
        String s = "HeyThere this is na3";
        String d = "is na3";
        System.out.println(isUnique(s));
        System.out.println(isUnique(d));
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
}

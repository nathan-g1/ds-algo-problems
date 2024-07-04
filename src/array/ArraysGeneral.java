
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
}

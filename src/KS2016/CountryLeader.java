import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

    /**
     Round A 2016 - Kick Start 2016

     The Constitution of a certain country states
     that the leader is the person with the name
     containing the greatest number of different
     alphabet letters.

     (The country uses the
     uppercase English alphabet from A through Z.)
     For example, the name GOOGLE has four different
     alphabet letters: E, G, L, and O. The name APAC
     CODE JAM has eight different letters. If the
     country only consists of these 2 persons,
     APAC CODE JAM would be the leader.
     */


public class CountryLeader {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = in.nextInt();
        for (int i = 0; i < testCase; i++) {
            int people = in.nextInt();
            ArrayList<String> names = new ArrayList<>(people);
            for (int j = 0; j < people; j++) {
                String personName = "";
                while (in.hasNextLine()) {
                    personName = personName.concat(in.next());
                }
                names.add(personName);
            }
            System.out.println("Case #" + (i + 1) + ": " + findCountryLeader(names));
        }
    }

    private static String findCountryLeader(ArrayList<String> names) {
        Map<String, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (String name : names) {
            for (char c : name.toCharArray()) {
                set.add(c);
            }
            if (!map.containsKey(name)) map.put(name, set.size());
            set.clear();
        }

        int max = 0;
        String result = "";
        Set<Integer> set2 = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (set2.add(entry.getValue())) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    result = entry.getKey();
                }
            } else {
                if (result.compareTo(entry.getKey()) > 0) {
                    result = entry.getKey();
                }
            }
        }
        return result;
    }
}

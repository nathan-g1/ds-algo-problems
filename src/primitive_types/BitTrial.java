
public class BitTrial {

    public int countBits(int x) {
        short numBits = 0;
        while (x != 0) {
            int s = x & 1;
            System.out.println(s);
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

}

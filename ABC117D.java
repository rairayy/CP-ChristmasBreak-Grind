import java.util.*;
import java.math.*;

public class ABC117D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[] ary = new long[n];
        // number of 0s have to be greater
        int MAX_BIT_LENGTH = (new BigInteger(k+"")).bitLength();
        for( int i = 0; i < n; i++ ) ary[i] = in.nextLong();
        long xor = 0L;
        for( int i = MAX_BIT_LENGTH; i >= 0; i-- ) {
            int ones = 0;
            for( int j = 0; j < n; j++ ) {
                if((ary[j]&(1L<<i)) > 0 ) ones++;
            }
            if( ones < n-ones && xor+(1L<<i) <= k) xor += (long) (1L<<(long)i); // if 1 is less than 0s, and adding it to xor will keep it less than k
        }

        long ans = 0L;
        for( long i : ary ) ans += (long) (i^xor);
        System.out.println(ans);
    }
}
import java.util.*;
// i hate myself
public class ABC085D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[] a = new long[n];
        long[] b = new long[n];
        long max_a = -1L;
        for( int i = 0; i < n; i++ ) {
            a[i] = in.nextLong();
            b[i] = in.nextLong();
            max_a = Math.max(max_a, a[i]);
        }
        long ct = 0L;
        Arrays.sort(b);
        for( int i = n-1; i >= 0; i-- ) {
            if(b[i] > max_a && k > 0) {k -= b[i]; ct += 1L;}
            else break;
        }
        if(k>0) ct += Math.ceil(k/(double)max_a);
        System.out.println(ct);
    }
}
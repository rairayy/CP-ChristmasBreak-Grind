import java.util.*;

public class ABC119D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int q = in.nextInt();
        TreeSet<Long> shrines = new TreeSet<Long>();
        TreeSet<Long> temples = new TreeSet<Long>();
        for( int i = 0; i < s; i++ ) shrines.add(in.nextLong());
        for( int i = 0; i < t; i++ ) temples.add(in.nextLong());
        shrines.add(Long.MIN_VALUE);
        shrines.add(Long.MAX_VALUE);
        temples.add(Long.MAX_VALUE);
        temples.add(Long.MIN_VALUE);
        for( int i = 0; i < q; i++ ) {
            long temp = in.nextLong();
            long[] dists = new long[4];
            dists[0] = shrines.floor(temp);
            dists[1] = shrines.ceiling(temp);
            dists[2] = temples.floor(temp);
            dists[3] = temples.ceiling(temp);
            long ans = Long.MAX_VALUE;
            for( int j = 0; j < 2; j++ ) {
                for( int k = 2; k < 4; k++ ) {
                    // shrine closest left or right
                    long a = Math.abs(dists[j]-temp)+Math.abs(dists[k]-dists[j]);
                    // temple closest left or right
                    long b = Math.abs(dists[k]-temp)+Math.abs(dists[j]-dists[k]);
                    if( a > 0 ) ans = Math.min(ans, Math.abs(dists[j]-temp)+Math.abs(dists[k]-dists[j]));
                    if( b > 0 ) ans = Math.min(ans, Math.abs(dists[k]-temp)+Math.abs(dists[j]-dists[k]));
                }
            }
            System.out.println(ans);
        }
    }
}
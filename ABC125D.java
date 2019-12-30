import java.util.*;

public class ABC125D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long min = Long.MAX_VALUE;
        long total = 0;
        int negCt = 0;
        while(n-->0) {
            long q = in.nextLong();
            if( q <= 0 ) negCt++;
            q = Math.abs(q);
            min = Math.min(min, q);
            total += q;
        }
        if( (negCt&1) == 1 ) total -= min*2;
        System.out.println(total);
    }
}
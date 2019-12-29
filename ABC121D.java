import java.util.*;

public class ABC121D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long ans = 0;
        if( (a&1) == 1 && (b&1) == 1 ) { // odd odd
            long diff = (b-a)/2;
            int one = 0;
            if( (diff&1) == 1 ) one = 1;
            ans = one^a;
        } else if ( (a&1) == 1 && (b&1) == 0 ) { // odd eeven
            long diff = (b-1-a)/2;
            int one = 0;
            if( (diff&1) == 1 ) one = 1;
            ans = b^one^a;
        } else if ( (a&1) == 0 && (b&1) == 1 ) { // even odd
            long diff = (b-a+1)/2;
            ans = 0;
            if( (diff&1) == 1 ) ans = 1;
        } else if ( (a&1) == 0 && (b&1) == 0 ) { // even even
            long diff = (b-a)/2;
            int one = 0;
            if( (diff&1) == 1 ) one = 1;
            ans = one^b;
        }
        System.out.println(ans);
    }
}
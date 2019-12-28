import java.util.*;

public class ABC112D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if( n != 1 ) {
            // since needs n integers
            int div = m/n;
            int max = 1;
            for( int i = 2; i <= div; i++ ) {
                // ?
                if(m%i == 0) max = Math.max(max, i);
            }
            System.out.println(max);
        } else {
            System.out.println(m);
        }
    }
}
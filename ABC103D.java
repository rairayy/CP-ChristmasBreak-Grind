import java.util.*;

public class ABC103D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        Pair[] pairs = new Pair[r];
        for( int i = 0; i < r; i++ ) {
            pairs[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(pairs);
        // System.out.println();
        // for( Pair p : pairs ) System.out.printf("%d %d\n", p.a, p.b);
        int prev_a = pairs[0].a;
        int prev_b = pairs[0].b;
        int ct = 1;
        for( int i = 1; i < r; i++ ) {
            Pair temp = pairs[i];
            // is overlapping with current line ..?
            if( prev_a > temp.a && prev_a < temp.b ) {
                continue;
            } else if ( prev_b < temp.b && prev_b > temp.a ) {
                continue;
            } else {
                // update current line to add split to, if not overlapping
                ct++;
                prev_a = temp.a;
                prev_b = temp.b;
            }
        }
        System.out.println(ct);
    }
    public static class Pair implements Comparable<Pair>{
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public int compareTo( Pair p ) {
            // sort by a descending, and ascending by b if equal a's
            if( a == p.a ) return b - p.b;
            return p.a - a;
        }
    }
}
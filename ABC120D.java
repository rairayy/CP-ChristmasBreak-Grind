import java.util.*;

public class ABC120D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Pair[] ps = new Pair[k];
        id = new int[n];
        size = new int[n];
        for(int i = k-1; i >= 0; i--) {
            ps[i] = new Pair(in.nextInt(), in.nextInt());
        }
        for(int i = 0; i < n; i++) {
            id[i] = i;
        } 
        Arrays.fill(size,1);
        long count = ((long) n) *((long) n-1)/2L;
        long max = count;
        long[] ans = new long[k-1];
        for( int i = 0; i < k-1; i++) {
            int a = ps[i].x-1;
            int b = ps[i].y-1;
            int id_a = root(a);
            int id_b = root(b);
            if(id_a != id_b) {
                count -= ((long) size[id_a]) *((long) size[id_b]) ;
            }
            ans[i] = count;
            union(a,b);
        }
        for(int i = k-2; i >= 0; i--) {
            System.out.println(ans[i]);
        } 
        System.out.println(max);
    }
    static int[] id; // inst to i
    static int[] size; // inst to 1
    static int root( int i ) {
        if(id[i] != i) // find root
        id[i] = root(id[i]);
        return id[i];
    }
    static boolean find( int p, int q) {
        return root(p) == root(q);
    } 
    static void union( int p, int q ) {
        int i = root(p); // group of p
        int j = root(q); // group of q  
        if( i != j ) {
            if( size[i] < size[j] ) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }   
        } 
    }
    public static class Pair {
        int x, y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        } 
    } 
} 
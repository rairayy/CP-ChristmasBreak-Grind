import java.util.*;

public class ABC073D {
    static long ans = Long.MAX_VALUE;
    static long[][] graph;
    static int[] sopas;
    static int n,m,r;
    static final long ifty = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        r = in.nextInt();
        sopas = new int[r];
        for( int i = 0; i < r; i++ ) sopas[i] = in.nextInt()-1;
        graph = new long[201][201];
        for( int i = 0; i < 201; i++ ) 
            for( int j = 0; j < 201; j++ ) 
                if( i != j ) graph[i][j] = ifty;
        for( int i = 0; i < m; i++ ) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            graph[u][v] = graph[v][u] = in.nextLong();
        }
        // fw -> get all pairs of shortest paths
        for( int k = 0; k < n; k++ ) {
            for( int i = 0; i < n; i++ ) {
                for( int j = 0; j < n; j++ ) {
                    if( graph[i][k] == ifty || graph[k][j] == ifty ) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        for( int i = 0; i < r; i++ ) {
            boolean[] done = new boolean[r];
            done[i] = true;
            permutate( 1, i, done, 0 );    
        }
        System.out.println(ans);
        // System.out.println(Arrays.deepToString(graph));
    }

    static void permutate( int level, int previous, boolean[] done, long distance ) {
        if( level == r ) {
            ans = Math.min(ans, distance);
            return;
        }
        // for values that have not been passed
        for( int i = 0; i < r; i++ ) { 
            if( !done[i] ) {
                done[i] = true;
                int u = sopas[previous];
                int v = sopas[i];
                permutate( level+1, i, done, distance + graph[u][v] );
                done[i] = false;
            }
        }
    }

}
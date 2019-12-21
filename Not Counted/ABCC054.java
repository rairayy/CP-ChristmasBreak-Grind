import java.util.*;

public class ABCC054 {
    static ArrayList<Node> nodes = new ArrayList<Node>();
    static int count = 0;
    public static void main( String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        for( int i = 0; i < n; i++ ) nodes.add(new Node(i));
        while(e-->0) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            nodes.get(u).adj.add(nodes.get(v));
            nodes.get(v).adj.add(nodes.get(u));
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(n, 0, visited, 1);
        System.out.println(count);
    }
    public static void dfs(int n, int start, boolean[] visited, int size ) {
        if( size == n ) count++;
        // System.out.println(nodes.get(start).i);
        for( Node nd : nodes.get(start).adj ) {
            if(!visited[nd.i]) {
                visited[nd.i] = true;
                dfs(n, nd.i, visited, size+1);
                visited[nd.i] = false; // this line backtracks so that you can 
            }
        }
    }
    public static class Node {
        int i;
        ArrayList<Node> adj = new ArrayList<Node>();
        public Node(int i) {
            this.i = i;
        }
    }
}
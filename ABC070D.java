import java.util.*;

public class ABC070D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for( int i = 0; i < n; i++ ) graph[i] = new ArrayList<Edge>();
        for( int i = 0; i < n-1; i++ ) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            long w = in.nextLong();
            // System.out.println(u);
            // System.out.println(v);
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        int q = in.nextInt();
        int s = in.nextInt()-1;
        long[] dists = dijkstra(graph, s);
        // System.out.println(Arrays.toString(dists));
        for( int i = 0; i < q; i++ ) {
            int st = in.nextInt()-1;
            int ed = in.nextInt()-1;
            System.out.println(dists[st]+dists[ed]);
        }
    }
    static long[] dijkstra(ArrayList<Edge> graph[], int s) {
        int n = graph.length;
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[s] = 0; pq.offer(new Edge(s,0L));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.u;
            long w = cur.w;
            if(dist[u]<w) continue;
            for(Edge e : graph[u]) {
                int v = e.u;
                long nw = w+e.w;
                if(nw < dist[v]) {
                    dist[v] = nw;
                    pq.offer(new Edge(v,nw));
                }
            }
        }
        return dist;
    }
    public static class Edge implements Comparable<Edge> {
        public int u;
        public long w;
        public Edge( int U, long W ) {u = U; w = W;}
        public int compareTo(Edge e) {
            if( w < e.w ) return -1;
            if( w > e.w ) return 1;
            return 0;
        }
    }
}
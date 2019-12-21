import java.util.*;
// ???
public class D990 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		if ( (a==1)&&(b==1) ) {
			if( (n==2)||(n==3) ) System.out.println("NO");
			else {
				System.out.println("YES");
				printGraph(n,a,b);
			}
		} else if( (a==1) || (b==1) ) {
			System.out.println("YES");
			printGraph(n,a,b);
		} else System.out.println("NO");
	}
	public static void printGraph(int n, int a, int b) {
		int[][] graph = new int[n][n];
		int edges = n-Math.max(a,b);
		for( int i = 0; i < n; i++ ) {
			for( int j = 0; j < n; j++ ) {
				if( i==j ) graph[i][j] = 0;
				else if ( (edges > 0) && (j == i+1) ) {
					graph[i][j] = 1;
					graph[j][i] = 1;
					edges--;
				}
			}
		}
		int xor = 0;
		if( b > a ) xor = 1;
		for( int i = 0; i < n; i++ ) {
			StringBuilder sb = new StringBuilder();
			for( int j = 0; j < n; j++ ) {
				if( i==j ) sb.append(graph[i][j]);
				else sb.append(graph[i][j]^xor);
			}
			System.out.println(sb.toString());
		}
	}
}
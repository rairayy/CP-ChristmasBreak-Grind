import java.util.*;
// im so stupid im so stupid im so stupid
public class ABC057D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = in.nextInt();
        int max = in.nextInt();
        long[] nums = new long[n];
        for( int i = 0; i < n; i++ ) nums[i] = in.nextLong();
        Arrays.sort(nums);
        boolean same = true;
        long ave = 0;
        int totalPostSame = 0;
        int postSame = 0;
        for( int i = n-1; i >= 0; i-- ) {
            // flag if not everything is the same WITHIN THE BOUNDS OF A
            if( i >= n-min ) if( nums[i] != nums[i-1] ) same = false;
            // get average, best is when using minimum amount
            if( i >= n-min ) ave += nums[i];
            // count nums that are the same as the one at A
            if( nums[i] == nums[n-min] ) {
                totalPostSame++;
                if( i >= n-min ) postSame++; // everything before A (sorted)
            }
        }
        System.out.printf("%.6f\n", (double)ave/min);

        // pascals triangle
        long[][] pascal = new long[n+1][n+1];
        for( int i = 0; i <= n; i++ ) {
            for( int j = 0; j <= i; j++ ) {
                if( i == j ) pascal[i][j] = 1;
                else if( j == 0 ) pascal[i][j] = 1;
                else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        // System.out.println(Arrays.deepToString(pascal));
        long total = 0;
        if( same ) {
            for( int i = min; i <= max; i++ ) total += pascal[totalPostSame][i];
        } else {
            total = pascal[totalPostSame][postSame];
        }
        System.out.println(total);
    }
}
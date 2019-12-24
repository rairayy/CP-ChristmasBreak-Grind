import java.util.*;

public class ABC114D {
    static boolean[] isPrime;
    static List<Integer> primes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if( n != 1 ) {
            // prime sieve, n+1??
            isPrime = new boolean[n+1];
            sieve(n+1);
            // get prime factors of n
            int[] primeFacts = new int[n+1];
            for( int j = 1; j <= n; j++ ) {
                for( int i = 0; i < primes.size(); i++ ) {
                    int temp = j;
                    int pri = primes.get(i);
                    while(temp%pri==0) {
                        primeFacts[pri]++;
                        temp /= pri;
                    }
                }
            }
            int gt2 = 0;
            int gt4 = 0;
            int gt14 = 0;
            int gt24 = 0;
            int gt74 = 0;
    
            for( int i : primeFacts ) {
                if( i >= 2 ) gt2++;
                if( i >= 4 ) gt4++;
                if( i >= 14 ) gt14++;
                if( i >= 24 ) gt24++;
                if( i >= 74 ) gt74++;
            }
    
            int[] ans = new int[4];
            ans[0] = (gt4 * (gt4-1) * (gt2-2))/2; // 5 5 3
            ans[1] = gt24 * (gt2-1); // 3 25
            ans[2] = gt14 * (gt4-1); // 5 15
            ans[3] = gt74; // 75
    
            int sum = 0;
            for( int i : ans ) sum += i;
            System.out.println(sum);
            
            // System.out.println(Arrays.toString(primeFacts));
        } else {
            System.out.println(0);
        }
        
    }

    static void sieve( int N ) {
        isPrime[2] = true; primes.add(2);
        for( int i = 3; i < N; i+=2 ) isPrime[i] = true;
        for( int i = 3; i < N; i+=2 ) {
            if( isPrime[i] ) {
                primes.add(i);
                if((long)(i)*i>=N) continue;
                for( int j=i*i; j<N; j+=i ) isPrime[j] = false;
            }
        }
    }
}

// for 100
// 15 <= 3
// 9 <= 5
// 4 <= 15
// 3 <= 25
// 1 <= 75

// 5 5 3
// (9 * 9-1 * 15-2) / 2 = 468

// 5 15
// 4 * 9-1 = 32

// 3 25
// 3 * 15-1 = 42

// 75
// 1

// total = 543
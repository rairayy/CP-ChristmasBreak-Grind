import java.util.*;

public class ABC073C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Long> ts = new TreeSet<Long>();
        while ( n-- > 0 ) {
            long temp = in.nextLong();
            if(ts.remove(temp)) continue;
            else ts.add(temp);
        }
        System.out.println(ts.size());
    }
}
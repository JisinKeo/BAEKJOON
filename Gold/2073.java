import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int d, p;
    static int[] l, c, dp;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        d = Integer.parseInt(stk.nextToken());
        p = Integer.parseInt(stk.nextToken());
        
        l = new int[p];
        c = new int[p];
        
        for(int i = 0; i < p; i++) {
        	stk = new StringTokenizer(br.readLine());
        	l[i] = Integer.parseInt(stk.nextToken());
        	c[i] = Integer.parseInt(stk.nextToken());
        }
        
        dp = new int[d+1];
        
        dp[0] = 30000000;
        
        for(int i = 0; i < p; i++) {
            for(int j = d; j >= l[i]; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j-l[i]], c[i]));
            }
        }
        System.out.println(dp[d]);
        
        
    }
}

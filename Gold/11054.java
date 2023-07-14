import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
   
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
       
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] seq = new int[n];
        int[] result = new int[n];
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) {
        	seq[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
        	dp[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(seq[i] > seq[j] && dp[i] < dp[j] + 1) {
        			dp[i] = dp[j] + 1;
        		}
        	}
        }
        
        int[] dpq = new int[n];
        
        for(int i = n-1; i > -1; i--) {
        	dpq[i] = 1;
        	for(int j = n-1; j > i; j--) {
        		if(seq[i] > seq[j] && dpq[i] < dpq[j] + 1) {
        			dpq[i] = dpq[j] + 1;
        		}
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	result[i] = dp[i] + dpq[i];
        }
        Arrays.sort(result);
        System.out.println(result[n-1] - 1);
    }
    
}

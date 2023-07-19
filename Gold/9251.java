import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int str1_length = str1.length+1;
		int str2_length = str2.length+1;
		
		int[][] dp = new int[str1_length][str2_length];
		
		for(int i = 1; i < str1_length; i++) {
			for(int j = 1; j < str2_length; j++) {
				if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[str1_length-1][str2_length-1]);
		
	}

}

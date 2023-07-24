import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		dp = new int[n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			Arrays.fill(dp[i], 10000001);
			dp[i][i] = 0;
		}
	
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(dp[a][b] > 0) {
				c = Math.min(dp[a][b], c);
			}
			dp[a][b] = c;
		}
		
		for(int k = 1; k < n+1; k++) {
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < n+1; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dp[i][j] == 10000001) sb.append("0 ");
                else sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
		
		System.out.println(sb.toString());
	}

}

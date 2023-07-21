import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] path, dp_max, dp_min;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		path = new int[n][3];
		dp_max = new int[n][3];
		dp_min = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			path[i][0] = Integer.parseInt(st.nextToken());
			path[i][1] = Integer.parseInt(st.nextToken());
			path[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp_max[0][0] = path[0][0];
		dp_max[0][1] = path[0][1];
		dp_max[0][2] = path[0][2];
		
		for(int i = 1; i < n; i++) {
			dp_max[i][0] = Math.max(dp_max[i-1][0], dp_max[i-1][1]) + path[i][0];
			dp_max[i][1] = Math.max(Math.max(dp_max[i-1][0], dp_max[i-1][1]), dp_max[i-1][2]) + path[i][1];
			dp_max[i][2] = Math.max(dp_max[i-1][1], dp_max[i-1][2]) + path[i][2];
		}

		dp_min[0][0] = path[0][0];
		dp_min[0][1] = path[0][1];
		dp_min[0][2] = path[0][2];
		
		for(int i = 1; i < n; i++) {
			dp_min[i][0] = Math.min(dp_min[i-1][0], dp_min[i-1][1]) + path[i][0];
			dp_min[i][1] = Math.min(Math.min(dp_min[i-1][0], dp_min[i-1][1]), dp_min[i-1][2]) + path[i][1];
			dp_min[i][2] = Math.min(dp_min[i-1][1], dp_min[i-1][2]) + path[i][2];
		}
		
		
		int max = Math.max(Math.max(dp_max[n-1][0], dp_max[n-1][1]), dp_max[n-1][2]);
		int min = Math.min(Math.min(dp_min[n-1][0], dp_min[n-1][1]), dp_min[n-1][2]);
		
		System.out.println(max + " " + min);
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int len;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] tomato = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st1.nextToken());
				if(tomato[i][j] == 1) q.offer(new int[] {i, j});
			}
		}
		
		int result = 0;
		
		len = q.size();
		
		while(!q.isEmpty()) {
			
			if(len == 0) {
				len = q.size();
				result++;
			}
			
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int i = 0; i < 4; i++) {
				if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m) {
					if (tomato[x+dx[i]][y+dy[i]] == 0) {
						tomato[x+dx[i]][y+dy[i]] = 1;
						q.offer(new int[] {x+dx[i], y+dy[i]});
					}
				}
			}
			
			len--;

		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] == 0) {
					result = -1;
				}
			}
		}

		System.out.println(result);
	}

}

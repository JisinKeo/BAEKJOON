import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, x;
	static int[][] path;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		path = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			path[start][end] = time;
		}
		
		int result = 0;
		
		for(int i = 1; i < n+1; i++) {
			int[] start_result = dijkstra(i);
			int[] end_result = dijkstra(x);
			result = Math.max(result, start_result[x] + end_result[i]);
		}
		System.out.println(result);
		
	}

    static int[] dijkstra(int start) {
    	
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	
        	int go = cur[0];
        	int time = cur[1];
        	
        	if(distance[go] < time) continue;
        	
        	for(int i = 1; i < n+1; i++) {
        		if(go != i && path[go][i] > 0) {
                    int next_time = time + path[go][i];
        			if(next_time < distance[i]) {
        				distance[i] = next_time;
        				pq.offer(new int[]{i, next_time});
        			}
        		}
        	}
        }
        
        return distance;
	}

}

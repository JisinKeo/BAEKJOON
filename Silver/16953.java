import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static long a, b;
	
	public static int BFS() {
		Queue<Long> q = new LinkedList<>();
		
		q.offer(a);
		
		int count = 0;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int i = 0; i < size; i++) {
				long cur = q.poll();
				
				if(cur == b) {
					count++;
					return count;
				}
				
				if(cur<b) q.offer(cur*2);
				if(cur<b) q.offer(cur*10+1);
			}
			count++;
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int result = BFS();

		System.out.println(result);
	}

}

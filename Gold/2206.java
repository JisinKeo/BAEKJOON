import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
    	int x;
    	int y;
    	int count;
    	int checked;
       
        public Node(int x, int y, int count, int checked) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.checked = checked;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
           Node node = queue.poll();
           if(node.x == n-1 && node.y == m-1) {
        	   return node.count;
           }
           
           
           for(int i = 0; i < 4; i++) {
        	   int nx = node.x + dx[i];
        	   int ny = node.y + dy[i];
               if(nx >= 0 && nx < n && ny >=0 && ny < m) {
                   if(map[nx][ny] == 1 && node.checked == 0){
                       visited[nx][ny][1] = 1;
                       queue.offer(new Node(nx, ny, node.count+1, 1));
                   }
                   else if(map[nx][ny] == 0 && visited[nx][ny][node.checked] == 0) {
                       visited[nx][ny][node.checked] = 1;
                       queue.offer(new Node(nx, ny, node.count+1, node.checked));
                   }
               }
           }
        }

        return -1;
    }
}

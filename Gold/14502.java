import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[][] area;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static Queue<Point> q;

    static int result;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int count){
        if(count == 3){
            spread();
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(area[i][j] == 0){
                    area[i][j] = 1;
                    DFS(count + 1);
                    area[i][j] = 0;
                }
            }
        }
    }

    public static void spread(){

        int[][] test = new int[n][m];
        for(int i = 0; i < area.length; i++) {
            test[i] = area[i].clone();
        }
        Queue<Point> copy = new LinkedList<>(q);

        while(!copy.isEmpty()){
            Point p = copy.poll();
            for(int i = 0; i < 4; i++){
                if(p.x + dx[i] >=0 && p.x + dx[i] < n && p.y + dy[i] >= 0 && p.y + dy[i] < m){
                    if(test[p.x + dx[i]][p.y + dy[i]] == 0){
                        test[p.x + dx[i]][p.y + dy[i]] = 2;
                        copy.offer(new Point(p.x + dx[i], p.y + dy[i]));
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(test[i][j] == 0) count++;
            }
        }
        result = Math.max(result, count);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        area = new int[n][m];

        q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] == 2){
                    q.offer(new Point(i, j));
                }
            }
        }
        result = 0;
        DFS(0);

        System.out.println(result);
    }
}

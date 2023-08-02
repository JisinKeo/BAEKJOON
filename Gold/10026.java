import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int n, count, acount;
    static char[][] picture;
    static int[][] checked, achecked;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        picture = new char[n][n];
        checked = new int[n][n];
        achecked = new int[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                picture[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(checked[i][j] == 0){
                    Queue<int[]> queue = new LinkedList<>();

                    queue.offer(new int[]{i, j});

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int k = 0; k < 4; k++){
                            if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<n){
                                if(picture[x+dx[k]][y+dy[k]] == picture[i][j] && checked[x+dx[k]][y+dy[k]] == 0){
                                    checked[x+dx[k]][y+dy[k]] = 1;
                                    queue.offer(new int[]{x+dx[k], y+dy[k]});
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(achecked[i][j] == 0 && (picture[i][j] == 'R' || picture[i][j] == 'G')){
                    Queue<int[]> queue = new LinkedList<>();

                    queue.offer(new int[]{i, j});

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int k = 0; k < 4; k++){
                            if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<n){
                                if((picture[x+dx[k]][y+dy[k]] == 'R' || picture[x+dx[k]][y+dy[k]] == 'G') && achecked[x+dx[k]][y+dy[k]] == 0){
                                    achecked[x+dx[k]][y+dy[k]] = 1;
                                    queue.offer(new int[]{x+dx[k], y+dy[k]});
                                }
                            }
                        }
                    }
                    acount++;
                }
                else if(achecked[i][j] == 0){
                    Queue<int[]> queue = new LinkedList<>();

                    queue.offer(new int[]{i, j});

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int k = 0; k < 4; k++){
                            if(x+dx[k]>=0 && x+dx[k]<n && y+dy[k]>=0 && y+dy[k]<n){
                                if(picture[x+dx[k]][y+dy[k]] == 'B' && achecked[x+dx[k]][y+dy[k]] == 0){
                                    achecked[x+dx[k]][y+dy[k]] = 1;
                                    queue.offer(new int[]{x+dx[k], y+dy[k]});
                                }
                            }
                        }
                    }
                    acount++;
                }
            }
        }

        System.out.println(count + " " + acount);

    }
}

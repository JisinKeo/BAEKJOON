import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o){
            return weight - o.weight;
        }
    }

    static int N, M, start, end;
    static List<Node>[] list;
    static int[] dist;
    static boolean[] check;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        dist = new int[N+1];
        check = new boolean[N+1];
        Arrays.fill(dist, INF);

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int cur = current.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}

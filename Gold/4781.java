import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);

            if(n == 0 && m == 0) break;

            int[] calorie = new int[n];
            int[] price = new int[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                calorie[i] = Integer.parseInt(st.nextToken());
                price[i] = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }

            int[] dp = new int[m+1];

            for(int i = 0; i < n; i++){
                for(int j = price[i]; j < m+1; j++){
                    dp[j] = Math.max(dp[j], dp[j-price[i]] + calorie[i]);
                }
            }
            System.out.println(dp[m]);
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
	
	static int n, m, r;
	
	static int[][] seq;
	static int[][] seq2;
	
	static int[] calculation;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	
    	seq = new int[n][m];
    	seq2 = new int[m][n];
    	
    	int check = 1;
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			seq[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	
    	calculation = new int[r];
    	
    	for(int k = 0; k < r; k++) {
    		calculation[k] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int k = 0; k < r; k++) {
    		if(calculation[k] == 1) {
    			int end =  n / 2;
    			for(int i = 0; i < end; i++) {
    				for(int j = 0; j < m; j++) {
    					int temp = seq[i][j];
    					seq[i][j] = seq[n-1-i][j];
    					seq[n-1-i][j] = temp;
    				}
    			}
    			check = 1;
    		} else if(calculation[k] == 2) {
    			int end = m / 2;
    			for(int i = 0; i < n; i++) {
    				for(int j = 0; j < end; j++) {
    					int temp = seq[i][j];
    					seq[i][j] = seq[i][m-1-j];
    					seq[i][m-1-j] = temp;
    				}
    			}
    			check = 1;
    		} else if(calculation[k] == 3) {
                int[][] temp = new int[m][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        temp[j][n - 1 - i] = seq[i][j];
                    }
                }
                seq = temp;
                int swap = n;
                n = m;
                m = swap;
                
            } else if(calculation[k] == 4) {
                int[][] temp = new int[m][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        temp[m - 1 - j][i] = seq[i][j];
                    }
                }
                seq = temp;
                int swap = n;
                n = m;
                m = swap;
                
            } else if(calculation[k] == 5) {
                int[][] temp = new int[n][m];

                int h = n / 2;
                int w = m / 2;

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        temp[i][j + w] = seq[i][j];
                        temp[i + h][j + w] = seq[i][j + w];
                        temp[i + h][j] = seq[i + h][j + w];
                        temp[i][j] = seq[i + h][j];
                    }
                }
                seq = temp;

            } else if(calculation[k] == 6) {
                int[][] temp = new int[n][m];

                int h = n / 2;
                int w = m / 2;

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        temp[i + h][j] = seq[i][j];
                        temp[i][j] = seq[i][j + w];
                        temp[i][j + w] = seq[i + h][j + w];
                        temp[i + h][j + w] = seq[i + h][j];
                    }
                }
                seq = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(seq[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}

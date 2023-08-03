import java.util.Scanner;

public class Main {
	
	static int n;
	
	public static void DFS(int num, int cipher) {
		if(cipher == n) {
			if(isPrime(num)) System.out.println(num);
		}
		
		
		if(isPrime(num)) {
			for(int i = 1; i < 10; i++) {
				DFS(num * 10 + i, cipher+1);
			}
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
	}
	
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

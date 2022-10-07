import java.util.Scanner;

// dynamic programming
public class P065_BJ1149_RGB거리 {

	/*
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][3];
		
		arr[0][0] = sc.nextInt();
		arr[0][1] = sc.nextInt();
		arr[0][2] = sc.nextInt(); 
		
		for (int n = 1; n < N; n++) {
			int red = sc.nextInt();
			arr[n][0] = Math.min(arr[n - 1][1] + red, arr[n - 1][2] + red);
			
			int green = sc.nextInt();
			arr[n][1] = Math.min(arr[n - 1][0] + green, arr[n - 1][2] + green);
			
			int blue = sc.nextInt();
			arr[n][2] = Math.min(arr[n - 1][0] + blue, arr[n - 1][1] + blue);
		}
		
		System.out.println(Math.min(Math.min(arr[N - 1][0], arr[N - 1][1]), Math.min(arr[N - 1][1], arr[N - 1][2])));
	}
	 */
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[3];
		
		for (int n = 0; n < N; n++) {
			int red = sc.nextInt();
			int green = sc.nextInt();
			int blue = sc.nextInt();
			
			red += Math.min(dp[1], dp[2]);
			green += Math.min(dp[0], dp[2]);
			blue += Math.min(dp[0], dp[1]);
			
			dp[0] = red;
			dp[1] = green;
			dp[2] = blue;
		}
		
		System.out.println(Math.min(Math.min(dp[0], dp[1]), Math.min(dp[1], dp[2])));
	}
}

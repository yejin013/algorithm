import java.io.BufferedReader;
import java.io.InputStreamReader;

// dynamic programming
public class P027_BJ1010_다리놓기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			
			int[][] dp = new int[N + 1][M + 1];
			for (int i = 1; i < M + 1; i++) { // mC1
				dp[1][i] = i;
			}
			
			for (int i = 1; i < N + 1; i++) { // N == M : mCn
				dp[i][i] = 1;
			}
			
			// Dynamic Programming
			for (int i = 2; i < N + 1; i++) { // mCn
				for (int j = i + 1; j < M + 1; j++) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				}
			}
			
			sb.append(dp[N][M] + "\n");
		}
		System.out.println(sb);
	}

}

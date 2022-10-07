import java.util.Scanner;

// 플로이드 워셜
public class P081_SWEA5643_키순서 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean[][] map = new boolean[N + 1][N + 1];
			
			for (int m = 0; m < M; m++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = true;
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (map[i][k] && map[k][j]) {
							map[i][j] = true;
						}
					}
				}
			}
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				int iCnt = 0;
				for (int j = 1; j <= N; j++) {
					if (map[i][j] || map[j][i]) iCnt++;
				}
				if (iCnt == N - 1) cnt++;
			}
			
			sb.append("#" + t + " " + cnt + "\n");
		}
		
		System.out.println(sb);
	}

}

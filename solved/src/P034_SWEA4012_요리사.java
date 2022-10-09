import java.io.BufferedReader;
import java.io.InputStreamReader;

// 조합
public class P034_SWEA4012_요리사 {

	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int value;
	
	static void comb(int cnt, int start) { 
		if (cnt == N / 2) { // 2개의 요리가 됐을 때 
			int temp1 = 0;
			int temp2 = 0;

			for (int i = 0; i < visit.length - 1; i++) {
				for (int j = i + 1; j < visit.length; j++) {
					if (visit[i] && visit[j]) temp1 += arr[i][j] + arr[j][i];
					else if (!visit[i] && !visit[j]) temp2 += arr[i][j] + arr[j][i];
				}
			}
			int tempValue = Math.abs(temp1 - temp2);
			value = value < tempValue ? value : tempValue;
			return;
		}

		for (int i = start; i < N; i++) {
			visit[i] = true;
			comb(cnt + 1, i + 1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 식재료 수
			arr = new int[N][N]; // 식재료 조합 값
			value = Integer.MAX_VALUE; // 최소값 구하기 
			visit = new boolean[N]; // 식재료 탐색 했는지 유무
			
			for (int i = 0; i < N; i++) {
				String[] s= br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			comb(0, 0); // 조합 
			sb.append("#" + t + " " + value + "\n");
		}
		System.out.println(sb);
	}
}

import java.util.Scanner;

public class P060_BJ10971_외판원순회2 {

	static int result;
	static int N;
	static int[][] W;
	static boolean[] visited;
	
	static void dfs(int start, int index, int cnt, int sum) {
		if (cnt == N && start == index) { // start까지 왔을 경우 
			result = result < sum? result : sum;
		}
		
		for (int i = 0; i < N; i++) {
			if (W[index][i] == 0) continue; // 없는 거 제외 
			if (visited[i]) continue; // 이미 방문한 거 제외 
			
			visited[i] = true;
			dfs(start, i, cnt + 1, sum + W[index][i]);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		W = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			dfs(i, i, 0, 0);
		}
		
		System.out.println(result);
	}

}

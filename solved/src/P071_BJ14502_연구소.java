import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// dfs
public class P071_BJ14502_연구소 {

	static int N, M, arr[][], max;
	static List<int[]> virus;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 세로 크기 
		M = Integer.parseInt(input[1]); // 가로 크기 
		
		arr = new int[N][M];
		virus = new ArrayList<>(); // 바이러스 가로, 세로 저장 
		for (int n = 0; n < N; n++) {
			input = br.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(input[m]);
				if (arr[n][m] == 2) {
					virus.add(new int[] {n, m});
				}
			}
		}
		dfs(0);
		
		System.out.println(max);
	}
	
	// 벽을 어디에 세울지 
	static void dfs(int cnt) {
		if (cnt == 3) {
			spread();
			return;
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (arr[n][m] == 0) {
					arr[n][m] = 1; // 벽 세우기 
					dfs(cnt + 1);
					arr[n][m] = 0; // 원상복귀 
				}
			}
		}
	}

	// 바이러스 뿌리기 
	static void spread() {
		int[][] virusArr = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				virusArr[n][m] = arr[n][m];
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int[] vi: virus) {
			q.offer(vi);
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if (nc < 0 || nc >= M || nr < 0 || nr >= N) continue;
				if (virusArr[nr][nc] == 0) { // 빈칸이면 바이러스 퍼트리기 
					virusArr[nr][nc] = 2;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		check(virusArr);
	}
	
	// 빈칸 개수 확인 
	static void check(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) cnt++;
			}
		}
		
		if (max < cnt) max = cnt;
	}
}

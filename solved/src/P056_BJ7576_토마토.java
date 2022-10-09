import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// bfs
public class P056_BJ7576_토마토 {

	static int N, M, day;
	static Queue<int[]> completed;
	static int[][] tomatoes;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void bfs() {

		while(!completed.isEmpty()) {
			int[] cur = completed.poll(); // 상단에 있는 거 뽑기 
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				
				if (tomatoes[nx][ny] == 0) {
					tomatoes[nx][ny] = 1;
					completed.offer(new int[] {nx, ny, cur[2] + 1});
				}
			}
			day = cur[2];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		completed = new ArrayDeque<>(); // 이미 다 익은 토마토 담는 배열 - 스타트  
		
		tomatoes = new int[M][N];
		
		int check = 0;
		
		// 입력 
		for (int m = 0; m < M; m++) {
			String[] input = br.readLine().split(" ");
			for (int n = 0; n < N; n++) {
				tomatoes[m][n] = Integer.parseInt(input[n]);
				if (tomatoes[m][n] == 1) {
					check++;
					completed.add(new int[] {m, n, 0});
				}
			}
		}
		if (check == N * M) { // 저장될 때부터 모든 토마토가 익어있는 상태 
			System.out.println(0);
			return;
		}
		
		bfs();

		check = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (tomatoes[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day); // 다 익었을 경우 
	}

}

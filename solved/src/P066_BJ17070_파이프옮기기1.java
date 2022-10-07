import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// dfs
public class P066_BJ17070_파이프옮기기1 {

	static int N;
	static int[][] house;
	static int answer;
	
	static void dfs(int x, int y, int dir) {

		if (x == N - 1 && y == N - 1) {
			answer++;
			return;
		}
	
		if (dir == 0) {
			int[] dx = {0, 1}; // 오른쪽, 대각선
			int[] dy = {1, 1};
			int[] dirSet = {0, 2};
			
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 밖
				if (house[nx][ny] == 1) continue; // 벽일 경우 
				if (dirSet[d] == 2) {
					if (house[nx - 1][ny] == 1 || house[nx][ny - 1] == 1) continue;
				}
				
				dfs(nx, ny, dirSet[d]);
			}
		} else if (dir == 1) {
			int[] dx = {1, 1}; // 세로, 대각선
			int[] dy = {0, 1};
			int[] dirSet = {1, 2};
			
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 밖
				if (house[nx][ny] == 1) continue; // 벽일 경우 
				if (dirSet[d] == 2) {
					if (house[nx - 1][ny] == 1 || house[nx][ny - 1] == 1) continue;
				}
				dfs(nx, ny, dirSet[d]);
			}
		} else {
			int[] dx = {0, 1, 1}; // 오른쪽, 아래, 대각선 
			int[] dy = {1, 0, 1};
			int[] dirSet = {0, 1, 2};
			
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 밖
				if (house[nx][ny] == 1) continue; // 벽일 경우 
				if (dirSet[d] == 2) {
					if (house[nx - 1][ny] == 1 || house[nx][ny - 1] == 1) continue;
				}
				dfs(nx, ny, dirSet[d]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][N];
		
		for (int n = 0; n < N; n++) {
			house[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	
		// 빈칸은 0, 벽은 1
		// (0, 0). (0, 1)은 항상 빈칸
		
		// dfs
		// 0 : 가로, 1 : 세로, 2 : 대각선
		dfs(0, 1, 0);

		System.out.println(answer);
	}

}



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P057_BJ10026_적록색약 {

	static char[][] part;
	static int N;
	static int yes; // 적록색약인 사람 
	static int no; // 적록색약이 아닌 사람 
	static boolean[][] visited; // 방문여부 
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1}; // 상하좌우 
	
	static void dfs(int x, int y, char cur) { // 색 같을 때까지만 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >=N || ny < 0 || ny >= N) continue; // 배열 밖을 나갈 경우 
			
			if (!visited[nx][ny] && part[nx][ny] == cur) { // 탐색 아직 안 했고, 색이 같을 경우 
				visited[nx][ny] = true; // 방문 체크 
				dfs(nx, ny, cur); // 같으면 더 탐색 
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		part = new char[N][N];
		visited = new boolean[N][N];
		
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int s = 0; s < N; s++) {
				part[n][s] = str.charAt(s);
			}
		}
		
		// 적록색약 X
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) { // 방문을 아직 안 했을 경우에만 탐색 
					visited[i][j] = true;
					char cur = part[i][j]; 
					dfs(i, j, cur);	
					no++;
				}
			}
		}
		
		visited = new boolean[N][N];
		
		// 적록색약 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (part[i][j] == 'G') part[i][j] = 'R';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true; // 방문을 아직 안 했을 경우에만 탐색 
					char cur = part[i][j];
					dfs(i, j, cur);	
					yes++;
				}
			}
		}
		
		System.out.println(no + " " + yes);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

// dfs
public class P042_BJ3109_빵집 {

	static int[] dx = {-1, 0, 1}; // 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선 
	static int[] dy = {1, 1, 1};
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		int count = 0;
		
		for (int i = 0; i < R; i++) { // 0 column 시작 모두 탐색 
			if (dfs(i, 0)) count++;
		}
		
		System.out.println(count);
		
	}
	
	static boolean dfs(int x, int y) {
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue; // 범위 밖 
			
			if (visited[nx][ny] == false && map[nx][ny] == '.') {
				visited[nx][ny] = true;
				if (ny ==  C - 1) return true; // 마지막 열에 도달했을 경우 
				if (dfs(nx, ny)) return true; // 다음 탐색도 전부 true  
			}
		}
			
		return false;
	}

}

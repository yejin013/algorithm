import java.io.BufferedReader;
import java.io.InputStreamReader;

// 순열
public class P044_BJ1987_알파벳 {

	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int[] dy = {0, 0, -1, 1};
	static String[][] alph;
	static boolean[] visited = new boolean[26];
	static int max;
	
	static void dfs(int x, int y, int cnt) {

		max = Math.max(cnt, max); // 갔다온 곳 체크 
		
		for (int d = 0; d < 4; d++) {
			// 이동할 위치 
			int nx = x + dx[d];
			int ny = y + dy[d];
				
			if (nx < 0 || nx >= alph.length || ny < 0 || ny >= alph[0].length) continue;
			
			if(visited[alph[nx][ny].charAt(0) - 'A']) continue;
			
			// 순열로 풀기
			visited[alph[nx][ny].charAt(0) - 'A'] = true;
			dfs(nx, ny, cnt + 1);
			visited[alph[nx][ny].charAt(0) - 'A'] = false;
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		
		alph = new String[R][C];
		for (int i = 0; i < R; i++) {
			alph[i] = br.readLine().split("");
		}
		
		visited[alph[0][0].charAt(0) - 'A'] = true; // 처음 간 곳 true 
		dfs(0, 0, 1); // 1행 1열 한 칸
		
		System.out.println(max);
	}

}

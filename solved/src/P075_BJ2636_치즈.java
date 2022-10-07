import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// bfs
public class P075_BJ2636_치즈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int total = 0;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		
		int[][] map = new int[R][C];
		// 입력받기 
		for (int r = 0; r < R; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] == 1) {
					total++;
				}
			}
		}
		
		int time = 0;
		int cnt = total;
		
		while(cnt > 0) {
			// bfs
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {0, 0});
			boolean[][] visited = new boolean[R][C];
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if (visited[nr][nc]) continue;
					
					if (map[nr][nc] == 0) {
						q.offer(new int[] {nr, nc});
					} else {
						map[nr][nc] = 0;
						cnt--;
					}
					visited[nr][nc] = true;
				}
			}
		
			time++;
			
			if (cnt != 0) {
				total = cnt;
			}
		}
		
		System.out.println(time);
		System.out.println(total);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


// bfs
public class P054_BJ13055_탈출 {

	static int answer;
	static char[][] arr;
	static boolean[][] visited;
	static int time;
	static Queue<int[]> q;
	static Queue<int[]> water;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C;
	
	static void bfs() {
		int size = q.size();
		int s = 0;
		while (s < size) { // 현재 depth 만큼만 돌기 위함 
			int[] cur = q.poll(); // 상단에 있는 거 뽑기
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				
				if (arr[nx][ny] == 'D') {
					answer = Math.min(answer, cur[2] + 1);
					return;
				}
				
				if (!visited[nx][ny] && arr[nx][ny] == '.') {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny, cur[2] + 1});
				}
			}
			s++;
		}
	}
	
	static void waterBfs() {
		int size = water.size(); // 현재 depth만 돌기 
		int s = 0;
		while(s < size) { // bfs
			int[] cur = water.poll(); // 상단에 있는 거 뽑기
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				
				if (arr[nx][ny] == '.') {
					arr[nx][ny] = '*';
					water.offer(new int[] {nx, ny});
				}
			}
			s++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		q = new ArrayDeque<>();
		water = new ArrayDeque<>();
		
		answer = Integer.MAX_VALUE;
		
		// 입력 
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = s.charAt(c);
				
				if (arr[r][c] == 'S') {
					q.offer(new int[] {r, c, 0});
				}  else if (arr[r][c] == '*') {
					water.offer(new int[] {r, c});
				}
			}
		}
		
		while(!q.isEmpty()) { // bfs
			// 물이 찰 예정인 곳을 탐색할 수 없으므로, 물을 그냥 먼저 채워버림 
			waterBfs(); // 한 depth 탐색이 끝나면 한 타임이 끝난 거기 때문에 물 채우기
			bfs();
		}
		
		if (answer == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(answer);
	}

}

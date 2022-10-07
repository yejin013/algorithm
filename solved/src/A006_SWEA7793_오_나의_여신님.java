import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// bfs인데, 한 depth만 돌기! 
public class A006_SWEA7793_오_나의_여신님 {

	static int answer;
	static char[][] arr;
	static boolean[][] visited;
	static int time;
	static Queue<int[]> q;
	static Queue<int[]> devils;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	
	static void move() { // 수연이가 움직이기 
		int size = q.size();
		int s = 0;
		while (s < size) { // 현재 depth 만큼만 돌기 위함 
			int[] cur = q.poll(); // 상단에 있는 거 뽑기
			
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dx[i];
				int nx = cur[1] + dy[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				
				if (arr[ny][nx] == 'D') { // 탈출 
					answer = Math.min(answer, cur[2] + 1);
					return;
				}
				
				if (!visited[ny][nx] && arr[ny][nx] == '.') {
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx, cur[2] + 1}); // 넣어놓고 다음 차례에 뽑음 
				}
			}
			s++;
		}
	}
	
	static void devil() { // 악마의 손아귀 뿌리기..
		int size = devils.size(); // 현재 depth만 돌기 
		int s = 0;
		while(s < size) { // bfs
			int[] cur = devils.poll(); // 상단에 있는 거 뽑기
			
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dx[i];
				int nx = cur[1] + dy[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				
				if (arr[ny][nx] == '.') {
					arr[ny][nx] = '*';
					devils.offer(new int[] {ny, nx});
				}
			}
			s++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			arr = new char[N][M];
			visited = new boolean[N][M];
			
			q = new ArrayDeque<>();
			devils = new ArrayDeque<>();
			
			answer = Integer.MAX_VALUE;
			
			// 입력 
			for (int n = 0; n < N; n++) {
				String s = br.readLine();
				for (int m = 0; m < M; m++) {
					arr[n][m] = s.charAt(m);
					
					if (arr[n][m] == 'S') { // 수연이 위치 
						q.offer(new int[] {n, m, 0}); // n, m, depth
					}  else if (arr[n][m] == '*') {
						devils.offer(new int[] {n, m});
					}
				}
			}
			
			while(!q.isEmpty()) { // bfs
				devil(); // 악마의 손아귀 
				move();
			}
			
			if (answer == Integer.MAX_VALUE) sb.append("#" + t + " GAME OVER\n");
			else sb.append("#" + t + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}

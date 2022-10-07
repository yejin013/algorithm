import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// bfs
public class P067_BJ1600_말이되고픈원숭이 {

	static class Monkey {
		int x, y, cnt, kCnt;

		public Monkey(int x, int y, int cnt, int kCnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.kCnt = kCnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int W = Integer.parseInt(input[0]); // 가로
		int H = Integer.parseInt(input[1]); // 세로
		
		int[][] arr = new int[H][W];
		int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
		boolean[][][] visited = new boolean[H][W][K + 1];
		int answer = 0;
		for (int h = 0; h < H; h++) {
			arr[h] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		// bfs
		Queue<Monkey> q = new ArrayDeque<>();
		q.offer(new Monkey(0, 0, 0, K));
		for (int k = 0; k <= K; k++) {
			visited[0][0][k] = true;
		}
		
		while (!q.isEmpty()) {
			Monkey cur = q.poll();

			if (cur.x == H - 1 && cur.y == W - 1) { // 종료조건 
				answer = cur.cnt;
				break;
			}
			
			for (int i = 0; i < d.length; i++) {
				int nx = cur.x + d[i][0];
				int ny = cur.y + d[i][1];
				
				if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if (arr[nx][ny] == 1) continue;
				if (visited[nx][ny][cur.kCnt]) continue;

				if (i >= 4) {
					if (cur.kCnt == 0) break; // 말처럼 움직이기 끝나면 더 이상 못함 for문 그 다음은 전부 말처럼 움직이기 때문에 진행하지 않음
					if (visited[nx][ny][cur.kCnt - 1]) continue;
					q.offer(new Monkey(nx, ny, cur.cnt + 1, cur.kCnt - 1));
					visited[nx][ny][cur.kCnt - 1] = true;
				} else {
					q.offer(new Monkey(nx, ny, cur.cnt + 1, cur.kCnt));
					visited[nx][ny][cur.kCnt] = true;
				}
			}
		}
		
		if(answer == 0 && !(W == 1 && H == 1)) answer = -1;
		System.out.println(answer);
	}

}

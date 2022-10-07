import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// bfs
public class P068_SWEA1249_보급로 {

	static class Point implements Comparable<Point> {
		int x, y, v;

		public Point(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return v - o.v;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<Point> q = new PriorityQueue<>();
			answer = arr[0][0];
			q.offer(new Point(0, 0, arr[0][0]));
			
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				if (cur.x == N - 1 && cur.y == N - 1) {
					answer = cur.v;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >=  N) continue;
					if (visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny, arr[nx][ny] + cur.v));
				}
			}
			
			sb.append("#" + t + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}

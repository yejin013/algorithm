

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {

	static int N;
	static int[][] graph, distance;
	
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우 
	static int[] dy = {0, 0, -1, 1};
	
	static class Character implements Comparable<Character> {
		int cost, x, y;

		public Character(int cost, int x, int y) {
			super();
			this.cost = cost;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Character o) {
			return this.cost - o.cost;
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Character> q = new PriorityQueue<>();
		q.offer(new Character(graph[0][0], 0, 0));
		distance[0][0] = 0;
		
		while(!q.isEmpty()) {
			Character pop = q.poll();
			
			if (pop.x == N - 1 && pop.y == N -1) return;
			
			for (int i = 0; i < 4; i++) {
				int nx = pop.x + dx[i];
				int ny = pop.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					int ncost = pop.cost + graph[nx][ny];
					
					if (ncost < distance[nx][ny]) {
						distance[nx][ny] = ncost;
						q.offer(new Character(ncost, nx, ny));
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			graph = new int[N][N];
			distance = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] input = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					graph[r][c] = Integer.parseInt(input[c]);
					distance[r][c] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			System.out.println("Problem " + t + ": " + distance[N - 1][N - 1]);
			t++;
		}
	}

}

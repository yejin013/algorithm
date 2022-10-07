

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class P055_BJ16236_아기상어 {
	
	static int N;
	static Queue<int[]> point;
	static int[][] arr;
	static int[][] dist;
	static ArrayList<int[]> fishes;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer;
	static int baby = 2;
	
	static void bfs() {
		int level = 0;
		
		while(!point.isEmpty()) { // bfs
			int[] cur = point.poll(); // 상단에 있는 거 뽑기 
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if (dist[nx][ny] == 0 && arr[nx][ny] <= baby) { // 이동 가능성 
					dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
					point.offer(new int[] {nx, ny});
						
					if (arr[nx][ny] >= 1 && arr[nx][ny] <= 6 && arr[nx][ny] < baby) { // 먹을 수 있을 경우 
						fishes.add(new int[] {nx, ny, dist[nx][ny]});
					}
				}
			}
			level++;
			
			if (!fishes.isEmpty()) {
				// 물고기 정렬 
				fishes.sort((int[] o1, int[] o2) -> {
					if (o1[0] == o2[0]) return o1[1] - o1[2];
					return o1[0] - o2[0];
				});
				int fishX = fishes.get(0)[0];
				int fishY = fishes.get(0)[1];
				answer += level;
				arr[fishX][fishY] = 0; // 먹음 
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		dist = new int[N][N];
		
		answer= 0;
		int zero = 0;

		// 입력 
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				
				if (arr[i][j] == 9) { // 아기 상어 위치 
					point = new ArrayDeque<>();
					point.offer(new int[] {i, j, 0}); // x, y
					arr[i][j] = 0;
					dist[i][j] = 0;
				} else if (arr[i][j] == 0) zero++;
			}
		}
		
		if (zero == N * N - 1) {
			System.out.println(answer);
			return;
		}

		int time = 0;
		while(true) {
			fishes = new ArrayList<>();
			
			bfs();
			if (fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			// 물고기 정렬 
			fishes.sort((int[] o1, int[] o2) -> {
				if (o1[0] == o2[0]) return o1[1] - o1[2];
				return o1[0] - o2[0];
			});
			
			int[] current = fishes.remove(0);
			time += dist[current[0]][current[1]];
			baby++;
		}
		
	}

}

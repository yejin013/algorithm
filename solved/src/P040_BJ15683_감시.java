import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// dfs
public class P040_BJ15683_감시 {

	static int answer;
	
	static ArrayList<int[]> cctv;
	
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};

	static int[][][] cctv_direction = {
			{{0}},
			{{0}, {1}, {2}, {3}}, // 1번 cctv
			{{0, 1}, {2, 3}}, // 2번 cctv
			{{0, 2}, {0, 3}, {1, 2}, {1, 3}}, // 3번 cctv
			{{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}, // 4번 cctv
			{{0, 1, 2, 3}} // 5번 cctv
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] graph = new int[N][M];
		cctv = new ArrayList<>();
		
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(line[j]);
				
				if (graph[i][j] >= 1 && graph[i][j] <= 5) {
					cctv.add(new int[] {i, j, graph[i][j]});
				}
			}
		}
		
		dfs(graph, 0);
		System.out.println(answer);
	}
	
	// cctv 종류별, 바라보는 방향별 감시영역 재귀적 탐색 
	static void dfs(int[][] graph, int depth) {
		
		// 종료조건 : 모든 CCTV 탐색
		if (depth == cctv.size()) {
			int count = 0;
			
			// 사각지대 개수 
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					if (graph[i][j] == 0) {
						count++;
					}
				}
			}
			answer = answer < count? answer: count;

			return;
		} 
		
		int[] cctvInfo = cctv.get(depth);
			
		for (int[] cd: cctv_direction[cctvInfo[2]]) {
			int[][] copyGraph = new int[graph.length][graph[0].length];
			
			// cctv를 다른 방향으로 재탐색 하기 위함 
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					copyGraph[i][j] = graph[i][j];
				}
			}

			// cctv 감시 영역 구하는 함수
			watch(cctvInfo[0], cctvInfo[1], cd, copyGraph);
			// 다른 모든 cctv 재귀적 탐색
			dfs(copyGraph, depth + 1);
		}
	}
	
	// cctv 감시영역 구하는 함수 
	static void watch(int x, int y, int[] direction, int[][] graph) {
		for (int d: direction) {
			// 특정 방향으로 벽을 만나거나 사무실을 벗어나기 전까지 탐색 
			int nx = x;
			int ny = y;
			while(true) {
				nx += dx[d];
				ny += dy[d];
				
				if (0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length) {
					if (graph[nx][ny] == 6) break; // 벽 만난 경우 
					else if (graph[nx][ny] == 0) graph[nx][ny] = 7; // 새로운 감시 가능 영역
 				} else break;
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class R002_15683_감시 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			input = br.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(input[m]);
			}
		}
		
		// cctv : 1부터 5까지 
		int[][][] cctv = {{{0}}, 
				{{1}, {0}}, // 1번 (오른쪽 방향 탐색)
				{{-1, 1}, {0, 0}}, // 2번 (양쪽 탐색)
				{{0, 1}, {-1, 0}}, // 3번 (위, 오른쪽 탐색)
				{{-1, 0, 1}, {0, -1, 0}}, // 4번 (왼쪽 위쪽 오른쪽 탐색)
				{{-1, 1, 0, 0}, {0, 0, -1, 1}} // 5번 (사방탐색)
		};
		
		// 벽은 6, 감시구역 = -1로 표시 
		// bfs로 풀어보기 
	}

}

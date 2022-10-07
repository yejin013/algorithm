

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class P047_BJ17135_캐슬디펜스 {

	static int max;
	static int[][] game;
	static int[] numbers;
	static ArrayList<Integer> archers;

	static int N, M, D;

	static void attack() {
		int[][] copy = new int[N][M]; // 메서드에 들어올 때마다 배열의 값에 변화를 주는데, 원본은 그대로 있어야 하기 때문에 copy
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copy[i][j] = game[i][j];

		int turn = 0; // 판 횟수
		int kill = 0; // 한 판에서 적을 죽인 수

		Queue<int[]> q = new ArrayDeque<>();

		while (turn < N) {
			for (int k = 0; k < 3; k++) {
				// 궁수의 x, y 좌표 
				int x = N - turn;
				int y = archers.get(k);

				int min = Integer.MAX_VALUE; // 최소 거리 구하기 위함 
				int minX = -1;
				int minY = -1;

				for (int i = N - turn - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (copy[i][j] == 1) {
							int dist = Math.abs(i - x) + Math.abs(j - y); // 거리 

							if (dist > D) continue;
							
							// 최소 거리일 경우 업데이트 
							if (dist < min) {
								min = dist;
								minX = i;
								minY = j;
							} else if (dist == min) { // 최소거리가 같을 경우 왼쪽 우선 제거 
								if (j < minY) {
									minX = i;
									minY = j;
								}
							}
						}
					}
				}

				if (minX == -1 || minY == -1)
					continue;

				q.offer(new int[] { minX, minY });
			}

			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.poll()[1];

				if (copy[x][y] == 1) { // 죽였으니까 0 
					copy[x][y] = 0;
					kill += 1;
				}
			}
			turn += 1;
		}
		// 최대로 적 죽이기 
		max = max > kill ? max : kill;
	}

	// cnt + 1번째 해당하는 조합에 포함될 수를 뽑기
	private static void find(int cnt, int start) { // cnt: 직전까지 뽑은 조합에 포함된 수의 개수, start: 시도할 수의 시작 위치 (반복을 돌 때 시작 위치만
													// 정함)

		if (cnt == 3) {
			// 적 죽이기
			attack();
			return;
		}

		// 가능한 모든 수에 대해 시도 (input 배열의 가능한 수 시도)
		// start 부터 처리시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for (int i = start; i < M; i++) { // 선택지
			archers.add(i);
			// 다음 수 뽑으러 가기
			find(cnt + 1, i + 1);
			archers.remove(archers.size() - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);

		game = new int[N][M];
		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				game[r][c] = Integer.parseInt(input[c]);
			}
		}

		archers = new ArrayList<>();
		numbers = new int[3];

		// 궁수 위치 조합
		find(0, 0);

		System.out.println(max);
	}

}
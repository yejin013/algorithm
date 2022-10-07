

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P028_BJ17406_배열돌리기4 {

	static int K;

	static int N;
	static int M;
	static int[] numbers;
	static boolean[] isSelected;
	
	static int[][] A;
	static int[] R;
	static int[] C;
	static int[] S;
	
	static final int[] dx = {1, 0, -1, 0}; // 하우상좌   
	static final int[] dy = {0, 1, 0, -1}; // 하우상좌 
	
	static int sum = Integer.MAX_VALUE;
	
	public static void Perm(int cnt) {
		
		if (cnt == K) {
			// 2차원 배열은 깊은 복사가 안 되기 때문에 수동으로 복사를 해준다. 
			int[][] newA = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					newA[i][j] = A[i][j];
				}
			}
			for (int n: numbers) { // 순열 배열 
				for (int s = 0; s < S[n]; s++) { // 회전 그룹 수 
					// 시작 x, y 
					int x = R[n] - S[n] + s;
					int y = C[n] - S[n] + s;

					int temp = newA[x][y]; // 첫번째 값 
					int dir = 0; // 방향 
					
					while(dir < 4) {
						// 이동 x, y 
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						
						if (nx < R[n] - S[n] + s || nx > R[n] + S[n] - s || ny < C[n] - S[n] + s || ny > C[n] + S[n] - s) { // 범위 벗어났을 경우 
							dir++;
						} else { // 범위 내 
							newA[x][y] = newA[nx][ny]; // 값 변경
							// 이동 
							x = nx;
							y = ny;
						}
					}
					newA[R[n] - S[n] + s][C[n] - S[n] + s + 1] = temp; // 저장했던 값을 마지막 위치에 넣기 
				}	
			}
			// sum 계산 
			for (int i = 1; i <= N; i++) {
				int t = 0;
				for (int j = 1; j <= M; j++) {
					t += newA[i][j];
				}
				sum = t < sum ? t : sum;
			}
			return;
		}
		for (int i = 0; i < K; i++) { // 순열 생성 
			if(isSelected[i]) continue; // 이미 선택되어있으면 이후 진행 X
			numbers[cnt] = i; // 값 넣기 
			isSelected[i] = true; // 선택하기 
			Perm(cnt + 1);
			isSelected[i] = false; // 선택 되돌리기 
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]); // N
		M = Integer.parseInt(line[1]); // M 
		K = Integer.parseInt(line[2]); // K
		
		A = new int[N + 1][M + 1]; // A 배열 입력받기 
		for (int i = 1; i <= N; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(line2[j - 1]);
			}
		}
		
		R = new int[K];
		C = new int[K];
		S = new int[K];
		
		// 순열 생성 때 사용할 배열들 초기화 
		numbers = new int[K];
		isSelected = new boolean[K];

		for (int i = 0; i < K; i++) {
			String[] line2 = br.readLine().split(" ");
			R[i] = Integer.parseInt(line2[0]); // r 입력받기 
			C[i] = Integer.parseInt(line2[1]); // c 입력받기 
			S[i] = Integer.parseInt(line2[2]); // s 입력받기 
		}
		
		Perm(0); 

		System.out.println(sum);
	}
}

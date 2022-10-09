import java.io.BufferedReader;
import java.io.InputStreamReader;

// 구현
public class P026_BJ16935_배열돌리기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] line = br.readLine().split(" "); // N, M, R 한 줄 입력받기 
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int R = Integer.parseInt(line[2]);
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) { // 배열 입력받기 
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line2[j]);
			}
		}
		
		int[] arrR = new int[R]; 
		String[] line3 = br.readLine().split(" "); // 연산 입력 받기 
		for (int i = 0; i < R; i++) {
			arrR[i] = Integer.parseInt(line3[i]);
		}
		
		for (int r: arrR) { // 연산 배열 R개의 연산 수행 
			int n = arr.length;
			int m = arr[0].length;
			
			switch(r) { // 연산 번호에 맞게 연산 수행 
			case 1: // 상하반전 
				for (int i = 0; i < n / 2; i++) {
					int[] temp = arr[i];
					arr[i] = arr[n - 1 - i];
					arr[n - 1 - i] = temp;
				}
				break;
			case 2: // 좌우 반전 
				for (int i = 0; i < m / 2; i++) {
					for (int j = 0; j < n; j++) {
						// column을 기준으로 row 값 스위치 
						int temp = arr[j][i];
						arr[j][i] = arr[j][m - 1 - i];
						arr[j][m - 1 - i] = temp;
					}
				}
				break;
			case 3: // 오른쪽으로 90도 회전 
				int[][] newArr = new int[m][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						newArr[j][n - 1 - i] = arr[i][j]; // (0, 0)이 (0, n-1)로, (0, n-1)이 (n-1, n-1)로 
					}
				}
				arr = newArr;
				break;
			case 4: // 왼쪽으로 90도 회전 
				int[][] newArr2 = new int[m][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						newArr2[m - 1 - j][i] = arr[i][j]; // (0, 0)이 (n-1, 0)로, (0, n-1)이 (0, 0)로 
					}
				}
				arr = newArr2;
				break;
			case 5: // 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동
				int[][] newArr3 = new int[n][m];
				for (int i = 0; i < n / 2; i++) { // 1 : (0, 0), 2 : (0, M / 2), 3 : (N / 2, M / 2), 4 : (N / 2, 0)
					for (int j = 0; j < m / 2; j++) {
						newArr3[i][m / 2 + j] = arr[i][j]; // 1 -> 2
						newArr3[n / 2 + i][m / 2 + j] = arr[i][m / 2 + j]; // 2 -> 3
						newArr3[n / 2 + i][j] = arr[n / 2 + i][m / 2 + j]; // 3 -> 4
						newArr3[i][j] = arr[n / 2 + i][j]; // 4 -> 1
					}
				}
				arr = newArr3;
				break;
			case 6: // 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동
				int[][] newArr4 = new int[n][m];
				for (int i = 0; i < n / 2; i++) { // 1 : (0, 0), 2 : (0, M / 2), 3 : (N / 2, M / 2), 4 : (N / 2, 0)
					for (int j = 0; j < m / 2; j++) {
						newArr4[n / 2 + i][j] = arr[i][j]; // 1 -> 4
						newArr4[i][j] = arr[i][m / 2 + j]; // 2 -> 1
						newArr4[i][m / 2 + j] = arr[n / 2 + i][m / 2 + j]; // 3 -> 2
						newArr4[n / 2 + i][m / 2 + j] = arr[n / 2 + i][j]; // 4 -> 3
					}
				}
				arr = newArr4;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) { // 출력 
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

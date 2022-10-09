import java.io.BufferedReader;
import java.io.InputStreamReader;

// 누적합
public class P010_BJ11660_구간합구하기5 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위함
		StringBuilder sb = new StringBuilder(); // 출력을 위함
		
		// N, M 받기 
		String[] NM = reader.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] arr = new int[N][N + 1]; // 배열 저장
		
		for (int i = 0; i < N; i++) { // 한 줄씩 sum이 이루어지고, y2 배열 값에서 y1 배열 값을 뺄 것이기 때문에 y1이 1이었을 때를 위해 0 넣기 
			arr[i][0] = 0;
		}
		
		// 입력 받는 동시에 합 계산
		for (int n = 0; n < N; n++) {
			String[] input = reader.readLine().split(" ");
			
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += Integer.parseInt(input[i - 1]);
				arr[n][i] = sum;
			}
		}
		
		for (int m = 0; m < M; m++) {
			String[] input = reader.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]) - 1;
			int x2 = Integer.parseInt(input[2]) - 1;
			int y1 = Integer.parseInt(input[1]); // 0을 넣어줬기 때문에 -1 안 해도 됨
			int y2 = Integer.parseInt(input[3]);
			
			int sum = 0;
			
			for (int x = x2; x >= x1; x--) { // x를 변경주면서 답 도출 
				sum += (arr[x][y2] - arr[x][y1 - 1]);
			}
			
			sb.append(sum + "\n");
		}
		System.out.print(sb);
	}

}

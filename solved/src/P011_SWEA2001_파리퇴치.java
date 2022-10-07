

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P011_SWEA2001_파리퇴치 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위함
		StringBuilder sb = new StringBuilder(); // 출력을 위함
		 
		int T = Integer.parseInt(reader.readLine()); // test_case 횟수
		
		for (int test_case = 1; test_case <= T; test_case++) { // test_case 만큼 반복문 돌리기 
			// N, M 한줄에 입력받기
			String[] nm = reader.readLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			
			int[][] arr = new int[N][N]; // NxN 배열 
			
			for (int n = 0; n < N; n++) {
				// NxN string 값으로 받아서 int 배열로 변환
				int[] newArr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				arr[n] = newArr;
			}
			
			int answer = 0; // 답 도출하기 위함
			
			// MxM 크기의 배열의 합을 더하기 위함 
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int temp = 0;
					for (int a = i; a < i + M; a++) {
						for (int b = j; b < j + M; b++) {
							temp += arr[a][b];
						}
					}
					answer = Math.max(temp, answer); // 새로운 합과 기존의 합 비교해서 더 큰 값을 답에 저장 
				}
			}
			
			sb.append("#" + test_case + " " + answer + "\n"); // 출력값
		}
		
		System.out.println(sb);
	}

}

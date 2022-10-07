import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 기초 문제
public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = Integer.parseInt(in.readLine()); // 농장 크기 
			
			int[][] arr = new int[N][];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String input = in.readLine(); // 한 줄 받기 
				int[] newArr = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray(); // String 배열을 int 배열로 변환
				arr[i] = newArr; // 2차원 배열에 1차원 배열 저장 
			}
			
			int middle = N / 2; // 중앙값
			int last = arr.length - 1; // 배열 끝 값
			
			for (int i = 0; i < middle; i++) { // 가운데 row 제외 모든 값 더하기
				// 세로 가운데 값 더하기
				sum += arr[i][middle];
				sum += arr[last - i][middle];
				
				for(int j = middle - i; j < middle; j++) { // 가운데 값들 제외 더하기 
					sum += arr[i][j];
					sum += arr[last - i][j];
					sum += arr[i][last - j];
					sum += arr[last - i][last - j];
				}
			}
			
			for (int i = 0; i < arr.length; i++) { // 가운데 row 값 더하기 
				sum += arr[middle][i];
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " " + sum);
			System.out.println(sb);
		}
	}

}

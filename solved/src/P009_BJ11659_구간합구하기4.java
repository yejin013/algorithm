import java.io.BufferedReader;
import java.io.InputStreamReader;

// 누적합
public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함
		
		// N, M 입력
		String[] input = reader.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 배열 입력
		input = reader.readLine().split(" ");
		int[] arr = new int[N + 1];
		arr[0] = 0; // 뺄 때 편하기 위함 (배열의 위치가 1, 4로 왔을 때 배열 위치 4에서 0을 빼면 답이 나오도록)

		int sum = 0; // 합 계산
		for (int in = 1; in <= N; in++) {
			// 합을 계산한 채로 배열에 저장 
			sum += Integer.parseInt(input[in - 1]);
			arr[in] = sum;
		}
		
		// 구간합 출력 
		for (int in = 0; in < M; in++) {
			input = reader.readLine().split(" ");
			
			sb.append((arr[Integer.parseInt(input[1])] - arr[Integer.parseInt(input[0]) - 1]) + "\n");
		}
		
		System.out.println(sb);
	}

}

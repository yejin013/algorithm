import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 기초 문제
public class P004_SWEA1208_Flatten {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 버퍼리더

		for (int tc = 1; tc <= 10; tc++) { // test_case 횟수만큼 반복 
			int count = Integer.parseInt(in.readLine()); // 덤프 횟수 입력
			
			String input = in.readLine(); // 한 줄 받기 
			int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); // String 배열을 int 배열로 변환
			Arrays.sort(arr); // 정렬
			
			int length = arr.length - 1; // 마지막 배열 접근
			for (int c = 1; c <= count; c++) { // 덤프 횟수만큼 반복 
				arr[0]++; // min 값 증가
				arr[length]--; // max 값 감소
				Arrays.sort(arr); // 정렬
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " " + (arr[length] - arr[0]));
			System.out.println(sb); // 최댓값에서 최솟값 차이 출력 
		}
	}

}

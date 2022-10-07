import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 큐
public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함
		
		for (int test_case = 1; test_case <= 10; test_case++) { // test_case는 10개 
			int TC = Integer.parseInt(in.readLine()); // 출력을 위한 test_case 번호 입력 받기 
			
			Deque<Integer> queue = new ArrayDeque<>(); // 큐로 배열 저장 
			
			int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 배열을 입력 받고 int 배열로 변경 
			
			for (int i = 0; i < 8; i++) { // 배열의 값을 큐에 저장 
				queue.offer(arr[i]);
			}
			
			int minus = 1; // 사이클 하나 당 5번 숫자가 적어지기 때문에 그것을 체크 + 계산하기 위함 
			while(true) {
				int n = queue.poll();
				if (n - minus <= 0) {
					queue.add(0);
					
					int check = 0;
					for (int i = 0; i < 8; i++) {
						int q = queue.poll();
						if (q / 10 == 0) {
							check++;
						}
						queue.add(q);
					}
					if (check == 8) {
						break;
					}
					
				} else {
					queue.add(n - minus);
				}
				minus++;
				
				if (minus > 5) {
					minus = 1;
				}
			}

			sb.append("#" + TC + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

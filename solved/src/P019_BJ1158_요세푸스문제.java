import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 큐
// ArrayList보다 ArrayDeque가 더 빠름 - ArrayList를 쓰면 시간 초과, ArrayDeque를 쓰면 정답 
public class P019_BJ1158_요세푸스문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함 
		int N = sc.nextInt(); // 총 숫자 개수 
		int K = sc.nextInt(); // 제거할 index 
		
		Queue<Integer> list = new ArrayDeque<>(); // 숫자 담을 queue 
		for (int i = 1; i <= N; i++) { // i부터 N까지 queue에 담기 
			list.add(i);
		}
		
		sb.append("<");
		while (list.size() > 1) { // list에 하나만 남을 때까지 
			for (int i = 1; i < K; i++) {
				list.offer(list.poll()); // K 전까지는 빼고 넣기 반복 
			}
			sb.append(list.poll() + ", "); // K 위치에 있는 것 제거하면서 출력 
		}
			
		sb.append(list.peek() + ">"); // 마지막 출력은 형태가 다름.
		System.out.println(sb); // 출력 
	}

}

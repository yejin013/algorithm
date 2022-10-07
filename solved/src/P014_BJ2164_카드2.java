import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 큐
public class P014_BJ2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n 입력받기 
		
		// 큐 선언 
		Deque<Integer> queue = new ArrayDeque<>();
		// 1부터 n 카드 큐에 담기
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while(queue.size() > 1) { // 큐의 사이즈가 1이면 그만 while 문을 돌도록 
			queue.poll(); // 가장 상위에 있는 것 빼기 
			int i = queue.poll(); // 가장 상위에 있는 것 저장
			queue.offer(i); // 가장 하위에 저장 
		}
		
		System.out.println(queue.poll());
	}

}

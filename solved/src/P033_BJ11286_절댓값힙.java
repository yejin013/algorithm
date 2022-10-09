import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 우선순위 큐
public class P033_BJ11286_절댓값힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
				if (Math.abs(o1) - Math.abs(o2) != 0) return Math.abs(o1) - Math.abs(o2); // 절댓값 크기가 다르면 절댓값이 더 작은 거 순으로
				return o1 - o2; // 절댓값이 같으면 -가 더 작은 값 
		}); // 작은 순서대로 정렬 
		for (int i = 0; i < N; i++) { // N만큼 돌기 
			int n = Integer.parseInt(br.readLine()); // 방금 받은 값 
			if (n == 0) { // 0이면
				if (pq.isEmpty()) sb.append(0 + "\n"); // pq에 들어있는 값이 없으면 0 출력 
				else sb.append(pq.poll() + "\n"); // 배열에서 가장 작은 값 제거 
			}
			else { // 0이 아니면 
				pq.offer(n); // 넣기 
			}
		}
		System.out.println(sb);
	}
}
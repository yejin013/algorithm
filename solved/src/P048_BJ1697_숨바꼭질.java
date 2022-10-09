import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


// bfs
public class P048_BJ1697_숨바꼭질 {

	static int K;
	static boolean[] visited = new boolean[100001];
	
	static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		visited[start] = false;
	
		while (!q.isEmpty()) {
			int[] current = q.poll();	
			
			if (current[0] == K) {
				System.out.println(current[1]);
				return;
			}
			
			// - 1
			if (current[0] - 1 >= 0 && !visited[current[0] - 1]) {
				q.offer(new int[] {current[0] - 1, current[1] + 1});
				visited[current[0] - 1] = true;
			}
			
			// + 1
			if (current[0] + 1 < 100001  && !visited[current[0] + 1]) {
				q.offer(new int[] {current[0] + 1, current[1] + 1});
				visited[current[0] + 1] = true;
			}
			
			// * 2
			if (current[0] * 2 < 100001 && !visited[current[0] * 2]) {
				q.offer(new int[] {current[0] * 2, current[1] + 1});
				visited[current[0] * 2] = true;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		K = sc.nextInt();

		if (N == K) System.out.println(0);
		else bfs(N);
	}
}

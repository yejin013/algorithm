

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class P045_BJ1260_DFS와BFS {

	static int N, M;
	static int[][] arr;
	
	static int[][] list;
	static boolean[] visited;

	static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		
		for(int i = 0; i < M * 2; i++) { // dfsList 배열 탐색 
			if (list[i][0] == start) { // 시작점이 현재와 같으면
				if (!visited[list[i][1]]) { // 연결된 점이 방문됐는지 체크 
					dfs(list[i][1]); // 그 다음 탐색 
				}
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int t = q.poll();
			System.out.print(t + " "); // 꺼낸 거 출력 
			for(int i = 0; i < M * 2; i++) { // list 배열 탐색 
				if (list[i][0] == t) {
					if (!visited[list[i][1]]) { // 연결된 점이 방문됐는지 체크 
						q.offer(list[i][1]); // 큐에 넣기 
						visited[list[i][1]] = true; // 방문 체크 
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		list = new int[M * 2][2];
		// 간선이 연결하는 두 정점의 번호들 
		for (int i = 0; i < M * 2; i += 2) {	
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 양방향 저장 
			list[i][0] = from;
			list[i][1] = to;
			list[i + 1][0] = to;
			list[i + 1][1] = from;
		}
		
		Arrays.sort(list, (int[] e1, int[] e2) -> e1[1] - e2[1]); // 숫자가 더 작은 목적지 부터 가도록  
		
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(V);
	}

}

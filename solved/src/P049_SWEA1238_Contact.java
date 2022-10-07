

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayDeque;

public class P049_SWEA1238_Contact {

	static int[][] graph;
	static int[] depth;
	static int answer;
	
	public static void bfs(int start) { // bfs의 leaf 노드의 최댓값 
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		depth[start] = 1;
		
		while(!q.isEmpty()) { // q가 비어있을 동안 
			int cur = q.poll(); // 현재 꺼낸 거 
				
			for (int i = 0; i < 101; i++) {
				if (graph[cur][i] == 1 && depth[i] == 0) { // 아직 방문 안 했는데, 갈 수 있는 그래프일 경우 
					q.offer(i);
					depth[i] = depth[cur] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			answer = -1;
		
			String[] s = br.readLine().split(" ");
			int length = Integer.parseInt(s[0]);
			int start = Integer.parseInt(s[1]);
			
			s = br.readLine().split(" ");
			
			graph = new int[101][101];
			depth = new int[101];
			for (int l = 0; l < length; l += 2) {
				graph[Integer.parseInt(s[l])][Integer.parseInt(s[l + 1])] = 1; // from - to 연결 
			}
			
			bfs(start);
			
			int max = 0;
			for (int i = 0; i < depth.length; i++) {
				if (max <= depth[i]) {
					max = depth[i]; // depth 
					if (answer < i) answer = i; // node 번호 업데이트 
				}
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}

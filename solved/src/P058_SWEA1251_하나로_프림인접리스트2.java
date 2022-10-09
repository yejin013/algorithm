import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// PRIM
public class P058_SWEA1251_하나로_프림인접리스트2 {

	static class Node {
		int no;
		long length;
		Node next;

		public Node(int no, long length, Node next) {
			super();
			this.no = no;
			this.length = length;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		int no;
		long length;
		
		public Vertex(int no, long length) {
			super();
			this.no = no;
			this.length = length;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.length, o.length);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[] adjList = new Node[N];
			
			long[] X = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] Y = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율 실수 
			
			// 모든 간선의 비용 저장 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue; // 본인 자신 제외 
					adjList[i] = new Node(j, (Math.abs(X[i] - X[j]) * Math.abs(X[i] - X[j])) + (Math.abs(Y[i] - Y[j]) * Math.abs(Y[i] - Y[j])), adjList[i]);
				}
			}
			
			long[] minEdge = new long[N];
			long minLength = 0;
			
			Arrays.fill(minEdge, Integer.MAX_VALUE); 
			
			boolean[] visited = new boolean[N];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, minEdge[0]));
			
			minEdge[0] = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				Vertex minVertex = pq.poll();

				visited[minVertex.no] = true;
				minLength += minVertex.length;
				if (++cnt == N) break;
				
				for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
					if (!visited[temp.no] && minEdge[temp.no] > temp.length) {
						minEdge[temp.no] = temp.length;
						pq.add(new Vertex(temp.no, minEdge[temp.no]));
					}
				}
			}
			
			sb.append("#" + t + " " + Math.round(minLength * E) + "\n");
		}
		
		System.out.println(sb);
	}

}

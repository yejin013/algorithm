

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P059_SWEA1251_하나로_프림인접행렬 {
	
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
			
			Vertex[][] adjArray = new Vertex[N][N];
			
			long[] X = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] Y = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율 실수 
			
			// 모든 간선의 비용 저장 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue; // 본인 자신 제외 
					adjArray[i][j] = new Vertex(j, (Math.abs(X[i] - X[j]) * Math.abs(X[i] - X[j])) + (Math.abs(Y[i] - Y[j]) * Math.abs(Y[i] - Y[j])));
				}
			}
			
			long minLength = 0;
			
			boolean[] visited = new boolean[N];
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, (long)0));
			
			int cnt = 0;
			while(!pq.isEmpty()) {
				Vertex v = pq.poll();

				if (visited[v.no]) continue;
				visited[v.no] = true;
				minLength += v.length;
				if (++cnt == N) break;
				
				for (int i = 0; i < N; i++) {
					if (adjArray[v.no][i] != null) {
						Vertex next = adjArray[v.no][i];
						if (!visited[next.no]) {
							pq.add(next);
						}
					}
				}
			}
			
			sb.append("#" + t + " " + Math.round(minLength * E) + "\n");
		}
		
		System.out.println(sb);
	}

}

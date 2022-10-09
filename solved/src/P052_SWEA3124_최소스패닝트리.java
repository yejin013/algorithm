import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 서로소 집합
public class P052_SWEA3124_최소스패닝트리 {

	static int[] parents;
	static int V, E;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight -  o.weight;
		}
	}
	
	static void make() { // 크기가 1인 서로소 집합 생성 
		parents = new int[V + 1];
		
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) { // a의 대표자 찾기 
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) { // 리턴값 : true => union 성공 
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			V = Integer.parseInt(str[0]);
			E = Integer.parseInt(str[1]);
			
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				str = br.readLine().split(" ");
				edgeList[i] = new Edge(Integer.parseInt(str[0]),
						Integer.parseInt(str[1]), 
						Integer.parseInt(str[2]));
			}
			
			make();
			Arrays.sort(edgeList);
			
			long result = 0;
			int count = 0;
			for (Edge edge: edgeList) {
				if (union(edge.from, edge.to)) { // union 시키기 - 분리되어 있던 것 
					result += edge.weight; // 가중치 비용 누적 
					if (++count == V - 1) break; 
				}
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}

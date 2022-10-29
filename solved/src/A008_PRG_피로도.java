
public class A008_PRG_피로도 {

	static int total;
	static boolean[] visited;
	
	static void dfs(int k, int[][] dungeons, int cnt) {
		for (int i = 0; i < dungeons.length; i++) {
			if (k < dungeons[i][0] || visited[i]) continue;
			visited[i] = true;
			dfs(k - dungeons[i][1], dungeons, cnt + 1);
			visited[i] = false;
		}
		total = total > cnt? total: cnt;
	}
	
	static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		dfs(k, dungeons, 0);
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
	}

}

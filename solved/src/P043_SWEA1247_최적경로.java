import java.io.BufferedReader;
import java.io.InputStreamReader;

// 순열
public class P043_SWEA1247_최적경로 {

	static int[] house;
	static int[][] consumer;
	static boolean[] visited;
	static int distance;
	
	private static void perm(int index, int x, int y, int sum) {
	    
	    if(index == consumer.length) {    // 종료조건
	        sum += Math.abs(x-house[0]) + Math.abs(y-house[1]);
	        distance = Math.min(distance, sum);
	        return;
	    }

	    for(int i = 0; i < consumer.length; i++) {
	        if(visited[i]) continue;    // 방문했으면 다음 집으로 넘어감
	        // 방문 안했으면
	        int d = Math.abs(x-consumer[i][0]) + Math.abs(y-consumer[i][1]);
	        visited[i] = true;
	        // 그 다음 집으로 넘어가기
	        perm(index+1, consumer[i][0], consumer[i][1], sum+d);
	        visited[i] = false;
	    }
	        
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] input = br.readLine().split(" ");
			
			distance = Integer.MAX_VALUE;
			
			int[] company = new int[2];
			company[0] = Integer.parseInt(input[0]);
			company[1] = Integer.parseInt(input[1]);
			
			house = new int[2];
			house[0] = Integer.parseInt(input[2]);
			house[1] = Integer.parseInt(input[3]);
			
			consumer = new int[N][2];
			for (int i = 0, j = 4; i < N; i++, j += 2) {
				consumer[i][0] = Integer.parseInt(input[j]);
				consumer[i][1] = Integer.parseInt(input[j + 1]);
			}
			visited = new boolean[N]; // 고객방문여부 
			
			perm(0, company[0], company[1], 0); // 고객 index, x, y, 방문 개수, 이동거리 
			
			sb.append("#" + t + " " + distance + "\n");
		}
		System.out.println(sb);
	}

}

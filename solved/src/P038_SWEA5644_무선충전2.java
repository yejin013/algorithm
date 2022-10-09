import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P038_SWEA5644_무선충전2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int[] dx = {0, 0, 1, 0, -1}; // 이동X, 상, 우, 하, 좌 
		final int[] dy = {0, -1, 0, 1, 0}; // 이동X, 상, 우, 하, 좌
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t < T; t++) {
			int answer = 0;
			
			String[] line = br.readLine().split(" ");
			int M = Integer.parseInt(line[0]);
			int A = Integer.parseInt(line[1]);
			

			line = br.readLine().split(" ");
			int[] userA = new int[M + 1];
			
			for(int i = 1; i <= M; i++) {
				userA[i] = Integer.parseInt(line[i - 1]);
			}
			
			line = br.readLine().split(" ");
			int[] userB = new int[M + 1];
			for(int i = 1; i <= M; i++) {
				userB[i] = Integer.parseInt(line[i - 1]);
			}
			
			int[][] BC = new int[A][4];
			for(int i = 0; i < A; i++) {	// X, Y, C, P
				line = br.readLine().split(" ");

				BC[i][0] = Integer.parseInt(line[0]);
				BC[i][1] = Integer.parseInt(line[1]);
				BC[i][2] = Integer.parseInt(line[2]);
				BC[i][3] = Integer.parseInt(line[3]);
			}
			
			int Ax = 1;
			int Ay = 1;
			int Bx = 10;
			int By = 10;
			
			for (int i = 0; i <= M; i++) { // 이동만큼 
				// 이동 위치 
				Ax += dx[userA[i]];
				Ay += dy[userA[i]];
				Bx += dx[userB[i]];
				By += dy[userB[i]];
				
				PriorityQueue<int[]> aPos = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
				PriorityQueue<int[]> bPos = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
				
				int max = 0;
				
				for (int j = 0; j <	A; j++) {
					if(Math.abs(Ax - BC[j][0]) + Math.abs(Ay - BC[j][1]) <= BC[j][2]) aPos.add(BC[j]);
					if(Math.abs(Bx - BC[j][0]) + Math.abs(By - BC[j][1]) <= BC[j][2]) bPos.add(BC[j]);
				}
				
				int sum = 0;
				
				if (!aPos.isEmpty() && !bPos.isEmpty()) {
					for (int[] aBC : aPos) {
						for (int[] bBC : bPos) {
							if (aBC[0] == bBC[0] && aBC[1] == bBC[1]) { // 같은 경우 
								sum = (sum < aBC[3]) ? aBC[3] : sum;
								continue;
							}
							// 같지 않을 경우 
							sum = (sum < aBC[3] + bBC[3]) ? aBC[3] + bBC[3] : sum;
						}
					}
				}
				else if (!aPos.isEmpty() && bPos.isEmpty()) {
					sum = aPos.poll()[3];
				}
				else if (aPos.isEmpty() && !bPos.isEmpty()) {
					sum = bPos.poll()[3];
				}
				
				answer += sum;
			}
			
			
			sb.append("#"+ t + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}

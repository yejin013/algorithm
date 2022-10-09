import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 구현
public class P063_SWEA_4013_특이한자석 {
	
	static int[][] magnet;
	static int sum;
	
	static void rotate(int index) { // 정방향으로 돌기
			int start = magnet[index][7];
			for (int i = 0; i < 7; i++) {
				magnet[index][i] = magnet[index][i + 1];
			}
			magnet[index][0] = start;	
			sum += Math.pow(2, index);
	}
	
	static void inrotate(int index) { // 반시계방향으로 돌기 
			int end = magnet[index][0];
			for (int i = 7; i > 0; i--) {
				magnet[index][i] = magnet[index][i - 1];
			}
			magnet[index][7] = end;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sum = 0;
			int K = Integer.parseInt(br.readLine());
			
			magnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				 magnet[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			for (int i = 0; i < K; i++) {
				 String[] input = br.readLine().split(" ");
				 int index = Integer.parseInt(input[0]) - 1;
				 int d = Integer.parseInt(input[1]);
				 
				 if (d == 1) {
						if ((index == 3 || (index < 3 && magnet[index][2] != magnet[index + 1][6])) 
								 && (index == 0 || index > 0 && magnet[index][6] != magnet[index - 1][2])) {
							rotate(index); // 시작 
						}
					int cnt = 1;
					while(cnt <= 3) {
						if (index + 1 == 4) index = 0;
						else ++index;
						if (cnt % 2 == 1) {
							inrotate(index);
						} else {
							rotate(index);
						}
						cnt++;
					}
				 } else if (d == -1) {
					inrotate(index);
					int cnt = 1;
					while(cnt <= 3) {
						if (index + 1 == 4) index = 0;
						else ++index;
						if (cnt % 2 == 1) {
							rotate(index);
						} else {
							inrotate(index);
						}
						cnt++;
					}
				 }
			}
			System.out.println(Arrays.toString(magnet[0]));
			System.out.println(Arrays.toString(magnet[1]));
			System.out.println(Arrays.toString(magnet[2]));
			System.out.println(Arrays.toString(magnet[3]));
			System.out.println("#" + t + " " + sum);
		}
	}

}

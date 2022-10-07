import java.util.Scanner;

public class A002_SWEA6485_삼성시의_버스_노선 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N + 1][2];
			for (int i = 1; i <= N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			int P = sc.nextInt();
			int[][] C = new int[P + 1][2];
			for (int i = 1; i <= P; i++) {
				C[i][0] = sc.nextInt();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int a = arr[i][0]; a <= arr[i][1]; a++) {
					for (int c = 1; c <= P; c++) {
						if (a == C[c][0]) {
							C[c][1]++;
						}
					}
				}
			}
			
			sb.append("#" + t);
			
			for (int i = 1; i <= P; i++) {
				sb.append(" " + C[i][1]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

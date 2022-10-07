import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A004_BJ14503_로봇_청소기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] vac = new int[N][3];
		for (int i = 0; i < N; i++) { // 입력받기 
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) vac[i][j] = Integer.parseInt(s[j]);
		}
		
		int[][] map = new int[N][M];
	}

}

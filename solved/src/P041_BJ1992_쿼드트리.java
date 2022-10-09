import java.io.BufferedReader;
import java.io.InputStreamReader;

// 분할정복
public class P041_BJ1992_쿼드트리 {

	static int[][] QT;
	static String quad(int r, int c, int size) {
		int count0 = 0;
		int count1 = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (QT[i][j] == 0) count0++;
				else if (QT[i][j] == 1) count1++;
			}
		}
		
		if (count0 == 0) return "1"; // 전부 1일 때
		if (count1 == 0) return "0"; // 전부 0일 때
		
		if (size == 2) {
			return "(" + QT[r][c] + "" + QT[r][c + 1] + "" + QT[r + 1][c] + QT[r + 1][c + 1] + ")";
		}
		
		return "("+ quad(r, c, size / 2) + "" + quad(r, c + size/2, size / 2) + "" + quad(r + size/2, c, size / 2) + "" + quad(r + size/2, c + size/2, size / 2) + ")";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		QT = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				QT[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(quad(0, 0, N));
	}

}

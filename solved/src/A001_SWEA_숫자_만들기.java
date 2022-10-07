import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 순열
public class A001_SWEA_숫자_만들기 {

	static int N, totalCnt;
	static int[] operations;
	static boolean[] isSelected;
	static int[] oper, number;
	static int max, min;
	
	private static void perm(int cnt) {
		if (cnt == N - 1) {
			int cal = number[0];
			for (int i = 1; i < N; i++) {
				switch(operations[i - 1]) {
				case 0:
					cal += number[i];
					break;
				case 1:
					cal -= number[i];
					break;
				case 2:
					cal *= number[i];
					break;
				case 3:
					if (cal != 0) cal /= number[i];
					break;
				}
			}

			if (max < cal) max = cal;
			if (min > cal) min = cal;
			return;
		}
		
		// 가능한 모든 수 시도 
		for (int  i = 0; i < oper.length; i++) {
			if(oper[i] != 0) { 
				operations[cnt] = i;
				oper[i]--;
				perm(cnt + 1);
				oper[i]++; // 현재 경우 선택 안 함 
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			oper = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			totalCnt = 0;
			operations = new int[N - 1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			perm(0);
			
			sb.append("#" + t + " " + (max - min) + "\n");
		}
		
		System.out.println(sb);
	}

}

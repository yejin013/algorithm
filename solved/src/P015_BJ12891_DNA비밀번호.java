import java.io.BufferedReader;
import java.io.InputStreamReader;

// 기초 문제
public class P015_BJ12891_DNA비밀번호 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위함 
		
		String[] SP = in.readLine().split(" ");
		int S = Integer.parseInt(SP[0]);
		int P = Integer.parseInt(SP[1]);
		String str = in.readLine();
		
		String[] ACGT = in.readLine().split(" ");
		
		int A = Integer.parseInt(ACGT[0]);
		int C = Integer.parseInt(ACGT[1]);
		int G = Integer.parseInt(ACGT[2]);
		int T = Integer.parseInt(ACGT[3]);
		
		int[] save = new int[128];
		save['A'] = 0;
		save['C'] = 0;
		save['G'] = 0;
		save['T'] = 0;
		
		int result = 0;
		for (int i = 0; i <= S - P; i++) {
			save['A'] = 0;
			save['C'] = 0;
			save['G'] = 0;
			save['T'] = 0;
			for (int j = i; j <= P; j++) { // 구간별 체크 
				save[str.charAt(j)]++; 
			}

			if (save['A'] >= A && save['C'] >= C && save['G'] >= G && save['T'] >= T)  { // 개수 비교
				result++;
			}
		}
		
		System.out.println(result);
	}

}

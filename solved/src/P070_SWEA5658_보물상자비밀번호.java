import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

// 슬라이딩 윈도우 (처음 두 개를 맨 뒤로 붙여서 생각하기) + treeset
public class P070_SWEA5658_보물상자비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			
			String[] arr = br.readLine().split(""); // 16진수 배열
			TreeSet<String> treeSet = new TreeSet<>(Collections.reverseOrder());
			
			for (int i = 0; i < N / 4; i++) { // 4등분하기 
				
			}
			
			sb.append("#" + t + " ");
		}
		
		System.out.println(sb);
	}

}

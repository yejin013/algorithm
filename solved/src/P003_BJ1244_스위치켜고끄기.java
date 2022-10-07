import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기초 문제
public class P003_BJ1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		boolean[] arr = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) == 1;
		}
		
		int p = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int middle = Integer.parseInt(st.nextToken());
			
			switch(gender) {
			case 1:
				for (int j = middle; j < arr.length; j += middle) {
					arr[j] = !arr[j];
				}
				break;
			case 2:
				arr[middle] = !arr[middle];
				for (int l = middle - 1, r = middle + 1; l > 0 && r <= n; l--, r++) {
					if (arr[l] == arr[r]) {
						arr[r] = !arr[r];
						arr[l] = !arr[l];
					} else {
						break;
					}
				}
				break;
			}

		}

		for (int i = 1; i < n + 1; i++) {
			System.out.print((arr[i] ? 1 : 0) + " ");
			
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

}

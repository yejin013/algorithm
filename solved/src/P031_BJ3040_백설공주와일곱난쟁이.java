

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P031_BJ3040_백설공주와일곱난쟁이 {
	
	static List<Integer> function(int sum, List<Integer> arr) {
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr.get(i) - arr.get(j) == 100) { // 전체 값에서 100이 되는 i, j index 찾기 
					// 큰 값을 먼저 list에서 빼고, 작은 값 빼기 
					arr.remove(j);
					arr.remove(i);
					return arr;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		List<Integer> arr = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 9; i++) { // 입력 
			arr.add(sc.nextInt());
			sum += arr.get(i); // 9명을 다 더하기 
		}
		
		arr = function(sum, arr); // 두 명 빼보기 
		
		for(int i = 0; i < 7; i++) {
			sb.append(arr.get(i) + "\n");
		}
		System.out.println(sb);
	}

}

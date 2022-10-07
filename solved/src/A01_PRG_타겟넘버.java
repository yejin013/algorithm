

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 아직 푸는 중 - dfs
public class A01_PRG_타겟넘버 {

	static int[] numbers;
	static int target;
	static int cnt = -1;
	static int answer;
	
    public static int solution(int[] numbers, int target) {      
        A01_PRG_타겟넘버.numbers = numbers;
        A01_PRG_타겟넘버.target = target;
        dfs(-1);
        
        return answer;
    }
    
    public static void dfs(int value) {
    	if (cnt == numbers.length || value == target) {
    		return;
    	}
    	
    	dfs(numbers[cnt + 1] + answer);
        dfs(numbers[cnt + 1] - answer);
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numberS = br.readLine().split(" ");
		
		int[] numbers = new int[numberS.length];
		for (int i = 0; i < numberS.length; i++) {
			numbers[i] = Integer.parseInt(numberS[i]);
		}
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(solution(numbers, target));
	}

}

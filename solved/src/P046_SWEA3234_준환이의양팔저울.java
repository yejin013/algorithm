

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P046_SWEA3234_준환이의양팔저울 {

	static int[] weight;
	static boolean[] permIsSelected, subsetIsSelected;
	static int N;
	static int total;
	static int[] numbers;
	static int count;
	
	static void perm(int cnt) {
        
	    if (cnt == N) {
	    	subset(0, 0, 0);
	        return;
	    }
	    
	    // 순열 
	    for (int i = 0; i < weight.length; i++) {
	        // 중복체크 필요함
	        if(permIsSelected[i]) continue;
	        // 해당 수 선택
	        numbers[cnt] = weight[i];
	        permIsSelected[i] = true;
	        // 다음 순열 찾기 
	        perm(cnt+1);
	        permIsSelected[i] = false;
	    }
	    
	}
	
	static void subset(int index, int leftSum, int rightSum) {
		
		// 오른쪽을 왼쪽이랑 비교 
		// 오른쪽은 왼쪽보다 크지 않다.
		if (rightSum > total / 2) return;
		
		if (index == N) {
			count++;
			return;
		}
		
		// 원소 선택 
		subsetIsSelected[index] = true;
		if (rightSum + numbers[index] <= leftSum) subset(index + 1, leftSum, rightSum + numbers[index]);
		subsetIsSelected[index] = false;
		subset(index + 1, leftSum + numbers[index], rightSum);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			String[] line = br.readLine().split(" ");
			weight = new int[N];
			permIsSelected = new boolean[N];
			subsetIsSelected = new boolean[N];
			numbers = new int[N];
			
			count = 0;
			
			for (int i = 0; i < line.length; i++) {
				int value = Integer.parseInt(line[i]);
				weight[i] = value;
				total += value;
			}
			
			perm(0);
			System.out.println("#" + t+ " " + count);
		}
	}

}

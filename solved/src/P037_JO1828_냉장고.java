

import java.util.*;

public class P037_JO1828_냉장고 {

	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    
	    ArrayList<int[]> arr = new ArrayList<>(); // 최저, 최고 온도 보관
	    
	    for(int i = 0; i < N; i++) {
	        int x = sc.nextInt();
	        int y = sc.nextInt();
	        arr.add(new int[] {x,y});
	    }
	    arr.sort((o1,o2)-> o1[1]-o2[1]); // 최고보관온도 기준 정렬
	    
	    int Y = arr.get(0)[1]; // 첫번째 것의 Y값
	    
	    int answer = 1;
	    
	    for(int i = 1; i < N; i++) {
	        int newX = arr.get(i)[0];
	        if(newX > Y) {
	            Y = arr.get(i)[1]; // 최고값 갱신 
	            answer++;
	        }
	    }
	    System.out.println(answer);
	    
	}
}
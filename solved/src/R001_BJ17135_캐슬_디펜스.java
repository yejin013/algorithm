import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

// 궁수 - 순열
public class R001_BJ17135_캐슬_디펜스 {

	static int[][] map;
	static int N, M, D, max, total;
	static Stack<Integer> archers;

	static class Point implements Comparable<Point>{
		int x, y, d;

		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Point o) {
			if (d != o.d) return d - o.d;
			else return x - o.x;
		}
		
	}
	static void archerPo(int cnt, int start) {
		if (cnt == 3) {
			// 쏘기 
			shoot();
			return;
		}
		
		for (int i = start; i < M; i++) {
			// 조합
			archers.add(i);
			archerPo(cnt + 1, i + 1);
			archers.pop();
		}
	}

	static void shoot() {
		// 새 배열 
		int cnt = 0;
		
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		// 거리 제일 짧은 거 삭제 
		while(!check(newMap)) {
			List<Point> list = new ArrayList<>();
			
			for (int s = 0; s < archers.size(); s++) {
				PriorityQueue<Point> pq = new PriorityQueue<>();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (newMap[i][j] == 0) continue;
						int distance = Math.abs(-1 - (N - 1 - i)) + Math.abs(archers.get(s) - j);
						if (distance > D) continue;
						pq.add(new Point(j, i, distance));
					}
				}
				if (!pq.isEmpty()) {
					Point p = pq.poll();
					list.add(p);
				}
			}
			
			// 즉이기
			for (int i = 0; i < list.size(); i++) {
				Point p = list.get(i);
				if (newMap[p.y][p.x] == 1) {
					newMap[p.y][p.x] = 0;
					cnt++;
				}
			}
			
			for (int i = N - 1; i >= 1; i--) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = newMap[i - 1][j];
					newMap[i - 1][j] = 0;
				}
			}
		}
		
		if (max < cnt) max = cnt;
	}
	
	static boolean check(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]); // 행의 수
		M = Integer.parseInt(input[1]); // 열의 수
		D = Integer.parseInt(input[2]); // 궁수의 공격 거리 제한 
		
		archers = new Stack<>();
		map = new int[N + 1][M]; // 마지막 칸에 궁수
		for (int n = 0; n < N; n++) {
			input = br.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(input[m]);
				if (map[n][m] == 1) total++;
			}
		}
		
		// 궁수 위치 순열 
		archerPo(0, 0);
		System.out.println(max);
	}

}

/*
 * 
 * 비교하기
 * 현재는 궁수 방향으로 모든 값이 내려옴.
 * 과거엔 궁수가 위로 올라감.
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int max;
	static int[][] game;
	static int[] numbers;
	static ArrayList<Integer> archers;
	static int[][] copy;
	
	static int N, M, D;
	
	static void attack() {
	       for(int i = 0 ; i < N ; i++)
	    	   for(int j = 0; j < M; j++)
	    		   copy[i] = Arrays.copyOf(game[i], M);

	        int killOfTurn = 0;
	        int turn = 0;
	        Queue<int[]> q = new ArrayDeque<>();

	        while (turn < N) {
	            for (int k = 0; k < 3; k++) {
	                int x = N - turn;
	                int y = archers.get(k);

	                int min = Integer.MAX_VALUE;
	                int minX = -1;
	                int minY = -1;

	                for (int i = N - turn - 1; i >= 0; i--) {
	                    for (int j = 0; j < M; j++) {
	                        if (copy[i][j] == 1) {
	                            int dist = Math.abs(i - x) + Math.abs(j - y);

	                            if(dist > D) continue;
	                            if (dist < min) {
	                                min = dist;
	                                minX = i;
	                                minY = j;
	                            } else if (dist == min) {
	                                if (j < minY) {
	                                    minX = i;
	                                    minY = j;
	                                }
	                            }
	                        }
	                    }
	                }

	                if(minX == -1 || minY == -1) continue;

	                q.offer(new int[]{minX, minY});
	            }

	            while (!q.isEmpty()) {
	                int x = q.peek()[0];
	                int y = q.poll()[1];

	                if(copy[x][y] == 1){
	                    copy[x][y] = 0;
	                    killOfTurn += 1;
	                }
	            }
	            turn += 1;
	        }
		max = max > killOfTurn ? max: killOfTurn;
	}
	
	// cnt + 1번째 해당하는 조합에 포함될 수를 뽑기 
	private static void find(int cnt, int start) { // cnt: 직전까지 뽑은 조합에 포함된 수의 개수, start: 시도할 수의 시작 위치 (반복을 돌 때 시작 위치만 정함)
		
		if(cnt == 3) {
			// 적 죽이기
			attack();
			return;
		}
		
		// 가능한 모든 수에 대해 시도 (input 배열의 가능한 수 시도) 
		// start 부터 처리시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지 
		for (int i = start; i < M; i++) { // 선택지
			archers.add(i);
			// 다음 수 뽑으러 가기 
			find(cnt + 1, i + 1);
			archers.remove(archers.size() - 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);
		
		game = new int[N][M];
		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				game[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		copy = new int[N][M];
		archers = new ArrayList<>();
		numbers = new int[3];
		
		// 궁수 위치 조합 
		find(0, 0);
		
		System.out.println(max);
	}

}
 */

package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
 * 1. 2차원 평면 정보 입력 전체를 받는다.
 * 2. 상어가 마법을 쓰면 0으로 만든다.
 * 3. 달팽이 모양대로 값을 가져와 일차원으로 만든다. 0인 부분은 뺀다
 * 4. 이후 순회하면서 같은수가 반복되는것을 세고
 * 5. 같은수가 4회 이상 반복되는 경우 해당값을 모두 0으로 만든다.(구슬 별 개수 카운트)
 * 6. 더이상 터지는 구슬이 없는 채로 모든 구슬을 순회하면
 * 7. 구슬 카운트 후 새 인덱스를 만들고 값을 카운트해서 업데이트
 * 8. 달팽이 모양대로 맵에 업데이트 한다.
 * 9. 2를 수행한다.
*/
public class BJ21611_simulation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N;
	static int M;
	static int[][] map;
	static int middle;
	static int[] blizzard = new int[2]; // [0]: d / [1]: s
	
	static int[] num;
	

	static ArrayList<Integer> marbles = new ArrayList<Integer>();
	
	static int cntm = 0; // 
	static int sizem = 1; // 
	static int cornerm = 0; // 코너 두번을 거치면 사이즈가 늘어남
	static int dirm = 0; // 왼아오위 방향전환
	static int nrm = middle; // 출발점
	static int ncm = middle; // 출발점
	static int indexm = 0;
	
	static int[] snaily = { 0, 1, 0,-1};
	static int[] snailx = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		middle = N/2;
		map = new int[N][N];
		
		//2차원 평면 정보 입력 전체를 받는다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		num = new int[4]; 
		//블리자드 정보를 받는다.
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			blizzard[0] =  Integer.parseInt(st.nextToken());
			blizzard[1] =  Integer.parseInt(st.nextToken());
			
			//상어가 마법을 쓰면 0으로 만든다.
			blizzard(blizzard[0],blizzard[1]);
			//달팽이 모양대로 값을 가져와 일차원으로 만든다. 0인 부분은 뺀다
			marbles.clear();
			toList();
			//이후 순회하면서 같은수가 반복되는것을 세고
			explosion();
			//새 인덱스 만들어서 맵에 업데이트
			update();
		}
		int ans = num[1]+2*num[2]+3*num[3];
		
		bw.write(ans+"");		
		
		br.close();
		bw.close();
	}
	private static void update() {
		int now = 0;
		int next = 0;
		int cnt = 1;
		int index = 0;
		map = new int[N][N];
		
		cntm = 0; // 
		sizem = 1; // 
		cornerm = 0; // 코너 두번을 거치면 사이즈가 늘어남
		dirm = 0; // 왼아오위 방향전환
		nrm = middle; // 출발점
		ncm = middle; // 출발점
		indexm = 0;
		
		for (int i = 0; i < marbles.size(); i++) {
			
			now = marbles.get(i);
			if (index>N*N) {
				break;
			}
			if(i != marbles.size()-1) {
				next = marbles.get(i+1);
			}else {
				next = -1;
			}
			if (now == next) {
				cnt++;
			}else {								
				toMap(cnt);
				toMap(now);
				cnt = 1;
							
			}
		}
	}
	private static void toMap(int cnt) {
		cntm++; 
		nrm +=snaily[dirm]; //다음 칸
		ncm +=snailx[dirm]; //다음 칸

		if (nrm <= 0 && ncm <= -1) {
			return; // 마지막 칸에 오면 종료
		}
		map[nrm][ncm] = cnt;
		
		if (cntm == sizem) {
			cornerm++;
			dirm = (dirm+1)%4; // 방향은 반복되는것
			cntm = 0;
		}
		if (cornerm == 2) {
			cornerm = 0;
			sizem++;
		}
	}
	private static void explosion() {
		boolean explod = true;
		while(explod) {
			int now = 0;
			int next = 0;
			int cnt = 1;
			explod = false;
			for (int i = 0; i < marbles.size(); i++) {
				now = marbles.get(i);
				if(i+1 < marbles.size())next = marbles.get(i+1);
				else next = -1;
				if (now == -1) {
					break;
				}
				if(now == next) {
					cnt++;
				}else {
					if(cnt >= 4) {
						num[now] += cnt;
						for (int j = 0; j < cnt; j++) {
							marbles.remove(i--);
						}
						explod = true;
					}
					cnt = 1;
					
				}
			}
		}
	}
	private static void toList() {
		int cnt = 0; // 
		int size = 1; // 
		int corner = 0; // 코너 두번을 거치면 사이즈가 늘어남
		int dir = 0; // 왼아오위 방향전환
		int nr = middle; // 출발점
		int nc = middle; // 출발점
		
		while (true) {
			cnt++; 
			nr +=snaily[dir]; //다음 칸
			nc +=snailx[dir]; //다음 칸
			if (nr == 0 && nc == -1) {
				break; // 마지막 칸에 오면 종료
			}
			if (map[nr][nc] != 0) {
				//블리자드 쏜구혁이나 비어있는곳 아니면 인덱스 추가
				marbles.add(map[nr][nc]); 
			}
			//현재 턴 개수 카운트, 코너 만나는거 추가
			if (cnt == size) {
				corner++;
				dir = (dir+1)%4; // 방향은 반복되는것
				cnt = 0;
			}
			if (corner == 2) {
				corner = 0;
				size++;
			}
		}
	}
	private static void blizzard(int d, int s) {
		int [] diry = {0,-1, 1, 0, 0};
		int [] dirx = {0, 0, 0,-1, 1};
		
		for (int i = 1; i <= s; i++) {
			int nexty = middle+diry[d]*i;
			int nextx = middle+dirx[d]*i;
			if (i<=N/2) {
				map[nexty][nextx] = 0;
			}else {
				break;
			}
				
		}
	}
}

package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
 * 1. 2���� ��� ���� �Է� ��ü�� �޴´�.
 * 2. �� ������ ���� 0���� �����.
 * 3. ������ ����� ���� ������ ���������� �����. 0�� �κ��� ����
 * 4. ���� ��ȸ�ϸ鼭 �������� �ݺ��Ǵ°��� ����
 * 5. �������� 4ȸ �̻� �ݺ��Ǵ� ��� �ش簪�� ��� 0���� �����.(���� �� ���� ī��Ʈ)
 * 6. ���̻� ������ ������ ���� ä�� ��� ������ ��ȸ�ϸ�
 * 7. ���� ī��Ʈ �� �� �ε����� ����� ���� ī��Ʈ�ؼ� ������Ʈ
 * 8. ������ ����� �ʿ� ������Ʈ �Ѵ�.
 * 9. 2�� �����Ѵ�.
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
	static int cornerm = 0; // �ڳ� �ι��� ��ġ�� ����� �þ
	static int dirm = 0; // �޾ƿ��� ������ȯ
	static int nrm = middle; // �����
	static int ncm = middle; // �����
	static int indexm = 0;
	
	static int[] snaily = { 0, 1, 0,-1};
	static int[] snailx = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		middle = N/2;
		map = new int[N][N];
		
		//2���� ��� ���� �Է� ��ü�� �޴´�.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		num = new int[4]; 
		//���ڵ� ������ �޴´�.
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			blizzard[0] =  Integer.parseInt(st.nextToken());
			blizzard[1] =  Integer.parseInt(st.nextToken());
			
			//�� ������ ���� 0���� �����.
			blizzard(blizzard[0],blizzard[1]);
			//������ ����� ���� ������ ���������� �����. 0�� �κ��� ����
			marbles.clear();
			toList();
			//���� ��ȸ�ϸ鼭 �������� �ݺ��Ǵ°��� ����
			explosion();
			//�� �ε��� ���� �ʿ� ������Ʈ
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
		cornerm = 0; // �ڳ� �ι��� ��ġ�� ����� �þ
		dirm = 0; // �޾ƿ��� ������ȯ
		nrm = middle; // �����
		ncm = middle; // �����
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
		nrm +=snaily[dirm]; //���� ĭ
		ncm +=snailx[dirm]; //���� ĭ

		if (nrm <= 0 && ncm <= -1) {
			return; // ������ ĭ�� ���� ����
		}
		map[nrm][ncm] = cnt;
		
		if (cntm == sizem) {
			cornerm++;
			dirm = (dirm+1)%4; // ������ �ݺ��Ǵ°�
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
		int corner = 0; // �ڳ� �ι��� ��ġ�� ����� �þ
		int dir = 0; // �޾ƿ��� ������ȯ
		int nr = middle; // �����
		int nc = middle; // �����
		
		while (true) {
			cnt++; 
			nr +=snaily[dir]; //���� ĭ
			nc +=snailx[dir]; //���� ĭ
			if (nr == 0 && nc == -1) {
				break; // ������ ĭ�� ���� ����
			}
			if (map[nr][nc] != 0) {
				//���ڵ� �����̳� ����ִ°� �ƴϸ� �ε��� �߰�
				marbles.add(map[nr][nc]); 
			}
			//���� �� ���� ī��Ʈ, �ڳ� �����°� �߰�
			if (cnt == size) {
				corner++;
				dir = (dir+1)%4; // ������ �ݺ��Ǵ°�
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

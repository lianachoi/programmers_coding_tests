package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * 순열 nPm을 구하는 문제
 * 백트래킹을 이용한다.
 */
public class BJ15649_NandM_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		
		//시작점을 준다
		backTracking(0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void backTracking(int i) {
		//현재 깊이가 순열 길이와 같으면 StringBuilder에 append하고 리턴
		if (i == M) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//전체 수 만큼 (1~N) 확인한다.
		for (int j = 0; j < N; j++) {
			//이전 회차에서 방문한 곳이면 PASS
			if (visit[j] == false) {
				visit[j] = true;
				//현재 깊이에 방문한 수를 저장
				arr[i] = j+1;
				//다음 깊이 탐색한다.
				backTracking(i+1);
				visit[j] = false;
			}
		}
		
	}

}

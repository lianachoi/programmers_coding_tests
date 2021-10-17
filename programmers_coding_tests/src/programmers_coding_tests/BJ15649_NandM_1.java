package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
 * 
 * ���� nPm�� ���ϴ� ����
 * ��Ʈ��ŷ�� �̿��Ѵ�.
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
		
		//�������� �ش�
		backTracking(0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void backTracking(int i) {
		//���� ���̰� ���� ���̿� ������ StringBuilder�� append�ϰ� ����
		if (i == M) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//��ü �� ��ŭ (1~N) Ȯ���Ѵ�.
		for (int j = 0; j < N; j++) {
			//���� ȸ������ �湮�� ���̸� PASS
			if (visit[j] == false) {
				visit[j] = true;
				//���� ���̿� �湮�� ���� ����
				arr[i] = j+1;
				//���� ���� Ž���Ѵ�.
				backTracking(i+1);
				visit[j] = false;
			}
		}
		
	}

}

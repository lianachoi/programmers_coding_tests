package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/* N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. N���� �ڿ����� ��� �ٸ� ���̴�.
 * N���� �ڿ��� �߿��� M���� �� ����
 * �� ������ ���������̾�� �Ѵ�.
 * 
 * ���ڰ� �־����� ����
*/
public class BJ15655_NandM_6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[] nums;
	static int[] arr;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);

		arr = new int[M];
		
		backTracking(0, 0);
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}

	private static void backTracking(int at, int depth) {
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = at; i < N; i++) {
				arr[depth] = nums[i];
				backTracking(i+1, depth+1);	
			
		}
	}

}

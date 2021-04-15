package programmers_coding_tests;

import java.util.Arrays;

/*
 * �ڵ��׽�Ʈ ����> ����> K��°��
 */
public class K_num {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //commands�� �� ��ŭ �ݺ�
        for (int i = 0; i < commands.length; i++) {
        	//commands[i] ó��~�� ������ ���̸� ���� �迭 ���� �����.
        	int[] newArray = new int[commands[i][1]-commands[i][0]+1];
        	//ù ��° ���ڸ� �־�д�.
        	newArray[0] = array[commands[i][0]-1];
        	//���� �� ��� ���ڰ� �� �� ���� �ݺ�
			for (int j = 1 ; j < newArray.length ; j++) {
				//���ο� �迭�� array�迭�� ���� �ִ´�.
				newArray[j] = array[commands[i][0]-1+j];
				//k�� j �̸��� ������ ���γ��� ���� ���� �ʿ䰡 ���� ������ �� ���� ���� �ִ����� Ȯ���ϸ� �Ǳ� ����
				for (int k = 0; k < j; k++) {
					//������ �� ���� ���� �ִٸ� �� ������ ��ġ�� ��ȯ�Ѵ�.
					if (newArray[k]>newArray[j]) {
						int temp = newArray[j];
						//�� ���� ���� ȸ���� �ٽ� �� ����� �ȴ�.
						//���������̶� �ؾ��ϳ�?? ���������̶� ���??..
						newArray[j] = newArray[k]; 
						newArray[k] = temp;
					}
				}
			}
			answer[i] = newArray[commands[i][2]-1];
		}
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		solution(array, commands);

	}

}

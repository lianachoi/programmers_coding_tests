package programmers_coding_tests;

import java.util.Arrays;

/*
 * 코딩테스트 연습> 정렬> K번째수
 */
public class K_num {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //commands의 수 만큼 반복
        for (int i = 0; i < commands.length; i++) {
        	//commands[i] 처음~끝 까지의 길이를 구해 배열 새로 만든다.
        	int[] newArray = new int[commands[i][1]-commands[i][0]+1];
        	//첫 번째 숫자를 넣어둔다.
        	newArray[0] = array[commands[i][0]-1];
        	//범위 내 모든 숫자가 들어갈 때 까지 반복
			for (int j = 1 ; j < newArray.length ; j++) {
				//새로운 배열에 array배열의 값을 넣는다.
				newArray[j] = array[commands[i][0]-1+j];
				//k가 j 미만인 이유는 새로넣은 값은 비교할 필요가 없고 이전에 더 작은 수가 있는지만 확인하면 되기 때문
				for (int k = 0; k < j; k++) {
					//이전에 더 작은 수가 있다면 맨 마지막 위치와 교환한다.
					if (newArray[k]>newArray[j]) {
						int temp = newArray[j];
						//이 값은 다음 회차에 다시 비교 대상이 된다.
						//무슨정렬이라 해야하나?? 삽입정렬이랑 비슷??..
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

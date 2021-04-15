package programmers_coding_tests;

import java.util.HashMap;
import java.util.Iterator;

public class Lotto {
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[] {0,0};
        
        HashMap<Integer, Integer> lh = new HashMap<Integer,Integer>();
        int rank = 7;
        
        for(int i = 0 ; i<6 ; i++) {
        	lh.put(lottos[i], lh.getOrDefault(lottos[i], 0)+1);
        	lh.put(win_nums[i], lh.getOrDefault(win_nums[i], 0)+1);
        }
        Iterator<Integer> keys = lh.keySet().iterator();
        
        for (Integer key : lh.keySet() ){
        	if(lh.get(key)>1 && key != 0) {
        		rank--;
        	}
		}		
        answer[0] = rank;
        if(lh.getOrDefault(0,0)>=1) {
        	answer[0] = answer[0] - lh.get(0);
        }else if(answer[0]>6){
        	answer[0] = 6;
        }
       
        rank = rank>5? 6:rank;	
        answer[1] = rank;	
        
        System.out.println("["+answer[0] +","+answer[1]+"]" );
        return answer;
    }
	public static void main(String[] args) {
		int[] lottos = {11,12,13,14,15,16 };
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		solution(lottos, win_nums);

	}

}

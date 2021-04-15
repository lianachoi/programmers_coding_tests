package programmers_coding_tests;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSliderUI;

public class Scoville {
	
	static ArrayList<Integer> foods;
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        foods = new ArrayList<>();
        foods.add(-1);
        
        for (int i = 0; i < scoville.length; i++) {
			insert(scoville[i]);
		}
        int lowest1;
        int lowest2;
        while(foods.get(1) < K) { 
        	if (foods.size() == 2) {
				answer = -1;
				break;
			}
        	lowest1 = delete();
        	lowest2 = delete();
        	insert(lowest1+lowest2*2);
        	answer++;
        }
        //[1000000001, 12, 9, 10, 1, 3, 2]
        //foods.remove(foods.size()-1);
        //[1000000001, 12, 9, 10, 1, 3]
        System.out.println(foods.toString());
        System.out.println(answer);
        return answer;
    }
	
	public static void insert(int food) {
		foods.add(food);
		int p = foods.size() - 1;
		while (p>1 && foods.get(p/2)>foods.get(p)) {
			int higher_scoville_food = foods.get(p/2);
			foods.set(p/2, foods.get(p));
			foods.set(p, higher_scoville_food);
			
			p = p/2;
		}
	}
	
	public static int delete() {
		int size = foods.size();
		if(size-1 < 1) {
			return 0;
		}
		int deleted_food = foods.get(1);
		foods.set(1, foods.get(size-1));
		foods.remove(size-1);
		
		int p = 1;
		while (p*2 < size-1) {
			int lower_scoville_food = foods.get(p*2);
			int lower_scoville_food_p = p*2;
			if (((p*2 + 1) < size-1) && lower_scoville_food > foods.get(p*2+1)) {
				lower_scoville_food = foods.get(p*2+1);
				lower_scoville_food_p = p*2+1;
			}
			if (foods.get(p)<lower_scoville_food) {
				break;
			}
			int highest_scoville_food = foods.get(p);
			foods.set(p, foods.get(lower_scoville_food_p));
			foods.set(lower_scoville_food_p, highest_scoville_food);
			p = lower_scoville_food_p;
		}
		return deleted_food;
	}
	
	public static void main(String[] args) {
		int[] scoville = {0,0};
		int K = 7;
		solution(scoville, K);

	}

}

package programmers_coding_tests;

import java.util.Arrays;

public class Distancing {
	public static int Distancing(int[][] place) {

        
        int[] check1_y = {-2, 0, 2, 0};
        int[] check1_x = { 0, 2, 0,-2};
        
        int[] check2_y = {-1, 1, 1,-1};
        int[] check2_x = { 1, 1,-1,-1};
        
        int[] check3_y = {-1, 0, 1, 0,-1};
        int[] check3_x = { 0, 1, 0,-1, 0};
        
		for (int y = 2; y < place.length-2; y++) {
			for (int x = 2; x < place.length-2; x++) {
				if (place[y][x] == 1) {
					for (int i = 0; i < check1_y.length; i++) {
						if (place[y+check3_y[i]][x+check3_x[i]] == 1) {
							return 0;
						}
						if (place[y+check1_y[i]][x+check1_x[i]]
								+place[y+check3_y[i]][x+check3_x[i]] == 1) {
							return 0;
						}
						if (place[y+check2_y[i]][x+check2_x[i]] == 1
								&& place[y+check2_y[i]][x+check2_x[i]]
							+place[y+check3_y[i]][x+check3_x[i]]
									+place[y+check3_y[i+1]][x+check3_x[i+1]] > -1) {
							return 0;
						}
					}
				}
			}
		}
		return 1;
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int p = 0; p < places.length; p++) {
			int[][] place = new int[9][9];
			for (int y = 2; y < place.length-2; y++) {
				for (int x = 2; x < place.length-2; x++) {
					char now = places[p][y-2].charAt(x-2);
					if ( now == 'P') {
						place[y][x] = 1;
					}else if ( now == 'X' ) {
						place[y][x] = -1;
					}
				}
			}
			answer[p] = Distancing(place);
		}
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solution(places);		

	}

}

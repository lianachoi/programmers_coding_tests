package programmers_coding_tests;
 
import java.util.LinkedList;
import java.util.Queue;


public class Bridge_truck {
	
	public static class Truck{
		int truck_weight;
		int truck_move;
		
		public Truck(int truck_weight) {
			this.truck_weight = truck_weight;
			this.truck_move = 0;
		}
		
		public void moving() {
			this.truck_move++;
		}
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        Truck[] trucks = new Truck[truck_weights.length];
        Queue<Truck> bridge = new LinkedList<Truck>();
        int total_trucks_weight = 0;
        
        for (int i = 0; i < truck_weights.length; i++) {
        	trucks[i] = new Truck(truck_weights[i]);
		}
        trucks[0].moving();
        bridge.offer(trucks[0]);
        total_trucks_weight = trucks[0].truck_weight;
        int trucknum = 1;
        
        while (!bridge.isEmpty()) {
			while (!bridge.isEmpty() && bridge.peek().truck_move >= bridge_length) {
				total_trucks_weight -= bridge.poll().truck_weight;
			}
			if (trucknum < truck_weights.length) {
				if(total_trucks_weight + trucks[trucknum].truck_weight <= weight) {
	        		bridge.offer(trucks[trucknum]);
					total_trucks_weight +=  trucks[trucknum].truck_weight;
					trucknum++;        		
	        	}				
			}
        	
        	bridge.forEach(truck-> truck.truck_move++);
        	answer++;			
		}
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

}

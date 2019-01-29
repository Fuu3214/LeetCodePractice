import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[len-k+1];
        Deque<Integer> deq = new LinkedList<>();
        for(int i =0; i < k; i++) {
        	addDeque(deq, nums[end]);
        	end++;
        }
        res[start] = deq.getFirst();
        while(end < len){
        	
    		if(deq.getFirst() == nums[start]) {
    			deq.pollFirst();
    		}
    		start++;
        	addDeque(deq, nums[end]);
        	end++;
    		res[start] = deq.getFirst();
    		
        }
        
        
        return res;
    }
    
    public void addDeque(Deque<Integer> deq, int num) {
		while(!deq.isEmpty() && deq.getLast() < num) {
			deq.pollLast();
		}
		deq.add(num);
    }
    

}

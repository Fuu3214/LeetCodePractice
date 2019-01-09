
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        int size = nums.length;
        if(size <=1 ) return size;
        
        HashSet<Integer> s = new HashSet<>();
        
        for(int i = 0; i < size; i++){
            s.add(nums[i]);
        }
        
        int max = 0;
        
        
        for(int i = 0; i < size; i++) {
        	if(s.contains(nums[i])) {
        		int cur = nums[i];
        		s.remove(cur);
        		int len = 1;
        		while(s.contains(cur - 1)){
                    len++;
                    cur--;
                    s.remove(cur);
                }
                
                cur = nums[i];
                while(s.contains(cur + 1)){
                    len++;
                    cur++;
                    s.remove(cur);
                }
                
                max = Math.max(len, max);
        	}
        }
        return max;
    }
}

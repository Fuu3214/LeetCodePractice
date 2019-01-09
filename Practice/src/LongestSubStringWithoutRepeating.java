
import java.util.HashMap;

public class LongestSubStringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if(size <= 0)   return size;
        
        HashMap<Character, Integer> visited = new HashMap<>();
        visited.put(s.charAt(0), 0);
        int i = 0;
        int max = 1;
        int len = 1;
        for(int j = 1; j < size; j++){
            char cur = s.charAt(j);
            if(visited.containsKey(cur)){
                int index = visited.get(cur);
                len = j - index;
                for(int p = i; p <= index; p++){
                    visited.remove(s.charAt(p));
                }
                i = index + 1;
            }
            else{
                len++;
                visited.put(cur, j);
                max = Math.max(len, max);
            }
        }
        return max;
    }
}

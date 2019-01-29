import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n==0 || m<n) return "";
        
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int[] rec = new int[2];
        
        int[] freq = new int[256];
        for(int i=0; i<n; i++){
            freq[T[i]]++;
        }
        int cnt = n;
        
        while(end < m) {
        	freq[S[end]]--;
//        	System.out.println(S[end] + " " + freq[S[end]]);
        	if(freq[S[end]] >= 0) {
        		cnt--;
        	}
    		while(cnt == 0) {
    			freq[S[start]]++;
//    			System.out.println(s.substring(start, end+1));
    			if(freq[S[start]] > 0) { 
    				cnt++;
    				if(min > end-start+1) {
    					min = end-start+1;
    					rec[0] = start;
    					rec[1] = end+1;
    				}
				}
    			start++;
    		}
    		end++;
        }
        return s.substring(rec[0], rec[1]);
    }
}

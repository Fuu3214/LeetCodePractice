
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class topKfreq {

    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int sizeS = s.length();
        int pos = 1;
        int[] dp = new int[sizeS + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= sizeS; i++){
            int j = i-2;
            if(s.charAt(i-1) == '0' && (s.charAt(j) > '2' || s.charAt(j) == '0'))
                return 0;
            if(s.charAt(i-1) == '0' || s.charAt(j) > '2' || s.charAt(j) == '2' && s.charAt(i-1) > '6'|| s.charAt(i-1) != '0' && s.charAt(j-1) == 0)
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i-1] + 1;
        }
        return dp[sizeS];
    }
}

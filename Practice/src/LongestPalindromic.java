
public class LongestPalindromic {
    public String longestPalindrome(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        for(int i = 0; i < size-1; i++){
            dp[i][i] = 1;
            if(s.charAt(i) == s.charAt(i+1))
                dp[i][i+1] = 1;
        }
        dp[size-1][size-1] = 1;
        int start=0, end=0;
        for(int len = 3; len <= size; len++){
            Boolean flag = false;
            for(int i = 0; i <= size - len; i++){
            	System.out.println(i + " " + (len) + " " + s.charAt(i) + " " + s.charAt(i+len-1));
                if(s.charAt(i) == s.charAt(i+len-1)){
                    dp[i][i+len-1] = dp[i+1][i+len-2]; 
                    if(dp[i][i+len-1] == 1){
                        flag = true;
                        start = i;
                        end = i+len-1;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}

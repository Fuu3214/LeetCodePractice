
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int i=0; i<=n; i++){
            dp[0][i] = i;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int tmp = word1.charAt(i-1)==word2.charAt(j-1)? 0:1;
                dp[i][j] = Math.min(dp[i-1][j-1]+tmp, Math.min(dp[i-1][j], dp[i][j-1])+1);
            }
        }
  
        return dp[m][n];
    }
    
    public int minDistanceOpt(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        //We only use information from previous row.
        for(int i=0; i<=n; i++){
            prev[i] = i;
        }
        for(int i=1; i<=m; i++){
            cur[0] = i;
            for(int j=1; j<=n; j++){
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if(a == b) {
                    cur[j] = prev[j - 1];
                } else {
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(cur[j - 1], prev[j]));
                }
            }
            int[] tmp = cur;
            cur = prev;
            prev = tmp;
            //need to swap otherwise cur and prev will be the same array
        }
        return prev[n];
    }
}

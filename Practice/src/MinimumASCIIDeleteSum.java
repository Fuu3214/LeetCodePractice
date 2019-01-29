import java.util.Arrays;

public class MinimumASCIIDeleteSum {
	public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int[][] dp = new int[n+1][m+1];
        int sum = 0;
        for(int i=1; i<=m; i++){
            sum += a1[i-1];
            dp[0][i] = sum;
        }
        sum = 0;
        for(int i=1; i<=n; i++){
            sum += a2[i-1];
            dp[i][0] = sum;
        }
        System.out.println(Arrays.deepToString(dp));
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a2[i-1]==a1[j-1]){
                    dp[i][j] = dp[i-1][j-1];
//                    System.out.println(a1[i-1] + " " + a2[j-1]);
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j]+a2[i-1], dp[i][j-1]+a1[j-1]);
                }
            }
//            System.out.println(Arrays.deepToString(dp));
        }
        
        return dp[n][m];
        
    }
}

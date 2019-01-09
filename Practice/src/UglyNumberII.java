
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int t = 0;
        
        int i=0, j=0, k=0;
        
        while(t < n-1){
            int min = Math.min(Math.min(2*dp[i],3*dp[j]), 5*dp[k]);
            if(2*dp[i] == min) i++;
            if(3*dp[j] == min) j++;
            if(5*dp[k] == min) k++;
            dp[++t] = min;
//            System.out.println(min);
        }
        return dp[n-1];
    }
}

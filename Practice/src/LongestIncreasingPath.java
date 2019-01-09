
public class LongestIncreasingPath {
    int[][] actions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0 ) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, helper(matrix, i, j, dp));
            }
        }
        return max;
    }
    
    public int helper(int[][] matrix, int i, int j, int[][] dp){
        if(dp[i][j] != 0) 
            return dp[i][j];
        int max = 1;
        for(int[] action : actions){
            int nexti = action[0] + i;
            int nextj = action[1] + j;
            if(nexti < 0 || nextj < 0 || nexti >= matrix.length || nextj >= matrix[0].length || matrix[i][j] >= matrix[nexti][nextj])
                continue;
//            max = Math.max(max, helper(matrix, nexti, nextj, dp)) + 1; //not correct
            int len = helper(matrix,nexti,nextj,dp) + 1;
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }
}

import java.util.Arrays;

public class PalindromePartitioningII {
	public int minCut(String s) {
        int len = s.length();
        if(len == 0) return 0;
        boolean[][] pal = new boolean[len][len];
        int[] cnt = new int[len];

        int min;
        for(int i=0; i<len;i++){
            min = i;
            for(int j=0; j<=i; j++){
//                System.out.println((i<=j+1 || pal[j+1][i-1]));
                if(s.charAt(i) == s.charAt(j) && (i<=j+1 || pal[j+1][i-1])){
                    pal[j][i] = true;
                    min = j==0? 0:Math.min(min, cnt[j-1]+1);
                }
            }
            cnt[i] = min;
        }
        System.out.println(Arrays.deepToString(pal));
        return cnt[len-1];
    }
}

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[] row = new int[matrix[0].length];
        int max = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                row[j] = matrix[i][j]=='0'? 0:row[j] + matrix[i][j]-'0';
            }
            max = Math.max(max, largestRectangleArea3(row));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        return helper(height, 0, height.length-1);
    }

    public int helper(int[] height, int start, int end) {
        if(start == height.length || end == -1) return 0;
        boolean sorted = true;
        int min = start;
        for(int i=start+1; i<=end; i++) {
            if(height[i] < height[i-1]) sorted = false;
            if(height[min] > height[i]) min = i;

        }
//	    	System.out.println(min + " " + sorted);
        if(sorted) {
            int max = 0;
            for(int i=end; i>=start; i--) {
                max = Math.max(max, height[i]*(end+1-i));
            }
//	    		System.out.println(start + " " + end + " " + max);
            return max;
        }
        return Math.max(Math.max(helper(height, start, min-1), helper(height, min+1,end)), height[min]*(end+1-start));
    }
    
    public int largestRectangleArea2(int[] height) {
	        int len = height.length;
	        Stack<Integer> s = new Stack<Integer>();
	        int maxArea = 0;
	        for(int i = 0; i <= len; i++){
	            int h = (i == len ? 0 : height[i]);
	            if(s.isEmpty() || h >= height[s.peek()]){
	                s.push(i);
	            }else{
	                int tp = s.pop();
	                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
	                i--;
	            }
	        }
	        return maxArea;
	    }
    
    public int largestRectangleArea3(int[] height) {
        int len = height.length;
        int[] s = new int[len+1];
        int top = 0;
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            while(top != 0&&height[s[top-1]] > h){ 
                int tp = s[top-1];
                top--;
                maxArea = Math.max(maxArea, height[tp] * (top==0 ? i : i - 1 - s[top-1]));
            }
            s[top++] = i;       
        }
        return maxArea;
    }
}

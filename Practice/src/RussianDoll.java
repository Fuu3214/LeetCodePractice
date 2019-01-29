import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0 || envelopes[0].length == 0) return 0;
        int[] arr = new int[envelopes.length];
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
        	public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1]-arr1[1];
                return arr1[0]-arr2[0];
            }

        });
        for(int i=0; i< arr.length; i++){
            arr[i] = envelopes[i][1];
        }
        
        return LIS(arr);
    }
    public int LIS(int[] arr){
        int[] s = new int[arr.length+1];
        int top = 0;
        for(int i=0; i<arr.length; i++){
            if(top==0 || s[top-1]<arr[i]){
                s[top++]=arr[i];
            }
            else{
                int idx = find(s, top-1, arr[i]);
                s[idx] = arr[i];
            }
        }
        return top;
    }
    public int find(int[] arr, int end, int tar){
        int l = 0;
        int r = end;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]>=tar){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}

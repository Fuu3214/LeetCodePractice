
public class maxsubarray {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max_local = 0;
        int max_global = 0;
        for(int i = 0; i < size; i++){
        	System.out.println(nums[i] + " " + max_local);
            max_local = (max_local + nums[i]) < 0? 0 : (max_local + nums[i]);
            max_global = Math.max(max_global, max_local);
            System.out.println(max_local + " " + max_global);
            System.out.println("-------------");
        }
        return max_global;
    }
}

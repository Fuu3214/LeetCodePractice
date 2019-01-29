import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
	private String s;
	private List<List<String>> ret;
	
	public List<List<String>> partition(String s) {
        int len = s.length();
        if(len == 0) return new ArrayList<>();
        List<String> path = new ArrayList<>();
        this.s = s;
        this.ret = new ArrayList<>();
        
        helper(0, s.length(), path);
		return ret;
    }
    
    public void helper(int start, int end, List<String> path){
    	if(start == end){
//        	System.out.println(path.toString());
            ret.add(new ArrayList<>(path));
            return;
        }
//        System.out.println(s + "  " + path.toString());
        for(int i=start+1; i<=end; i++){
            String str = s.substring(start, i);
//            System.out.println(str);
            if(!isPalin(str)) continue;
            

            path.add(str);
            helper(i, end, path);
            path.remove(path.size()-1);
        }
    }
    
    public boolean isPalin(String str){
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r))
                return false;
            r--;
            l++;
        }
        return true;
    }
}

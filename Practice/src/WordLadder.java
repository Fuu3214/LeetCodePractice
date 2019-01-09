
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
	class Solution1 {
	    public List<String> getLegal(String cur, int len, HashSet<String> wordDict){
	        List<String> legalAction = new ArrayList<>();
	        for(int i = 0; i < len; i++){
	            char[] tmp = cur.toCharArray();
	            for(char ch = 'a'; ch <='z'; ch++){
	                tmp[i] = ch;
	                String tmpStr = new String(tmp);
	                if(wordDict.contains(tmpStr)){
	                    legalAction.add(tmpStr);
	                }
	            }
	        }
	        return legalAction;
	    }
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        if(wordList.size() == 0) return 0;
	        int len = beginWord.length();
	        
	        HashSet<String> wordDict = new HashSet<>(wordList);
	        LinkedList<String> fringe = new LinkedList<>();
	        
	        fringe.add(beginWord);
	        
	        int level = 1;
	        while(!fringe.isEmpty()){
	            int size = fringe.size();
	            while(size > 0){
	                String cur = fringe.pop();
	                size--;
	                List<String> legalAction = getLegal(cur, len, wordDict);
	                //save legal action first then compare, faster
	                for(String action : legalAction){
	                    if(action.equals(endWord))
	                        return level + 1;
	                    fringe.add(action);
	                    wordDict.remove(action);
	                }
	            }
	            level++;
	        }
	        return 0;
	    }
	}  
	
	class Solution2 {
	    public Boolean getLegal(String cur, int len, HashSet<String> wordDict, HashSet<String> endSet, List<String> legalAction){
	        char[] tmp = cur.toCharArray();
	        for(int i = 0; i < len; i++){
	            char tmpCh = tmp[i];
	            for(char ch = 'a'; ch <='z'; ch++){
	                tmp[i] = ch;
	                String tmpStr = new String(tmp);
	                if(endSet.contains(tmpStr))
	                        return true;
	                if(ch!= tmpCh && wordDict.contains(tmpStr)){
	                    legalAction.add(tmpStr);
	                }
	            }
	            tmp[i] = tmpCh;
	        }
	        return false;
	    }
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        if(wordList.size() == 0) return 0;
	        int len = beginWord.length();
	        
	        HashSet<String> wordDict = new HashSet<>(wordList);
	        HashSet<String> beginSet = new HashSet<>();
	        HashSet<String> endSet = new HashSet<>();
	        
	        beginSet.add(beginWord);
	        endSet.add(endWord);
	        
	        int level = 1;
	        while(!beginSet.isEmpty()){
	            if(beginSet.size() > endSet.size()){
	                HashSet<String> tmp = beginSet;
	                beginSet = endSet;
	                endSet = tmp;
	            }
	            
	            HashSet<String> nextLevel = new HashSet<>();
	            for(String cur : beginSet){
	                List<String> legalAction = new ArrayList<>();
	                Boolean flag = getLegal(cur, len, wordDict, endSet, legalAction);
	                if(flag == true) return level + 1;
	                for(String action : legalAction){
	                    nextLevel.add(action);
	                    wordDict.remove(action);
	                }
	            }
	            beginSet = nextLevel;
	            
	            level++;
	        }
	        return 0;
	    }
	}
}

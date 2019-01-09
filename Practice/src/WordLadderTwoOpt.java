
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadderTwoOpt {
    public List<String> getLegal(String cur, HashSet<String> wordDict, int len){
        List<String> legalActions = new ArrayList<String>();
        char[] curCh = cur.toCharArray();
        for(int i = 0; i < len; i++){
            char tmp = curCh[i];
            for(char ch = 'a'; ch < 'z'; ch++){
                curCh[i] = ch;
                String tmpStr = new String(curCh);
                if(wordDict.contains(tmpStr)){
                    legalActions.add(tmpStr);
                }
            }
            curCh[i] = tmp;
        }
        return legalActions;
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> res = new ArrayList<>();
    	int len = endWord.length();
    	if(len == 0 || wordList.size() == 0) return res;
    	
    	HashSet<String> wordDict = new HashSet<>(wordList);
    	if(!wordDict.contains(endWord)) return res;
    	
    	HashMap<String, ArrayList<String>> prev = new HashMap<>();
    	BFSBI(prev, beginWord, endWord, len, wordDict);
//    	System.out.println(prev.toString());
    	
    	LinkedList<String> path = new LinkedList<>();
    	path.add(endWord);
    	DFS(prev, res, path, endWord, beginWord);
    	return res;
    }
    public void BFS(HashMap<String, ArrayList<String>> prev, String beginWord, String endWord, int len, HashSet<String> wordDict) {
    	LinkedList<String> fringe = new LinkedList<>();
    	fringe.add(beginWord);
    	Boolean flag = false;
    	while(!fringe.isEmpty()) {
    		int size = fringe.size();
    		HashSet<String> nodesNextLevel = new HashSet<>();
    		while(size > 0) {
    			String cur = fringe.pop();
    			size--;
    			List<String> legalActions = getLegal(cur, wordDict, len);
    			for(String action : legalActions) {
    				
					if(!prev.containsKey(action)) {
						prev.put(action, new ArrayList<>());
					}
					ArrayList<String> prevNodes = prev.get(action);
					prevNodes.add(cur);
					
    				if(action.equals(endWord)) {
    					flag = true;
    					break;
    				}
    				
    				if(!nodesNextLevel.contains(action)) {
    					nodesNextLevel.add(action);
    					fringe.add(action);
    				}
    			}
    		}
    		System.out.println(nodesNextLevel);
    		if(flag == true) {
    			return;
    		}
    		else {
    			wordDict.removeAll(nodesNextLevel);
    		}
    		System.out.println(wordDict);
    		System.out.println("======");
    	}
    }
    
    public Boolean getLegalBI(String cur, HashSet<String> endSet, int len, HashSet<String> wordDict, List<String> legalActions){
        char[] curCh = cur.toCharArray();
        Boolean flag = false;
        for(int i = 0; i < len; i++){
            char tmp = curCh[i];
            for(char ch = 'a'; ch < 'z'; ch++){
                curCh[i] = ch;
                String tmpStr = new String(curCh);
                
                if(endSet.contains(tmpStr)){
                	legalActions.add(tmpStr);
                	flag = true;
                }
                
                if(wordDict.contains(tmpStr)) {
                	legalActions.add(tmpStr);
                }
            }
            curCh[i] = tmp;
        }
        return flag;
    }
    
    public void BFSBI(HashMap<String, ArrayList<String>> prev, String beginWord, String endWord, int len, HashSet<String> wordDict) {
    	if(!wordDict.contains(endWord)) return;
    	HashSet<String> beginSet = new HashSet<>();
    	HashSet<String> endSet = new HashSet<>();
    	beginSet.add(beginWord);
    	endSet.add(endWord);
    	wordDict.remove(endWord);
    	Boolean flag = true;
    	while(!beginSet.isEmpty()) {
    		if(beginSet.size() > endSet.size()) {
    			HashSet<String> tmp = beginSet;
    			beginSet = endSet;
    			endSet = tmp;
    			flag = !flag;
    		}
    		
    		HashSet<String> nextLevel = new HashSet<>();
    		Boolean found = false;
    		for(String node : beginSet) {
    			List<String> legalActions = new ArrayList<>();
    			if(getLegalBI(node, endSet, len, wordDict, legalActions))
    				found = true;
    			for(String action : legalActions) {
    				if(!nextLevel.contains(action))
    					nextLevel.add(action);
					String par = flag? action : node;
					String chld = flag? node : action;
					if(!prev.containsKey(par)) {
						prev.put(par, new ArrayList<String>());
					}
					prev.get(par).add(chld);
    			}
    		}
    		if(found) return;
    		wordDict.removeAll(nextLevel);
    		beginSet = nextLevel;
    	}
    }
    public void DFS(HashMap<String, ArrayList<String>> prev, List<List<String>> res, LinkedList<String> path, String cur, String target) {
    	if(cur.equals(target)) {
			LinkedList<String> newPath = new LinkedList<String>(path);
			res.add(newPath);
		}
		else if(prev.containsKey(cur)){
			ArrayList<String> prevNodes = prev.get(cur);
	    	for(String node : prevNodes) {
	    		path.push(node);
	    		DFS(prev, res, path, node, target);
	    		path.pop();
	    	}
		}
    }
}

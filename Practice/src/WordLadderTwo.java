
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadderTwo {
    class Node{
        String name;
        ArrayList<String> path;
        HashSet<String> visitedByCurPath;
        Node(String name, ArrayList<String> path, HashSet<String> visitedByCurPath){
            this.name = name;
            this.path = path;
            this.visitedByCurPath = visitedByCurPath;
        }
    }
    public List<String> getLegal(Node cur, HashSet<String> wordDict, int len){
        List<String> legalActions = new ArrayList<String>();
        char[] curCh = cur.name.toCharArray();
        for(int i = 0; i < len; i++){
            char tmp = curCh[i];
            for(char ch = 'a'; ch < 'z'; ch++){
                curCh[i] = ch;
                String tmpStr = new String(curCh);
                if(wordDict.contains(tmpStr) && !cur.visitedByCurPath.contains(tmpStr)){
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
        HashSet<String> wordDict = new HashSet<>(wordList);
        
        if(wordList.size() == 0) return res;
        if(!wordDict.contains(endWord)) return res;
        
        ArrayList<String> path = new ArrayList<>();
        HashSet<String> visitedByCurPath = new HashSet<>();
        path.add(beginWord);
        visitedByCurPath.add(beginWord);
        Node root = new Node(beginWord, path, visitedByCurPath);
        
        LinkedList<Node> fringe = new LinkedList<Node>();
        fringe.add(root);
        
        Boolean flag = false;
        while(!fringe.isEmpty()){
            int size = fringe.size();
            while(size!=0){
                size--;
                Node cur = fringe.pop();
                List<String> legalActions = getLegal(cur, wordDict, len);

                for(String action : legalActions){
                    if(action.equals(endWord)){
                        flag = true;
                        path = new ArrayList<>(cur.path);
                        path.add(action);
                        res.add(path);
                        break;
                    }
                    else{
                        path = new ArrayList<>(cur.path);
                        visitedByCurPath = new HashSet<>(cur.visitedByCurPath);
                        path.add(action);
                        visitedByCurPath.add(action);
                        Node newNode = new Node(action, path, visitedByCurPath);
                        fringe.add(newNode);
                    }
                }
            }
            if(flag == true)
                return res;
        }
        return res;
    }
}

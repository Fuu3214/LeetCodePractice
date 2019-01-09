
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 			
		}
	};
	public class Solution {

	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	       
	        return DFS(node);
	    }
	    
	    public UndirectedGraphNode DFS(UndirectedGraphNode node){
	        if(node == null) return null;
	        
	        HashMap<Integer, UndirectedGraphNode> nodes = new HashMap<>();
	        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
	        nodes.put(node.label, root);
	        helper(nodes, node);
	        return root;
	    }
	    
	    public void helper(HashMap<Integer, UndirectedGraphNode> nodes, UndirectedGraphNode cur){
	        for(UndirectedGraphNode neighbor : cur.neighbors){
	            int label = neighbor.label;
	            if(!nodes.containsKey(label)){
	                nodes.put(label, new UndirectedGraphNode(label));
	                helper(nodes, neighbor);
	            }
	            nodes.get(cur.label).neighbors.add(nodes.get(label));
	        }
	    }
	    
	    public UndirectedGraphNode BFS(UndirectedGraphNode node){
	        if(node == null) return null;
	        
	        HashMap<Integer, UndirectedGraphNode> nodes = new HashMap<>();
	        LinkedList<UndirectedGraphNode> fringe = new LinkedList<>();
	        
	        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
	        fringe.add(node);
	        nodes.put(node.label, root);
	            
	        while(!fringe.isEmpty()){
	            UndirectedGraphNode cur = fringe.poll();
	            
	            for(UndirectedGraphNode neighbor : cur.neighbors){
	                int label = neighbor.label;
	                if(!nodes.containsKey(label)){
	                	//if not visit, visit, add to fringe, do not add unvisited node to fringe
	                    nodes.put(label, new UndirectedGraphNode(label));
	                    fringe.add(neighbor);
	                }
	                nodes.get(cur.label).neighbors.add(nodes.get(label));
	            }
	        }
	        
	        return root;
	    }
	}
}

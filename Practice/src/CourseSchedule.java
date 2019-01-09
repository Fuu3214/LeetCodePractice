
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null) return true;
        int[] indegree = new int[numCourses];
        
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            if(!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);
        }
        
        for(int i=0; i<prerequisites.length; i++){
            indegree[prerequisites[i][1]]++;
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) 
                q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int u = q.pop();
            count++;
            if(graph.containsKey(u)){
                ArrayList<Integer> adj = graph.get(u);
                for(int v:adj){
                    indegree[v]--;
                    if(indegree[v] == 0)
                        q.add(v);
                }
            }
        }
        
        if(count < numCourses)
            return false;
        else
            return true;
    }
	
	
	
	public boolean canFinishII(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null) return true;
        
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            if(!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(graph.containsKey(i)){
                if(!helper(graph, visited, onStack, i))
                    return false;
            }
        }
        return true;
    }
    
	boolean helper(HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, boolean[] onStack, int u){
        visited[u] = true;
        onStack[u] = true;
        boolean ret = true;
        if(graph.containsKey(u)){
            ArrayList<Integer> adj = graph.get(u);
            for(int v:adj){
                if(onStack[v]) {
                	ret = false;
                	break;
                }
                if(!visited[v]) {
                	ret = helper(graph, visited, onStack, v);
                	if(!ret) break;
                }
            }
        }
        onStack[u] = false;
        return ret;
    }
}

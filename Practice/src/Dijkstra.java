
import java.util.Arrays;

public class Dijkstra {
	int findMin(int[] dist, boolean[] spt) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0; i<dist.length; i++) {
			if(!spt[i] && dist[i]<=min) {
				min = dist[i];
				index = i;
			}
		}
		return index;
	}
	void shortestPath(int[][] graph, int src) {
		int V = graph.length;
		int[] dist = new int[V];
		boolean[] spt = new boolean[V];
		dist[src] = 0;
		spt[src] = true;
		
		for(int i=1; i<V; i++) {
			dist[i] = graph[src][i] == 0 ? Integer.MAX_VALUE : graph[src][i];
		}
		for(int cnt=0; cnt<V-1;cnt++) {
			int index = findMin(dist, spt);
			spt[index] = true;
			for(int i=0; i<V; i++) {
				if(!spt[i] && graph[index][i]!=0 && dist[index]!=Integer.MAX_VALUE && dist[i] > graph[index][i] + dist[index]) {
					dist[i] = graph[index][i] + dist[index];
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}
}

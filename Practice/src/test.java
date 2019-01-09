
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
//		int[] A = new int[]{-1,2,3,-7,5,4};
//		MergeSort ms = new MergeSort();
//		int cnt = ms.sort(A, 0, A.length-1);
//		System.out.println(Arrays.toString(A));
//		System.out.println(cnt);
		
//		QuickSort qs = new QuickSort();
//		int pos = qs.sort(A, 0, A.length-1, 20);
//		System.out.println(pos);
		
//		LongestPalindromic lp = new LongestPalindromic();
//		System.out.println(lp.longestPalindrome("abcba"));
		
//		maxsubarray ma = new maxsubarray();
//		System.out.println(ma.maxSubArray(A));
		
//		LongestSubStringWithoutRepeating lswr = new LongestSubStringWithoutRepeating();
//		String s = "abcbacd";
//		System.out.println(lswr.lengthOfLongestSubstring(s));
		
//		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
//		int[] A = new int[]{100, 4, 200, 1, 3, 2};
//		System.out.println(lcs.longestConsecutive(A));
		
//		LinkedList<Integer> lst = new LinkedList<>();
//		lst.add(1);
//		lst.add(2);
//		System.out.println(lst.poll());
		
//		WordLadderTwoOpt wlt = new WordLadderTwoOpt();
//		String beginWord = "hit";
//		String endWord = "cog";
//		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","dit","hig", "dig", "cog");
//		
//		System.out.println(wlt.findLadders(beginWord, endWord, wordList).toString());
		
//		LongestIncreasingPath lip = new LongestIncreasingPath();
//		int[][] input = new int[][] {{3,4,5}, {3,2,6}, {2,2,1}};
//		System.out.println(lip.longestIncreasingPath(input));
		
//		UglyNumberII un = new UglyNumberII();
//		System.out.println(un.nthUglyNumber(2333));
		
//		CourseSchedule cs = new CourseSchedule();
//		int[][] input = new int[][] {{0,1}, {0,2},{1,0}};
//		System.out.println(cs.canFinishII(6, input));
		
		Dijkstra sp = new Dijkstra();
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
           }; 
           sp.shortestPath(graph, 0);
	}
}

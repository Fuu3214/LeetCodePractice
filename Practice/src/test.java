
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
//		int[] A = new int[]{-1,2,3,-7,5,4};
//		MergeSort ms = new MergeSort();
//		int cnt = ms.sort(A, 0, A.length-1);
//		System.out.println(Arrays.toString(A));
//		System.out.println(cnt);
		
//		QuickSort qs = new QuickSort();
//		int pos = qs.sort(A, 0, A.length-1, 2);
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
		
//		Dijkstra sp = new Dijkstra();
//		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
//            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
//            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
//            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
//            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
//            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
//            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
//            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
//            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
//           }; 
//           sp.shortestPath(graph, 0);
		
//		int[] A = new int[]{1,2,3,4,5,6};
//		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
//		System.out.println(lis.lengthOfLIS(A));
		
//		EditDistance ed = new EditDistance();
//		System.out.println(ed.minDistanceOpt("horse", "ros"));
	
//		PalindromePartitioningII ppii = new PalindromePartitioningII();
//		String str = "aaab";
//		System.out.println(ppii.minCut(str));
		
//		MinimumWindowSubstring mws = new MinimumWindowSubstring();
//		String s = "ADOBECODEBANC";
//		String t = "ABC";
//		System.out.println(mws.minWindow(s, t));
		
//		SlidingWindowMaximum swm = new SlidingWindowMaximum();
//		int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//		System.out.println(Arrays.toString(swm.maxSlidingWindow(nums, 3)));
		
//		MinimumASCIIDeleteSum mads = new MinimumASCIIDeleteSum();
//		mads.minimumDeleteSum("delete", "leet");
		
//		LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
//		int[] heights = new int[]{2,1,5,6,2,3};
//		System.out.println(lrih.largestRectangleArea2(heights));
		
		RussianDoll rd = new RussianDoll();
		int[][] input = new int[][] {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(rd.maxEnvelopes(input));
	}
}

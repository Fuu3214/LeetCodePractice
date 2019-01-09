
public class MergeSort {
	public int merge(int[] A, int l, int m, int r) {
		int i = l;
		int j = m + 1;
		int k = 0;
		int cnt = 0;
		int[] B = new int[r-l+1];
		
		while(i <= m && j <= r) {
			if(A[i] > A[j]) {
				cnt += r - j + 1;
				B[k++] = A[i++];
			}
			else B[k++] = A[j++];
		}
		while(i <= m) B[k++] = A[i++];
		while(j <= r) B[k++] = A[j++];
		
		for(i = l; i <= r; i++) {
			A[i] = B[i - l];
		}
		return cnt;
	}
	public int sort(int []A, int l, int r) {
		int cnt = 0;
		if(l < r) {
			int m = l + (r - l)/2;
			cnt += sort(A, l, m);
			cnt += sort(A, m+1,r);
			cnt += merge(A, l, m, r);
		}
		return cnt;
	}
}

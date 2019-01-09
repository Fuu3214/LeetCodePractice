
import java.util.Arrays;

public class QuickSort {
	public void swap(int[]A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	public int partition(int[] A, int l, int r) {
		int p = l;
		int leftwall = l;
		int value = A[p];
		
		for(int i = l; i <=r; i++) {
			if(A[i] < value) {
				swap(A, i, leftwall + 1);
				leftwall++;
			}
		}
		swap(A, p, leftwall);
		return leftwall;
	}
	public int sort(int[] A, int l, int r, int k) {
		if(l < r) {
			int p = partition(A, l, r);
//			System.out.println(Arrays.toString(A) + " " + p);
			if(p - l == k - 1)
				return A[p];
			else if(p - l > k - 1)
				return sort(A, l, p, k);
			else
				return sort(A, p+1,r, k - (p - l) - 1);
		}
		return -1;
	}
}

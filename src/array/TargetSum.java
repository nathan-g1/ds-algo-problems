import java.util.Arrays;
public class TargetSum {

	// This algorithm is based on two pointers to get
	// the given target sum
	// NB: Expects a sorted input array to get the right answer
	public static void main(String[] args) {
		System.out.println(Arrays.toString(targetSum(new int[] {1,2,3,4,5,7,9,12,13,14,16}, 14)));
	}

	// targetSum returns the index of the pair for the
	// elements that add up to the target
	public static int[] targetSum(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			int sum = (arr[start] +  arr[end]);
			if (sum < target) {
				++start;
			} else if (sum == target) {
				return new int[] { arr[start], arr[end] };
			} else {
				--end;
			}
		}
		return new int[] {};		
	}
}

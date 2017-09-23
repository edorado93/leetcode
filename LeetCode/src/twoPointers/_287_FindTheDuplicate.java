package twoPointers;

/**
 * 
 * Problem:
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only).
 * 
 * You must use only constant, O(1) extra space.
 * 
 * Your runtime complexity should be less than O(n2).
 * 
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 *
 */
public class _287_FindTheDuplicate {
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return -1;
		}
		int slow = nums[0];
		int fast = nums[nums[0]];
		// fast meet the slow.
		while (slow != fast) {
			if (slow == nums[slow]) { // optimization
				return slow;
			}
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		// find the start point of cycle
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}

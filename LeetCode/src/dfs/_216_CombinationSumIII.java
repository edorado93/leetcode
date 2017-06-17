package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author chengfeili 
 * Jun 17, 2017 4:23:05 PM
 * 
 *         Problem: Find all possible combinations of k numbers that add up to a
 *         number n, given that only numbers from 1 to 9 can be used and each
 *         combination should be a unique set of numbers.
 * 
 *         Example 1:
 * 
 *         Input: k = 3, n = 7
 * 
 *         Output:
 * 
 *         [[1,2,4]]
 * 
 *         Example 2:
 * 
 *         Input: k = 3, n = 9
 * 
 *         Output:
 * 
 *         [[1,2,6], [1,3,5], [2,3,4]]
 *
 *         Solution:
 * 
 *         Time Complexity:
 * 
 *         Space Complexity:
 *
 */
public class _216_CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<Integer>(), k, n, 1);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
		if (list.size() == k && n == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <= 9; i++) {
			list.add(i);
			helper(res, list, k, n - i, i + 1);
			list.remove(list.size() - 1);
		}
	}
}

package unionFind;

import java.util.Arrays;

/**
 * 
 * Problem:
 * 
 * There are N students in a class. Some of them are friends, while some are
 * not. Their friendship is transitive in nature. For example, if A is a direct
 * friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or
 * indirect friends.
 * 
 * Given a N*N matrix M representing the friend relationship between students in
 * the class. If M[i][j] = 1, then the ith and jth students are direct friends
 * with each other, otherwise not. And you have to output the total number of
 * friend circles among all the students.
 * 
 * Example 1: Input: [[1,1,0], [1,1,0], [0,0,1]] Output: 2 Explanation:The 0th
 * and 1st students are direct friends, so they are in a friend circle. The 2nd
 * student himself is in a friend circle. So return 2.
 * 
 * Example 2: Input: [[1,1,0], [1,1,1], [0,1,1]] Output: 1 Explanation:The 0th
 * and 1st students are direct friends, the 1st and 2nd students are direct
 * friends, so the 0th and 2nd students are indirect friends. All of them are in
 * the same friend circle, so return 1.
 * 
 * Note: N is in range [1,200]. M[i][i] = 1 for all students. If M[i][j] = 1,
 * then M[j][i] = 1.
 *
 */
public class _547_FriendCircles {
	/**
	 * Method 1: Union Find
	 * 
	 * Time Complexity: O(N^3)
	 * 
	 * Space Complexity: O(N)
	 */
	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0) {
			return 0;
		}
		int len = M.length;
		int[] parent = new int[len];
		Arrays.fill(parent, -1);
		// union all the friend circle
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (M[i][j] == 1 && i != j) {
					union(parent, i, j);
				}
			}
		}
		// count the number of friend circles
		int res = 0;
		for (int i = 0; i < len; i++) {
			if (parent[i] == -1) {
				res++;
			}
		}
		return res;
	}

	private int find(int[] parent, int i) {
		if (parent[i] == -1) {
			return i;
		}
		parent[i] = find(parent, parent[i]);
		return parent[i];
	}

	private void union(int[] parent, int i, int j) {
		int parentI = find(parent, i);
		int parentJ = find(parent, j);
		if (parentI != parentJ) {
			parent[parentI] = parentJ;
		}
	}

	/**
	 * Method 2: BFS
	 * 
	 * Time Complexity: O(N^2)
	 * 
	 * Space Complexity: O(N)
	 */
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
	private class ResultType {
		public TreeNode node;
		public int size;
		public int sum;

		public ResultType (TreeNode node, int size, int sum) {
			this.TreeNode = node;
			this.size = size;
			this.sum = summ;
		}
	}

	private ResultType subtreeResult = new ResultType(null, 0, 0);


	public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return subtreeResult.node;
    }

    private ResultType helper(TreeNode root) {
    	if (root == null) {
    		return new ResultType(null, 0, 0);
    	}

    	ResultType left = helper(root.left);
    	ResultType right = helper(root.right);

    	ResultType result = new ResultType(root, left.size + right.size + 1, left.sum + right.sum + root.val);


    	if (subtreeResult.node = null || subtreeResult.sum * 1.0 / subtreeResult.size < result.sum * 1.0 / result.size) {
    		subtreeResult = result;
    	}
    	return result;
    }

}
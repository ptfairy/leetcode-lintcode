// Divide and conquer
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
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        
        if (root == null) {
        	return 0;
        }
        // 一棵树的最大深度等于它的左右子树的深度最大值 + 1，每棵子树又有它的左右子树
        // divide 
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // conquer
        return Math.max(left, right) + 1；
    }
}

//Traverse

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    // 在函数前定义ResultType类和全局变量
    private int depth = 0;

    public int maxDepth(TreeNode root) {
        // write your code here
    	helper(root, 1);
    	return depth;
    }

    private void helper(TreeNode node, int curDepth) {
    	if (node == null) {
    		return;
    	}

    	if (curDepth > depth) {
    		depth = curDepth;
    	}

    	helper(node.left, curDepth + 1);
    	helper(node.right, curDepth + 1);
    		
    }
}
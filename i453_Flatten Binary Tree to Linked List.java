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

// version1: traverse

public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
        	return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null; 
        prev = root;
    }
}

// version2: divide & conquer

public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */

    // flatten函数为void类型没有返回值，所以需要helper函数，如果有返回值的话本身可以作为helper函数
    public void flatten(TreeNode root) {
    	helper(root);
    }
    
    // helper函数返回当前root flattened后的末端节点
    private TreeNode helper(TreeNode root) {
    	if (root == null) {
        	return null;
        }
        
    	TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        // 把flattened的左子树放在根节点和flattened的右子树中间
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // determine the return value 
        // 如果rightLast不是null说明插入flattened的左子树后整个当前root的flattened树的末端节点为rightLast
        if (rightLast != null) {
        	return rightLast;
        }

        // 如果rightLast是null则整个树的末端节点为leftLast
        if (leftLast != null) {
        	return leftLast;
        }

        return root;

    }    
}
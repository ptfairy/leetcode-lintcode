public class Solution {
	public List<String> binaryTreePaths(TreeNode root){
		List<String> results = new ArrayList<String>();
		if (root == null) {
			return results;
		}
		helper(results, root, "");
		return results
	}

	private void helper(List<String> results, TreeNode root, String path) {
		if (root.left == null && root.right == null) {
			results.add(path + root.val);
		}
		if (root.left != null) {
			helper(results, root.left, path + root.val + "->");
		}
		if (root.right != null) {
			helper(results, root.right, path + root.val + "->");
		}
	}
}
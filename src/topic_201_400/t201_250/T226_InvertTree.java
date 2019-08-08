package topic_201_400.t201_250;

/**
 * T226_InvertTree
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author : wy.
 * @date : Create at 9:24 2019/8/8
 */
public class T226_InvertTree {
	public TreeNode invertTree(TreeNode root) {
		invertNode(root);
		return root;
	}

	private void invertNode(TreeNode currentNode) {
		if (currentNode == null) return;
		TreeNode left = currentNode.left;
		currentNode.left = currentNode.right;
		currentNode.right = left;
		invertNode(currentNode.left);
		invertNode(currentNode.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		T226_InvertTree invertTree = new T226_InvertTree();
		invertTree.invertTree(root);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}

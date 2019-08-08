package topic_201_400.t301_350;

/**
 * T323_MaxDepth
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * 9  20
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author : wy.
 * @date : Create at 10:14 2019/8/8
 */
public class T323_MaxDepth {

	int max = 0;

	public int maxDepth(TreeNode root) {
		round(root, 0);
		return max;
	}

	private void round(TreeNode node, int depth) {
		if (node == null) {
			max = depth > max ? depth : max;
			return;
		}
		depth++;
		round(node.left, depth);
		round(node.right, depth);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		T323_MaxDepth maxDepth = new T323_MaxDepth();
		System.out.println(maxDepth.maxDepth(root));
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

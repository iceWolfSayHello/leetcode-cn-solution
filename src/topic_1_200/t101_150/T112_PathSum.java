package topic_1_200.t101_150;

import topic_1_200.t51_100.T98_ValidBST;

/**
 * T112_PathSum
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 *
 * @author : wy.
 * @date : Create at 11:48 2019/8/9
 */
public class T112_PathSum {

	//本人采用当前值与最终值比较的方法进行解答，思路不是最优解，官方解答更优，详见hasPathSumOfficial
	public boolean hasPathSum(TreeNode root, int sum) {
		return pathSum(root, 0, sum);
	}

	private boolean pathSum(TreeNode node, int currentSum, int finalSum) {
		if (node == null) {
			return false;
		}
		//若当前节点为叶子节点并且相加和为最终值，则返回true
		if (node.left == null && node.right == null && currentSum + node.val == finalSum) {
			return true;
		}





		return pathSum(node.left, currentSum + node.val, finalSum)
				|| pathSum(node.right, currentSum + node.val, finalSum);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right = new TreeNode(1);
		T112_PathSum pathSum = new T112_PathSum();
		System.out.println(pathSum.hasPathSum(root, 17));
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//官方解答
	public boolean hasPathSumOfficial(TreeNode root, int sum) {
		if (root == null)
			return false;

		sum -= root.val;
		if ((root.left == null) && (root.right == null))
			return (sum == 0);
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
}

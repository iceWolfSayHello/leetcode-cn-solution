package topic_1_200.t51_100;

/**
 * T98_ValidBST
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author : wy.
 * @date : Create at 10:32 2019/8/9
 */
public class T98_ValidBST {

	//实际上BST不仅要求左孩子小于当前节点，右孩子大于当前节点，并且左子树的所有节点及右子树的所有节点均要小于/大于
	//因此，可采用上界/下界的方式，将父级节点的值向下传递，本次采用递归方式进行解决
	public boolean isValidBST(TreeNode root) {
		return valid(root, null, null);
	}

	private boolean valid(TreeNode node, Integer upper, Integer lower) {
		if (node == null) {
			return true;
		}
		if (upper != null && node.val >= upper) {
			return false;
		}
		if (lower != null && node.val <= lower) {
			return false;
		}
		//左子树节点是否都小于
		if (!valid(node.left, node.val, lower)) {
			return false;
		}
		//右子树节点是否都大于
		if (!valid(node.right, upper, node.val)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(9);
		T98_ValidBST validBST = new T98_ValidBST();
		System.out.println(validBST.isValidBST(root));
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

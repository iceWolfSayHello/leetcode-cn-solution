package topic_1_200.t51_100;

/**
 * T70_ClimbStairs
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author ：wy.
 * @date ：Created at 下午2:17 19-7-11
 */
public class T70_ClimbStairs {

	private int climbStairs(int n) {
		int[] memo = new int[n];
		return climb(0, n, memo);
	}

	private int climb(int now, int all, int[] memo) {
		if (now == all) {
			return 1;
		} else if (now > all) {
			return 0;
		}
		if (memo[now] != 0) {
			return memo[now];
		}
		memo[now] = climb(now + 1, all, memo) + climb(now + 2, all, memo);
		return memo[now];
	}

	public static void main(String[] args) {
		T70_ClimbStairs climbStairs = new T70_ClimbStairs();
		System.out.println(climbStairs.climbStairs(3));
	}
}

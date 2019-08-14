package topic_201_400.t301_350;

/**
 * T322_coinChange
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * @author : wy.
 * @date : Create at 10:15 2019/8/14
 */
public class T322_coinChange {

	//递推公式为：minCount[amount] = min(minCount[amount],minCount[amount-currentCoin]+1)
	// minCount数组用于存储amount价值时最少钱币的数量
	// currentCoin为遍历的当前的钱币价值
	public int coinChange(int[] coins, int amount) {
		int[] minCount = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			minCount[i] = amount + 1;
		}
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					minCount[i] = Math.min(minCount[i], minCount[i - coin] + 1);
				}
			}
		}
		return minCount[amount] > amount ? -1 : minCount[amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		T322_coinChange coinChange = new T322_coinChange();
		System.out.println(coinChange.coinChange(coins, 11));
	}
}

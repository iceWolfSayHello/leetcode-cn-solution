package topic_1_200.t101_150;

/**
 * T121_MaxProfit
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author : wy.
 * @date : Create at 9:53 2019/8/14
 */
public class T121_MaxProfit {

	//该问题可转化为最小价格与其后的最高价格差值
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) minPrice = prices[i];
			if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = {7, 6, 4, 3, 1};
		T121_MaxProfit maxProfit = new T121_MaxProfit();
		System.out.println(maxProfit.maxProfit(prices));
	}
}

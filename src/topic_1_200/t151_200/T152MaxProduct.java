package topic_1_200.t151_200;

/**
 * T152MaxProduct
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author : wy.
 * @date : Create at 9:21 2019/8/23
 */
public class T152MaxProduct {

	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE, subMax = 1, subMin = 1;
		for(int i=0; i<nums.length; i++){
			if(nums[i] < 0){
				int tmp = subMax;
				subMax = subMin;
				subMin = tmp;
			}
			subMax = Math.max(subMax*nums[i], nums[i]);
			subMin = Math.min(subMin*nums[i], nums[i]);
			max = Math.max(max, subMax);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {-1,2,3};
		T152MaxProduct maxProduct = new T152MaxProduct();
		System.out.println(maxProduct.maxProduct(nums));
	}
}
